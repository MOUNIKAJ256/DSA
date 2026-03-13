// Problem : Move all Zeros to the end of the Array
// Platform : Strivers A2Z 
// Approach : Brute Force
// Time Complexity : O(n)
// Space Complexity : O(n)

import java.util.*;
// Solution class
class Solution {
    // Function to move all zeroes to end
    public int[] moveZeroes(int[] arr) {
        // Create temp array
        int[] temp = new int[arr.length];
        // Pointer for temp
        int index = 0;
        // Traverse input array
        for (int i = 0; i < arr.length; i++) {
            // If non-zero, copy to temp
            if (arr[i] != 0) {
                temp[index] = arr[i];
                index++;
            }
        }
        // Copy temp back to original
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
        // Return updated array
        return arr;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Input array
        int[] arr = {0, 1, 0, 3, 12};
        // Solution object
        Solution sol = new Solution();
        // Call the function
        int[] result = sol.moveZeroes(arr);
        // Print the result
        System.out.print("Array after moving zeroes: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}



// Approach : Optimal
// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.*;
class Solution {
    // Function to move zeroes to the end
    public void moveZeroes(int[] nums) {
        // Pointer to the first zero
        int j = -1;
        // Find the first zero
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }
        // If no zero found, return
        if (j == -1) return;
        // Start from the next index of first zero
        for (int i = j + 1; i < nums.length; i++) {
            // If current element is non-zero
            if (nums[i] != 0) {
                // Swap with nums[j]
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                // Move j to next zero
                j++;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {0, 1, 0, 3, 12};
        sol.moveZeroes(nums);
        // Print the result
        for (int num : nums)
            System.out.print(num + " ");
        System.out.println();
    }
}

