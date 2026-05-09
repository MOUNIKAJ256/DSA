// Problem : Split Array - Largest Sum
// Platform : Striver A2Z 
// Approach : Brute force
// Time Complexity : O(N * (sum(arr[])-max(arr[])+1))
// Space Complexity : O(1)

import java.util.*;

class SubarrayPartitioner {
    // Counts how many partitions are needed for a given maxSum limit
    public int countPartitions(int[] a, int maxSum) {
        int n = a.length; // size of array
        int partitions = 1; // at least one partition
        long subarraySum = 0; // sum of current subarray

        for (int i = 0; i < n; i++) {
            // Add to current subarray if possible
            if (subarraySum + a[i] <= maxSum) {
                subarraySum += a[i];
            } else {
                // Start new subarray
                partitions++;
                subarraySum = a[i];
            }
        }
        return partitions;
    }

    // Finds the smallest possible largest subarray sum to get exactly k partitions
    public int largestSubarraySumMinimized(int[] a, int k) {
        int low = Arrays.stream(a).max().getAsInt(); // max element
        int high = Arrays.stream(a).sum(); // sum of all elements

        // Brute-force from low to high
        for (int maxSum = low; maxSum <= high; maxSum++) {
            if (countPartitions(a, maxSum) == k) {
                return maxSum;
            }
        }
        return low; // fallback
    }

    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40};
        int k = 2;
        SubarrayPartitioner sp = new SubarrayPartitioner();
        int ans = sp.largestSubarraySumMinimized(a, k);
        System.out.println("The answer is: " + ans);
    }
}



// Approach : Optimal
// Time Complexity : O(N * log(sum(arr[])-max(arr[])+1))
// Space Complexity : O(1)

import java.util.*;

class SubarrayPartitioner {
    // Counts how many partitions are needed for a given maxSum
    public int countPartitions(int[] a, int maxSum) {
        int partitions = 1; // at least one partition
        long subarraySum = 0; // sum of current subarray

        for (int num : a) {
            if (subarraySum + num <= maxSum) {
                subarraySum += num;
            } else {
                partitions++;
                subarraySum = num;
            }
        }
        return partitions;
    }

    // Finds the minimum largest subarray sum possible for at most k partitions
    public int largestSubarraySumMinimized(int[] a, int k) {
        int low = Arrays.stream(a).max().getAsInt(); // largest element
        int high = Arrays.stream(a).sum(); // sum of all elements

        // Binary search for the smallest maxSum
        while (low <= high) {
            int mid = (low + high) / 2;
            int partitions = countPartitions(a, mid);

            if (partitions > k) {
                low = mid + 1; // too many partitions → increase maxSum
            } else {
                high = mid - 1; // valid but try smaller maxSum
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40};
        int k = 2;
        SubarrayPartitioner sp = new SubarrayPartitioner();
        int ans = sp.largestSubarraySumMinimized(a, k);
        System.out.println("The answer is: " + ans);
    }
}
