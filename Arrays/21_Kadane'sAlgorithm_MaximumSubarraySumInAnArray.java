// Problem : Kadane's Algorithm : Maximum Subarray Sum in an Array
// Platform : Strivers A2Z 
// Approach : Brute Force
// Time Complexity : O(n^3)
// Space Complexity : O(1)

import java.util.*;
class Solution {
    // Function to find maximum sum of subarrays
    public int maxSubArray(int[] nums) {
        
        /* Initialize maximum sum with
           the smallest possible integer */
        int maxi = Integer.MIN_VALUE;

        // Iterate over each starting index of subarrays
        for (int i = 0; i < nums.length; i++) {
            
            /* Iterate over each ending index
               of subarrays starting from i */
            for (int j = i; j < nums.length; j++) {
                
                /* Variable to store the sum
                   of the current subarray */
                int sum = 0;

                // Calculate the sum of subarray nums[i...j]
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }

                /* Update maxi with the maximum of its current
                   value and the sum of the current subarray */
                maxi = Math.max(maxi, sum);
            }
        }

        // Return the maximum subarray sum found
        return maxi;
    }
}

// Separate Main class
public class Main {
    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        // Create an instance of Solution class
        Solution sol = new Solution();

        int maxSum = sol.maxSubArray(arr);

        // Print the max subarray sum
        System.out.println("The maximum subarray sum is: " + maxSum);
    }
}



// Approach : Better
// Time Complexity : O(n^2)
// Space Complexity : O(1)

import java.util.*;
class Solution {
    // Function to find maximum sum of subarrays
    public int maxSubArray(int[] nums) {
        
        /* Initialize maximum sum with
           the smallest possible integer */
        int maxi = Integer.MIN_VALUE;

        // Iterate over each starting index of subarrays
        for (int i = 0; i < nums.length; i++) {
            
            /* Variable to store the sum
               of the current subarray */
            int sum = 0; 
            
            /* Iterate over each ending index
               of subarrays starting from i */
            for (int j = i; j < nums.length; j++) {
                
                /* Add the current element nums[j] to
                   the sum i.e. sum of nums[i...j-1] */
                sum += nums[j];

                /* Update maxi with the maximum of its current
                   value and the sum of the current subarray */
                maxi = Math.max(maxi, sum);
            }
        }

        // Return the maximum subarray sum found
        return maxi;
    }
}

// Separate Main class in the same file
public class Main {
    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        // Create an instance of Solution class
        Solution sol = new Solution();

        int maxSum = sol.maxSubArray(arr);

        // Print the max subarray sum
        System.out.println("The maximum subarray sum is: " + maxSum);
    }
}



// Approach : Optimal
// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.*;
class Solution {
    // Function to find maximum sum of subarrays
    public int maxSubArray(int[] nums) {
        
        // Maximum sum
        long maxi = Long.MIN_VALUE; 
        
        // Current sum of subarray 
        long sum = 0; 
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            
            // Add current element to the sum
            sum += nums[i]; 
            
            // Update maxi if current sum is greater
            if (sum > maxi) {
                maxi = sum; 
            }
            
            // Reset sum to 0 if it becomes negative
            if (sum < 0) {
                sum = 0; 
            }
        }
        
        // Return the maximum subarray sum found
        return (int) maxi;
    }
}

// Separate Main class in same file
public class Main {
    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        // Create an instance of Solution class
        Solution sol = new Solution();

        int maxSum = sol.maxSubArray(arr);

        // Print the max subarray sum
        System.out.println("The maximum subarray sum is: " + maxSum);
    }
}
