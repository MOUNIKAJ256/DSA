// Problem : Search a target value in a sorted array with no duplicates.
// Platform : Striver A2Z 
// Approach : Iterative 
// Time Complexity : O(logn)
// Space Complexity : O(1)

import java.util.*;

public class Solution {

    // Function to perform Binary Search on sorted array
    public static int binarySearch(int[] nums, int target) {
        int n = nums.length; // size of the array
        int low = 0, high = n - 1;

        // Keep searching until low crosses high
        while (low <= high) {
            int mid = (low + high) / 2; // Find the middle index
            // Target found
            if (nums[mid] == target) return mid;       
            // Search in right half
            else if (target > nums[mid]) low = mid + 1; 
            // Search in left half
            else high = mid - 1;                        
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        // sorted array
        int[] a = {3, 4, 6, 7, 9, 12, 16, 17}; 
        int target = 6; // target element to search

        int ind = binarySearch(a, target);

        if (ind == -1)
            System.out.println("The target is not present.");
        else
            System.out.println("The target is at index: " + ind);
    }
}



// Approach : Recursive 
// Time Complexity : O(logn)
// Space Complexity : O(1)


import java.util.*;

public class Solution {

    // Recursive Binary Search function
    public static int binarySearch(int[] nums, int low, int high, int target) {
        // Base case: target not found
        if (low > high) return -1; 

        // Find middle index
        int mid = (low + high) / 2;

        // If target is found at mid
        if (nums[mid] == target) return mid;
        // If target is greater, search right half
        else if (target > nums[mid])
            return binarySearch(nums, mid + 1, high, target);
        // Otherwise, search left half
        return binarySearch(nums, low, mid - 1, target);
    }

    // Public function to initiate search
    public static int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public static void main(String[] args) {
        // sorted array
        int[] a = {3, 4, 6, 7, 9, 12, 16, 17};
        int target = 6; // target element to search

        int ind = search(a, target);

        if (ind == -1)
            System.out.println("The target is not present.");
        else
            System.out.println("The target is at index: " + ind);
    }
}

