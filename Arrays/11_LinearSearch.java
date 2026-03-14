// Problem : Linear search
// Platform : Strivers A2Z 
// Approach : Brute Force
// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.*;
class Main {
    // Function to search target element in array
    static int search(int arr[], int target) {
        // Traverse the array from index 0 to n-1
        for(int i = 0; i < arr.length; i++) {
            // Check if current element equals target
            if(arr[i] == target) {
                // If found, return the index
                return i;
            }
        }
        // If element not found in entire array
        return -1;
    }

    public static void main(String[] args) {
        // Declare and initialize array
        int arr[] = {1,2,3,4,5};
        // Element to search
        int target = 4;
        // Call search function
        int ans = search(arr, target);
        // Print index of found element
        System.out.println(ans);
    }
}
