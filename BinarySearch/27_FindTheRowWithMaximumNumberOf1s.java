// Problem : Find the row with maximum number of 1's
// Platform : Striver A2Z 
// Approach : brute force
// Time Complexity : O(n * m)
// Space Complexity : O(1)

import java.util.*;

class Solution {
    // Method to find row with maximum number of 1s
    public int rowWithMax1s(int[][] matrix, int n, int m) {
        int cnt_max = 0;  // Max number of 1s
        int index = -1;   // Row index with max 1s

        for (int i = 0; i < n; i++) {
            int cnt_ones = 0;
            for (int j = 0; j < m; j++) {
                cnt_ones += matrix[i][j];
            }
            if (cnt_ones > cnt_max) {
                cnt_max = cnt_ones;
                index = i;
            }
        }
        return index;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {0, 0, 1}, {0, 0, 0}};
        int n = 3, m = 3;

        Solution obj = new Solution();
        System.out.println("The row with maximum no. of 1's is: " + obj.rowWithMax1s(matrix, n, m));
    }
}



// Approach : Optimal
// Time Complexity : O(n * logm)
// Space Complexity : O(1)

import java.util.*;

class Solution {
    // Function to find the lower bound (first index where value >= x)
    public int lowerBound(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;  // Default value if no such index is found

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ans = mid;        // Possible answer found
                high = mid - 1;   // Try to find a smaller index
            } else {
                low = mid + 1;    // Move right
            }
        }
        return ans;  // Index of first element >= x
    }

    // Function to return index of the row with the maximum number of 1s
    public int rowWithMax1s(int[][] matrix, int n, int m) {
        int cnt_max = 0;  // Keeps track of the maximum number of 1s found so far
        int index = -1;   // Stores index of the row with maximum 1s

        // Iterate over all rows
        for (int i = 0; i < n; i++) {
            // Count of 1s = total columns - index of first 1 (lower bound)
            int cnt_ones = m - lowerBound(matrix[i], m, 1);
            if (cnt_ones > cnt_max) {
                cnt_max = cnt_ones;
                index = i;
            }
        }
        return index;  // Return row index with maximum 1s
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {0, 0, 1}, {0, 0, 0}};
        int n = 3, m = 3;

        Solution obj = new Solution();
        System.out.println("The row with maximum no. of 1's is: " + obj.rowWithMax1s(matrix, n, m));
    }
}
