// Problem : Search in a sorted 2D matrix
// Platform : Striver A2Z 
// Approach : brute force
// Time Complexity : O(n * m)
// Space Complexity : O(1)

import java.util.*;

public class Solution {
    // Function to search for a target value in the matrix
    public boolean searchMatrix(int[][] matrix, int target) {
        // Get number of rows in the matrix
        int n = matrix.length;

        // Get number of columns in the matrix
        int m = matrix[0].length;

        // Traverse each row
        for (int i = 0; i < n; i++) {
            // Traverse each column in the current row
            for (int j = 0; j < m; j++) {
                // Check if the current element matches the target
                if (matrix[i][j] == target)
                    return true;
            }
        }

        // Return false if the target is not found
        return false;
    }
}

// Driver class
class Main {
    public static void main(String[] args) {
        // Define a 2D matrix
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        // Create an object of the Solution class
        Solution obj = new Solution();

        // Call the searchMatrix function and print the result
        if (obj.searchMatrix(matrix, 8)) 
            System.out.println("true");
        else 
            System.out.println("false");
    }
}



// Approach : better
// Time Complexity : O(n * logm)
// Space Complexity : O(1)

import java.util.*;

public class Solution {
    // Function to perform binary search on a 1D array
    public boolean binarySearch(int[] nums, int target) {
        // Get the length of the array
        int n = nums.length;

        // Initialize low and high pointers
        int low = 0, high = n - 1;

        // Perform binary search
        while (low <= high) {
            // Calculate the middle index
            int mid = (low + high) / 2;

            // If the middle element is the target, return true
            if (nums[mid] == target)
                return true;

            // If target is greater, search in the right half
            else if (target > nums[mid])
                low = mid + 1;

            // Otherwise, search in the left half
            else
                high = mid - 1;
        }

        // Return false if target is not found
        return false;
    }

    // Function to search for target in a 2D matrix
    public boolean searchMatrix(int[][] matrix, int target) {
        // Get the number of rows
        int n = matrix.length;

        // Get the number of columns
        int m = matrix[0].length;

        // Traverse each row
        for (int i = 0; i < n; i++) {
            // Check if target could be in this row
            if (matrix[i][0] <= target && target <= matrix[i][m - 1]) {
                // Perform binary search on this row
                return binarySearch(matrix[i], target);
            }
        }

        // Return false if target is not found
        return false;
    }
}

// Driver class
class Main {
    public static void main(String[] args) {
        // Define a 2D matrix
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        // Create an object of the Solution class
        Solution obj = new Solution();

        // Call the searchMatrix method and print the result
        if (obj.searchMatrix(matrix, 8))
            System.out.println("true");
        else
            System.out.println("false");
    }
}



// Approach : Optimal
// Time Complexity : O(log(n * m))
// Space Complexity : O(1)

import java.util.*;

class Solution {
    // Function to search target in 2D matrix using binary search
    public boolean searchMatrix(int[][] matrix, int target) {
        // Get the number of rows
        int n = matrix.length;

        // Get the number of columns
        int m = matrix[0].length;

        // Set initial binary search range
        int low = 0, high = n * m - 1;

        // Perform binary search
        while (low <= high) {
            // Calculate middle index
            int mid = (low + high) / 2;

            // Map 1D index to 2D coordinates
            int row = mid / m;
            int col = mid % m;

            // Check if target is found
            if (matrix[row][col] == target)
                return true;

            // Discard left half
            else if (matrix[row][col] < target)
                low = mid + 1;

            // Discard right half
            else
                high = mid - 1;
        }

        // Target not found
        return false;
    }
}

// Driver class
public class Main {
    public static void main(String[] args) {
        // Define 2D matrix
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        // Create object of Solution
        Solution obj = new Solution();

        // Call the method and print result
        if (obj.searchMatrix(matrix, 8))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
