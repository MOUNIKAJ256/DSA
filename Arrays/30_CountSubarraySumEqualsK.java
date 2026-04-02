// Problem : Count Subarray sum Equals K
// Platform : Striver A2Z 
// Approach : Brute Force
// Time Complexity : O(n^3)
// Space Complexity : O(1)

import.java.util.*;
class Solution {
    // Function to find count of subarrays with sum equal to k
    public int subarraySum(int[] arr, int k) {
        // Size of the array
        int n = arr.length;

        // Initialize count of subarrays
        int count = 0;

        // Traverse all possible start indices
        for (int i = 0; i < n; i++) {
            // Traverse all possible end indices from start
            for (int j = i; j < n; j++) {
                // Initialize sum for current subarray
                int sum = 0;

                // Calculate sum of subarray from i to j
                for (int m = i; m <= j; m++) {
                    sum += arr[m];
                }

                // If sum equals k, increment count
                if (sum == k) {
                    count++;
                }
            }
        }

        // Return total count of subarrays
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        // Input array
        int[] arr = {3, 1, 2, 4};

        // Target sum
        int k = 6;

        // Create Solution object
        Solution sol = new Solution();

        // Call function and store result
        int result = sol.subarraySum(arr, k);

        // Print the count of subarrays
        System.out.println("The number of subarrays is: " + result);
    }
}



// Approach : Better
// Time Complexity : O(n^2)
// Space Complexity : O(1)

import.java.util.*;
class Solution {
    // Function to find count of subarrays with sum equal to k
    public int subarraySum(int[] arr, int k) {
        // Size of the array
        int n = arr.length;

        // Initialize count of subarrays
        int count = 0;

        // Traverse all possible start indices
        for (int i = 0; i < n; i++) {
            // Initialize sum for current subarray
            int sum = 0;

            // Traverse all possible end indices from start
            for (int j = i; j < n; j++) {
                // Add current element to sum
                sum += arr[j];

                // If sum equals k, increment count
                if (sum == k) {
                    count++;
                }
            }
        }

        // Return total count of subarrays
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        // Input array
        int[] arr = {3, 1, 2, 4};

        // Target sum
        int k = 6;

        // Create Solution object
        Solution sol = new Solution();

        // Call function and store result
        int result = sol.subarraySum(arr, k);

        // Print the count of subarrays
        System.out.println("The number of subarrays is: " + result);
    }
}



// Approach : Optimal
// Time Complexity : O(n)
// Space Complexity : O(n)

import java.util.HashMap;

class Solution {
    // Function to find count of subarrays with sum equal to k using prefix sums and hashmap
    public int subarraySum(int[] arr, int k) {
        // Size of the array
        int n = arr.length;

        // Map to store frequency of prefix sums
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();

        // Initialize prefix sum and count of subarrays
        int prefixSum = 0;
        int count = 0;

        // Base case: prefix sum 0 has occurred once
        prefixSumCount.put(0, 1);

        // Traverse through the array
        for (int i = 0; i < n; i++) {
            // Add current element to prefix sum
            prefixSum += arr[i];

            // Calculate the prefix sum that needs to be removed
            int remove = prefixSum - k;

            // If this prefix sum has been seen before,
            // add its count to the result
            if (prefixSumCount.containsKey(remove)) {
                count += prefixSumCount.get(remove);
            }

            // Update the frequency of the current prefix sum
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }

        // Return the total count of subarrays
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        // Input array
        int[] arr = {3, 1, 2, 4};

        // Target sum
        int k = 6;

        // Create Solution object
        Solution sol = new Solution();

        // Call function and store result
        int result = sol.subarraySum(arr, k);

        // Print the count of subarrays
        System.out.println("The number of subarrays is: " + result);
    }
}
