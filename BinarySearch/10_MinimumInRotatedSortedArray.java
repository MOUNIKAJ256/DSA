// Problem : Minimum in Rotated Sorted Array
// Platform : Striver A2Z 
// Approach : Brute force
// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.*;
class Solution {
    // Function to find the minimum element using linear search
    public int findMin(int[] nums) {

        // Initialize answer with a large number
        int minVal = Integer.MAX_VALUE;

        // Traverse each element
        for (int i = 0; i < nums.length; i++) {

            // Update minimum value
            minVal = Math.min(minVal, nums[i]);
        }

        // Return the result
        return minVal;
    }
}

public class Main {
    public static void main(String[] args) {

        // Input array
        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        // Create object of Solution
        Solution sol = new Solution();

        // Call function and store result
        int result = sol.findMin(nums);

        // Output the result
        System.out.println("Minimum element is " + result);
    }
}



// Approach : Optimal
// Time Complexity : O(logn)
// Space Complexity : O(1)

import java.util.*;
class Solution {
    // Function to find the minimum element using binary search
    public int findMin(int[] nums) {

        // Initialize low and high pointers
        int low = 0, high = nums.length - 1;

        // Binary search loop
        while (low < high) {

            // Calculate mid index
            int mid = low + (high - low) / 2;

            // Check which half to discard
            if (nums[mid] > nums[high]) {

                // Minimum lies in right half
                low = mid + 1;

            } else {

                // Minimum lies in left half (including mid)
                high = mid;
            }
        }

        // Return the minimum element
        return nums[low];
    }
}

public class Main {
    public static void main(String[] args) {

        // Input array
        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        // Create object of Solution
        Solution sol = new Solution();

        // Call function and store result
        int result = sol.findMin(nums);

        // Output the result
        System.out.println("Minimum element is " + result);
    }
}
