// Problem : Left Rotate the Array by One
// Platform : Strivers A2Z 
// Approach : Brute Force
// Time Complexity : O(n)
// Space Complexity : O(n)

import java.util.*;
class Solution {
    // Function to solve and shift array elements left by one position
    public static void solve(int[] arr, int n) {
      // Temporary array to store shifted elements
        int[] temp = new int[n];  
        // Shift elements to the left by one position
        for (int i = 1; i < n; i++) {
            temp[i - 1] = arr[i];
        }
       // First element moves to the last position
        temp[n - 1] = arr[0]; 
        // Print the rotated array
        for (int i = 0; i < n; i++) {
            System.out.print(temp[i] + " ");
        }
        System.out.println();
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
         // Size of the array
        int n = 5
        // Original array;  
        int[] arr = {1, 2, 3, 4, 5};
      // Call the solve function from Solution class
        Solution.solve(arr, n);  
    }
}



// Approach : Optimal
// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.*;
class Solution {
    public void rotateArrayByOne(int[] nums) {
        // Store the first element in a temporary variable
        int temp = nums[0];
        // Shift elements to the left
        for (int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }
        // Place the first element at the end
        nums[nums.length - 1] = temp;
    }
}

//Main class
class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Original array;
        int[] nums = {1, 2, 3, 4, 5};
        solution.rotateArrayByOne(nums);
        // Output the rotated array
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
