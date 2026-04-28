// Problem : Finding Sqrt of a number using Binary Search
// Platform : Striver A2Z 
// Approach : Brute force
// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.*;

class Solution {
    // Function to find floor of square root using linear search
    public int floorSqrt(int n) {
        // Variable to store answer
        int ans = 0;

        // Run loop from 1 to n
        for (int i = 1; i <= n; i++) {
            // Check if i*i <= n
            if ((long)(i) * i <= n) {
                // Update answer
                ans = i;
            } else {
                // Break when i*i > n
                break;
            }
        }
        // Return final answer
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        // Example input
        int n = 27;

        // Create object of Solution
        Solution sol = new Solution();

        // Call function and print result
        System.out.println(sol.floorSqrt(n));
    }
}



// Approach : Optimal
// Time Complexity : O(logn)
// Space Complexity : O(1)

import java.util.*;

class Solution {
    // This function returns the floor value of the square root of a number
    public int mySqrt(int x) {
        // Handle small numbers directly
        if (x < 2) return x;

        // Initialize binary search range
        int left = 1, right = x / 2, ans = 0;

        // Perform binary search
        while (left <= right) {
            // Find middle point
            long mid = left + (right - left) / 2;

            // Check if mid*mid is less than or equal to x
            if (mid * mid <= x) {
                // Store mid as potential answer
                ans = (int) mid;
                // Move to right half
                left = (int) mid + 1;
            } else {
                // Move to left half
                right = (int) mid - 1;
            }
        }

        // Return final answer
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.mySqrt(8));
    }
}
