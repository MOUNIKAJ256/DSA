// Problem : Maximum Product Subarray in an Array
// Platform : Striver A2Z 
// Approach : Brute Force
// Time Complexity : O(n ^ 2)
// Space Complexity : O(1)

import java.util.*;

class Solution {
    // This function finds the maximum product
    // of any contiguous subarray using brute force
    public int maxProduct(int[] nums) {
        // Initialize the answer with the first element
        int maxProd = nums[0];

        // Outer loop picks the starting index
        for (int i = 0; i < nums.length; i++) {
            // Initialize current product to 1
            int prod = 1;

            // Inner loop picks the ending index
            for (int j = i; j < nums.length; j++) {
                // Multiply current number to product
                prod *= nums[j];

                // Update maximum product if needed
                maxProd = Math.max(maxProd, prod);
            }
        }

        // Return the result
        return maxProd;
    }
}

public class Main {
    public static void main(String[] args) {
        // Sample input
        int[] nums = {2, 3, -2, 4};

        // Create Solution object
        Solution sol = new Solution();

        // Print the result
        System.out.println(sol.maxProduct(nums));
    }
}



// Approach : Optimal_1
// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.*;

// This class contains the function to find maximum product subarray
// using prefix and suffix traversal
class Solution {
    public int maxProductSubArray(int[] arr) {
        // Get the length of the array
        int n = arr.length;

        // Initialize prefix and suffix product
        int pre = 1, suff = 1;

        // Initialize answer with smallest integer
        int ans = Integer.MIN_VALUE;

        // Traverse from both left and right
        for (int i = 0; i < n; i++) {
            // Reset prefix if zero
            if (pre == 0) pre = 1;

            // Reset suffix if zero
            if (suff == 0) suff = 1;

            // Multiply prefix with current element from front
            pre *= arr[i];

            // Multiply suffix with current element from back
            suff *= arr[n - i - 1];

            // Update maximum value so far
            ans = Math.max(ans, Math.max(pre, suff));
        }

        // Return the final result
        return ans;
    }
}

// Separate Main class for testing
class Main {
    public static void main(String[] args) {
        // Sample input
        int[] arr = {2, 3, -2, 4};

        // Create object of Solution
        Solution sol = new Solution();

        // Call the method and print the result
        System.out.println(sol.maxProductSubArray(arr));
    }
}



// Approach : Optimal_2
// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.*;

class Solution {
    // This function returns the maximum product
    // of any contiguous subarray using optimized approach
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int maxProd = nums[0];
        int minProd = nums[0];

        // Traverse from second element
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            // Swap if current is negative
            if (curr < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            // Update max and min product
            maxProd = Math.max(curr, maxProd * curr);
            minProd = Math.min(curr, minProd * curr);

            // Update result
            res = Math.max(res, maxProd);
        }

        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        Solution sol = new Solution();
        System.out.println(sol.maxProduct(nums));
    }
}
