// Problem : Search Single Element in a sorted array
// Platform : Striver A2Z 
// Approach : Brute force_1
// Time Complexity : O(n)
// Space Complexity : O(1)

import.java.util.*;

public class Solution {
    // Function to find the single non-duplicate element
    public int singleNonDuplicate(int[] arr) {
        // Get the size of the array
        int n = arr.length;

        // If array has only one element, return it
        if (n == 1) return arr[0];

        // Loop through the array
        for (int i = 0; i < n; i++) {

            // Check if it's the first element and not equal to the next
            if (i == 0) {
                if (arr[i] != arr[i + 1])
                    return arr[i];
            }

            // Check if it's the last element and not equal to the previous
            else if (i == n - 1) {
                if (arr[i] != arr[i - 1])
                    return arr[i];
            }

            // Check if the current element is not equal to both neighbors
            else {
                if (arr[i] != arr[i - 1] && arr[i] != arr[i + 1])
                    return arr[i];
            }
        }

        // Dummy return if no element found
        return -1;
    }
}

// Driver class with main method
class Main {
    public static void main(String[] args) {
        // Input array with one unique element
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};

        // Create an object of Solution class
        Solution obj = new Solution();

        // Call the function and store result
        int ans = obj.singleNonDuplicate(arr);

        // Print the result
        System.out.println("The single element is: " + ans);
    }
}



// Approach : Brute force_2
// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.*;

public class Solution {
    // Function to find the single non-duplicate element using XOR
    public int singleNonDuplicate(int[] arr) {
        // Get the size of the array
        int n = arr.length;

        // Initialize the result variable with 0
        int ans = 0;

        // Traverse the array and XOR all elements
        for (int i = 0; i < n; i++) {
            ans = ans ^ arr[i];
        }

        // Return the unique element found using XOR
        return ans;
    }
}

// Separate Main class to run the driver code
class Main {
    public static void main(String[] args) {
        // Input array with all elements occurring twice except one
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};

        // Create an object of Solution class
        Solution obj = new Solution();

        // Call the function and store the result
        int ans = obj.singleNonDuplicate(arr);

        // Print the result
        System.out.println("The single element is: " + ans);
    }
}



// Approach : Optimal
// Time Complexity : O(logn)
// Space Complexity : O(1)

import java.util.*;

public class Solution {
     
     // Function to find the single non-duplicate element using binary search
    public int singleNonDuplicate(int[] arr) {
        // Get the size of the array
        int n = arr.length;

        // Edge case: only one element in the array
        if (n == 1) return arr[0];

        // Edge case: first element is the unique one
        if (arr[0] != arr[1]) return arr[0];

        // Edge case: last element is the unique one
        if (arr[n - 1] != arr[n - 2]) return arr[n - 1];

        // Initialize binary search bounds (exclude first and last index)
        int low = 1, high = n - 2;

        // Perform binary search
        while (low <= high) {
            // Calculate middle index
            int mid = (low + high) / 2;

            // Check if middle element is the unique one
            if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]) {
                return arr[mid];
            }

            // If mid is in the left half (pairing is valid)
            if ((mid % 2 == 1 && arr[mid] == arr[mid - 1]) ||
                (mid % 2 == 0 && arr[mid] == arr[mid + 1])) {
                // Move to the right half
                low = mid + 1;
            }
            // If mid is in the right half (pairing broken earlier)
            else {
                // Move to the left half
                high = mid - 1;
            }
        }

        // Dummy return (not reachable if input is valid)
        return -1;
    }
}

// Driver code
class Main {
    public static void main(String[] args) {
        // Input array with all elements appearing twice except one
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};

        // Create an object of Solution class
        Solution obj = new Solution();

        // Call the function and store the result
        int ans = obj.singleNonDuplicate(arr);

        // Print the result
        System.out.println("The single element is: " + ans);
    }
}
