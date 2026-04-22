// Problem : Search Element in a Rotated Sorted Array
// Platform : Striver A2Z 
// Approach : Brute force
// Time Complexity : O(n)
// Space Complexity : O(1)

import.java.util.*;
class Solution {
    // Function to search target in rotated sorted array using brute force
    public int search(int[] nums, int target) {

        // Loop through each element in the array
        for (int i = 0; i < nums.length; i++) {

            // If current element matches target, return index
            if (nums[i] == target) {
                return i;
            }
        }

        // If not found, return -1
        return -1;
    }
}

// Driver class
class Main {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        Solution obj = new Solution();
        int index = obj.search(nums, target);

        System.out.println(index);
    }
}



// Approach : Optimal
// Time Complexity : O(logn)
// Space Complexity : O(1)

import.java.util.*;
class Solution {
    // Function to search target in rotated sorted array using binary search
    public int search(int[] nums, int target) {

        // Initialize search space
        int low = 0;
        int high = nums.length - 1;

        // Continue while there is still a valid search range
        while (low <= high) {

            // Calculate middle index
            int mid = (low + high) / 2;

            // If target found, return index
            if (nums[mid] == target)
                return mid;

            // If left part is sorted
            if (nums[low] <= nums[mid]) {

                // If target lies within sorted left part
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                }
                // Else, search in right half
                else {
                    low = mid + 1;
                }
            }

            // Else, right part is sorted
            else {

                // If target lies within sorted right part
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                }
                // Else, search in left half
                else {
                    high = mid - 1;
                }
            }
        }

        // Target not found
        return -1;
    }
}

// Driver class
class Main {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        Solution obj = new Solution();
        int result = obj.search(nums, target);

        System.out.println(result);
    }
}
