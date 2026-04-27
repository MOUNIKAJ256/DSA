// Problem : Peak element in Array
// Platform : Striver A2Z 
// Approach : Brute force
// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.*;

class Solution {
    // Function to find a peak element in the array
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        // Traverse the array
        for (int i = 0; i < n; i++) {
            // Check left neighbor if exists
            boolean left = (i == 0) || (nums[i] >= nums[i - 1]);
            // Check right neighbor if exists
            boolean right = (i == n - 1) || (nums[i] >= nums[i + 1]);

            // If both conditions are true
            if (left && right) return i;
        }

        // In case no peak found
        return -1;
    }
}

// Driver
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 3, 20, 4, 1, 0};
        int index = sol.findPeakElement(nums);
        System.out.println("Peak at index: " + index + " with value: " + nums[index]);
    }
}



// Approach : Optimal
// Time Complexity : O(logn)
// Space Complexity : O(1)

import java.util.*;

class Solution {
    // Function to find a peak element using binary search
    public int findPeakElement(int[] nums) {
        // Set left and right bounds
        int low = 0, high = nums.length - 1;

        // Binary search loop
        while (low < high) {
            // Find mid point
            int mid = (low + high) / 2;

            // If mid element is greater than next
            if (nums[mid] > nums[mid + 1]) {
                // Move to left half
                high = mid;
            } else {
                // Move to right half
                low = mid + 1;
            }
        }

        // Return peak index
        return low;
    }
}

public class Main {
    public static void main(String[] args) {
        // Input array
        int[] nums = {1, 2, 1, 3, 5, 6, 4};

        // Create object
        Solution obj = new Solution();

        // Output result
        System.out.println(obj.findPeakElement(nums));
    }
}
