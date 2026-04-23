// Problem : Search Element in a Rotated Sorted Array II
// Platform : Striver A2Z 
// Approach : Brute force
// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.*;

class Solution {
    // Method to search for a target value in a rotated sorted array (with duplicates)
    public boolean searchInARotatedSortedArrayII(int[] arr, int k) {
        // Iterate through each element of the array
        for (int num : arr) {
            // If the target is found, return true
            if (num == k) return true;
        }
        // If loop completes and target not found, return false
        return false;
    }

    public static void main(String[] args) {
        // Sample rotated sorted array with duplicates
        int[] arr = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        int k = 3; // Target to search

        // Create object of the Solution class
        Solution obj = new Solution();

        // Call the search method
        boolean ans = obj.searchInARotatedSortedArrayII(arr, k);

        // Output result based on boolean answer
        if (!ans)
            System.out.println("Target is not present.");
        else
            System.out.println("Target is present in the array.");
    }
}



// Approach : Optimal
// Time Complexity : O(logn)
// Space Complexity : O(1)

import java.util.*;

class Solution {
    public boolean searchInRotatedSortedArrayII(int[] arr, int k) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // If mid element is the target
            if (arr[mid] == k) return true;

            // Handle duplicates: cannot determine sorted side
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low++;
                high--;
                continue;
            }

            // Left half is sorted
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= k && k <= arr[mid]) {
                    high = mid - 1; // Search left
                } else {
                    low = mid + 1;  // Search right
                }
            }
            // Right half is sorted
            else {
                if (arr[mid] <= k && k <= arr[high]) {
                    low = mid + 1;  // Search right
                } else {
                    high = mid - 1; // Search left
                }
            }
        }

        return false; // Not found
    }

    public static void main(String[] args) {
        int[] arr = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        int k = 3;

        Solution obj = new Solution();
        boolean ans = obj.searchInRotatedSortedArrayII(arr, k);

        if (ans)
            System.out.println("Target is present in the array.");
        else
            System.out.println("Target is not present.");
    }
}
