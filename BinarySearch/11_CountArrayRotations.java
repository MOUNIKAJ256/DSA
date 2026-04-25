// Problem : Find out how many times the array has been rotated
// Platform : Striver A2Z 
// Approach : Brute force
// Time Complexity : O(n)
// Space Complexity : O(1)

import.java.util.*;

class Solution {
    // Function to find the number of rotations in a rotated sorted array
    public int findRotations(int[] arr) {
        // Store size of array
        int n = arr.length;

        // Assume the first element is the smallest
        int minVal = arr[0];

        // Index of the smallest element
        int minIndex = 0;

        // Traverse the array
        for (int i = 1; i < n; i++) {
            // If current element is smaller than minVal, update
            if (arr[i] < minVal) {
                minVal = arr[i];
                minIndex = i;
            }
        }

        // The index of smallest element = number of rotations
        return minIndex;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();

        // Example input
        int[] arr = {4,5,6,7,0,1,2,3};

        // Call the function and store result
        int rotations = obj.findRotations(arr);

        // Print result
        System.out.println(rotations);
    }
}



// Approach : Better
// Time Complexity : O(n)
// Space Complexity : O(1)



import java.util.*;

class Solution {
    // Function to find rotation count using one-pass scan
    public int findRotationCount(int[] arr) {
        // Get size of array
        int n = arr.length;
        // Traverse till second-last element
        for (int i = 0; i < n - 1; i++) {
            // If break in ascending order found
            if (arr[i] > arr[i + 1]) {
                // Index of next element is rotation count
                return i + 1;
            }
        }
        // No rotation found
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        // Example input
        int[] arr = {3, 4, 5, 1, 2};
        // Create object of Solution
        Solution sol = new Solution();
        // Call the function
        int rotations = sol.findRotationCount(arr);
        // Output the result
        System.out.println(rotations);
    }
}



// Approach : Optimal
// Time Complexity : O(logn)
// Space Complexity : O(1)

import.java.util.*;

class Solution {
    // Function to find rotation count using binary search
    public int findRotations(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        // Loop until low meets high
        while (low < high) {
            int mid = low + (high - low) / 2;

            // If mid element is greater than element at high,
            // smallest element lies to the right of mid
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                // Else smallest element is at mid or to the left
                high = mid;
            }
        }

        // When low == high, we found the smallest element
        return low;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {4,5,6,7,0,1,2,3};

        int rotations = sol.findRotations(arr);

        System.out.println(rotations);
    }
}
