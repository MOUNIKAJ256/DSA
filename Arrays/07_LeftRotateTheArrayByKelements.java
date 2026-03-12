// Problem : Left Rotate an array by k places
// Platform : Strivers A2Z 
// Approach : Brute Force
// Time Complexity : O(n)
// Space Complexity : O(k)

import java.util.Arrays;
class Solution {
    // Rotate the array to the left by k positions
    public void rotateLeft(int[] arr, int k) {
        int n = arr.length;
        if (n == 0) return;
        k = k % n;
        // Store first k elements
        int[] temp = Arrays.copyOfRange(arr, 0, k);
        // Shift remaining elements to the left
        for (int i = k; i < n; i++) {
            arr[i - k] = arr[i];
        }
        // Copy stored elements to the end
        for (int i = 0; i < k; i++) {
            arr[n - k + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 2;
        sol.rotateLeft(arr, k);
        System.out.println("Array after left rotation: " + Arrays.toString(arr));
    }
}



// Approach : Optimal
// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.*;
class Solution {
    // Function to reverse part of the array between given indices
    void reverseArray(int[] nums, int start, int end) {
        // Swap elements until start meets end
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    // Function to rotate array left by k steps
    public int[] rotateArray(int[] nums, int k) {
        // Get array length
        int n = nums.length;
        // Edge case: do nothing if array is empty or k is 0
        if (n == 0 || k == 0) return nums;
        // Normalize k if greater than n
        k = k % n;
        // Step 1: reverse first k elements
        reverseArray(nums, 0, k - 1);
        // Step 2: reverse remaining n-k elements
        reverseArray(nums, k, n - 1);
        // Step 3: reverse entire array
        reverseArray(nums, 0, n - 1);
        // Return the rotated array
        return nums;
    }
}

// Driver code
public class Main {
    public static void main(String[] args) {
        // Create instance of Solution
        Solution sol = new Solution();
        // Input array and parameters
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 2;
        // Call rotateArray and store result
        int[] result = sol.rotateArray(nums, k);
        // Print rotated array
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
