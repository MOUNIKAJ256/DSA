// Problem : Find the repeating and missing numbers
// Platform : Striver A2Z 
// Approach : Brute Force
// Time Complexity : O(n ^ 2)
// Space Complexity : O(1)

import java.util.*;
class Solution {
    // Function to find repeating and missing numbers
    public int[] findMissingRepeatingNumbers(int[] nums) {
        int n = nums.length; // Size of the array
        int repeating = -1, missing = -1;

        // Find the repeating and missing number:
        for (int i = 1; i <= n; i++) {
            // Count the occurrences:
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == i) cnt++;
            }

            // Check if i is repeating or missing
            if (cnt == 2) repeating = i;
            else if (cnt == 0) missing = i;

            // Stop early if both found
            if (repeating != -1 && missing != -1)
                break;
        }

        // Return {repeating, missing}
        return new int[]{repeating, missing};
    }
}

// Separate main class
public class Main {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 5, 4, 6, 7, 5};

        // Create an instance of Solution class
        Solution sol = new Solution();

        int[] result = sol.findMissingRepeatingNumbers(nums);

        // Print the repeating and missing numbers found
        System.out.println("The repeating and missing numbers are: {" 
                            + result[0] + ", " + result[1] + "}");
    }
}



// Approach : Better
// Time Complexity : O(2 * n)
// Space Complexity : O(n)

import java.util.*;
class Solution {
    // Function to find repeating and missing numbers
    public int[] findMissingRepeatingNumbers(int[] nums) {
        
        // Size of the array
        int n = nums.length;
        
        // Hash array to count occurrences
        int[] hash = new int[n + 1];
        
        // Update the hash array:
        for (int i = 0; i < n; i++) {
            hash[nums[i]]++;
        }

        int repeating = -1, missing = -1;
        
        // Find the repeating and missing number:
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 2) {
                repeating = i;
            } else if (hash[i] == 0) {
                missing = i;
            }

            // Stop early if both found
            if (repeating != -1 && missing != -1) {
                break;
            }
        }
        
        // Return [repeating, missing]
        return new int[]{repeating, missing};
    }
}

// Separate main class
public class Main {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 5, 4, 6, 7, 5};
        
        // Create an instance of Solution class
        Solution sol = new Solution();

        int[] result = sol.findMissingRepeatingNumbers(nums);
        
        // Print the repeating and missing numbers found
        System.out.println("The repeating and missing numbers are: {" 
                            + result[0] + ", " + result[1] + "}");
    }
}



// Approach : Optimal_1
// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.*;
class Solution {
    // Function to find repeating and missing numbers
    public int[] findMissingRepeatingNumbers(int[] nums) {
        
        // Size of the array
        long n = nums.length;

        // Sum of first n natural numbers
        long SN = (n * (n + 1)) / 2;

        // Sum of squares of first n natural numbers
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;

        // Calculate actual sum (S) and sum of squares (S2) of array elements
        long S = 0, S2 = 0;
        for (int i = 0; i < n; i++) {
            S += nums[i];
            S2 += (long) nums[i] * (long) nums[i];
        }

        // Compute the difference values
        long val1 = S - SN; // X - Y

        // S2 - S2n = X^2 - Y^2
        long val2 = S2 - S2N;

        // Calculate X + Y
        val2 = val2 / val1;

        // Calculate X and Y
        long x = (val1 + val2) / 2; // repeating
        long y = x - val1;          // missing

        return new int[]{(int) x, (int) y};
    }
}

// Separate main class
public class Main {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 5, 4, 6, 7, 5};

        // Create an instance of Solution class
        Solution sol = new Solution();

        int[] result = sol.findMissingRepeatingNumbers(nums);

        // Print the repeating and missing numbers found
        System.out.printf("The repeating and missing numbers are: {%d, %d}\n", result[0], result[1]);
    }
}



// Approach : Optimal_2
// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.*;
class Solution {
    // Function to find repeating and missing numbers
    public int[] findMissingRepeatingNumbers(int[] nums) {
        // Size of the array
        int n = nums.length; 

        // XOR of all elements and numbers from 1 to n
        int xr = 0;
        for (int i = 0; i < n; i++) {
            xr = xr ^ nums[i];     // XOR with array element
            xr = xr ^ (i + 1);     // XOR with natural number
        }

        // Get the rightmost set bit in xr
        int number = (xr & ~(xr - 1));

        // Two groups based on this bit
        int zero = 0, one = 0;

        // Divide nums into groups and XOR within each group
        for (int i = 0; i < n; i++) {
            if ((nums[i] & number) != 0) {
                one ^= nums[i];
            } else {
                zero ^= nums[i];
            }
        }

        // Divide natural numbers 1 to n into groups and XOR
        for (int i = 1; i <= n; i++) {
            if ((i & number) != 0) {
                one ^= i;
            } else {
                zero ^= i;
            }
        }

        // Check which is repeating and which is missing
        int cnt = 0;
        for (int val : nums) {
            if (val == zero) cnt++;
        }

        if (cnt == 2) {
            return new int[]{zero, one}; // zero is repeating
        }
        return new int[]{one, zero}; // one is repeating
    }
}

// Separate main class
public class Main {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 5, 4, 6, 7, 5};

        Solution sol = new Solution();
        int[] result = sol.findMissingRepeatingNumbers(nums);

        System.out.println("The repeating and missing numbers are: {" + result[0] + ", " + result[1] + "}");
    }
}
