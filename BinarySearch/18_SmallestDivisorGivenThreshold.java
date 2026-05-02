// Problem : Find the Smallest Divisor Given a Threshold
// Platform : Striver A2Z 
// Approach : Brute force
// Time Complexity : O(max(arr[])*N)
// Space Complexity : O(1)

class Solution {
    // Method to find the smallest divisor such that the sum of ceiling divisions <= limit
    public int smallestDivisor(int[] arr, int limit) {
        int n = arr.length;

        // Find the maximum element in the array
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }

        // Try all possible divisors from 1 to max
        for (int d = 1; d <= max; d++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                // Divide each number by d and take the ceiling
                sum += (int) Math.ceil((double) arr[i] / d);
            }

            // If the total sum is within the limit, return this divisor
            if (sum <= limit) {
                return d;
            }
        }

        return -1; // No valid divisor found
    }
}

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int limit = 8;

        Solution obj = new Solution();
        int ans = obj.smallestDivisor(arr, limit);
        System.out.println("The minimum divisor is: " + ans);
    }
}



// Approach : Optimal
// Time Complexity : O(log(max(arr[]))*N)
// Space Complexity : O(1)

import java.util.*;

class SmallestDivisorFinder {
    // Helper method to calculate sum by divisor
    private int sumByD(int[] arr, int div) {
        int sum = 0;
        for (int num : arr) {
            sum += Math.ceil((double) num / div);
        }
        return sum;
    }

    // Method to find the smallest divisor using binary search
    public int smallestDivisor(int[] arr, int limit) {
        if (arr.length > limit) return -1;

        int low = 1;
        int high = Arrays.stream(arr).max().getAsInt();

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sumByD(arr, mid) <= limit) {
                high = mid - 1; // Try smaller divisor
            } else {
                low = mid + 1;  // Try larger divisor
            }
        }

        return low;
    }

    public static void main(String[] args) {
        SmallestDivisorFinder solver = new SmallestDivisorFinder();
        int[] arr = {1, 2, 3, 4, 5};
        int limit = 8;
        int result = solver.smallestDivisor(arr, limit);
        System.out.println("The minimum divisor is: " + result);
    }
}
