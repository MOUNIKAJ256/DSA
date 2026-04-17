// Problem : Implement Upper Bound
// Platform : Striver A2Z 
// Approach : Brute force
// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.*;

class UpperBoundFinder {
    // Linear search method to find upper bound
    public int upperBound(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > x) {
                return i; // Return index of first element > x
            }
        }
        return arr.length; // Return length if no such element found
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 9, 15, 19}; // Sorted array
        int x = 9;

        UpperBoundFinder finder = new UpperBoundFinder();
        int ind = finder.upperBound(arr, x); // Call function

        System.out.println("The upper bound is the index: " + ind); // Output result
    }
}



// Approach : Optimal
// Time Complexity : O(logn)
// Space Complexity : O(1)

import java.util.*;

class UpperBoundFinder {
    // Binary search to find upper bound
    public int upperBound(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;  // Default to length if not found

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > x) {
                ans = mid;        // Store current index as potential answer
                high = mid - 1;   // Move left
            } else {
                low = mid + 1;    // Move right
            }
        }
        return ans;  // Return final answer
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 9, 15, 19};  // Sorted array
        int x = 9;

        UpperBoundFinder finder = new UpperBoundFinder();
        int ind = finder.upperBound(arr, x);  // Call method

        System.out.println("The upper bound is the index: " + ind);
    }
}
