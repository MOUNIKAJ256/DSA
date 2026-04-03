// Problem : Pascal's Triangle
// Platform : Striver A2Z 
// Approach : Brute Force
// Time Complexity : O(n ^ 2)
// Space Complexity : O(n ^ 2)

import java.util.*;
// Class containing Pascal's Triangle generation logic
class Solution {
    // Function to generate Pascal's Triangle up to numRows
    public List<List<Integer>> generate(int numRows) {
        // Result list to hold all rows
        List<List<Integer>> triangle = new ArrayList<>();

        // Loop for each row
        for (int i = 0; i < numRows; i++) {
            // Create a row with size (i+1)
            List<Integer> row = new ArrayList<>(Collections.nCopies(i + 1, 1));

            // Fill elements from index 1 to i-1 (middle values)
            for (int j = 1; j < i; j++) {
                // Each element = sum of two elements above it
                row.set(j, triangle.get(i - 1).get(j - 1) +
                           triangle.get(i - 1).get(j));
            }

            // Add current row to the triangle
            triangle.add(row);
        }
        return triangle;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int n = 5;

        // Generate and print Pascal's Triangle
        List<List<Integer>> result = obj.generate(n);
        for (List<Integer> row : result) {
            for (Integer val : row) System.out.print(val + " ");
            System.out.println();
        }
    }
}



// Approach : Better
// Time Complexity : O(n)
// Space Complexity : O(n)

import java.util.*;
// Class containing Pascal's Triangle row generation logic
class Solution {
    // Function to generate the Nth row of Pascal's Triangle
    public List<Long> getNthRow(int N) {
        // Result list to store the row
        List<Long> row = new ArrayList<>();
        
        // First value of the row is always 1
        long val = 1;
        row.add(val);
        
        // Compute remaining values using the relation:
        // C(n, k) = C(n, k-1) * (n-k) / k
        for (int k = 1; k < N; k++) {
            val = val * (N - k) / k;
            row.add(val);
        }
        
        return row;
    }
}

public class Main {
    public static void main(String[] args) {
        int N = 5; // Example: 5th row
        Solution sol = new Solution();
        List<Long> result = sol.getNthRow(N);

        // Print the row
        for (long num : result) {
            System.out.print(num + " ");
        }
    }
}



// Approach : Optimal
// Time Complexity : O(min(c,r-c))
// Space Complexity : O(1)

import java.util.*;
// Solution class to find the (r, c) element of Pascal's Triangle
class Solution {
    // Function to compute binomial coefficient (nCr)
    public long findPascalElement(int r, int c) {
        // Element is C(r-1, c-1)
        int n = r - 1;
        int k = c - 1;

        long result = 1;

        // Compute C(n, k) using iterative formula
        for (int i = 0; i < k; i++) {
            result *= (n - i);
            result /= (i + 1);
        }

        return result;
    }
}

// Main class to test the solution
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int r = 5, c = 3;
        System.out.println(sol.findPascalElement(r, c));
    }
}
