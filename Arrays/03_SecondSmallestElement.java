// Problem : Find Second Smallest Element in an Array
// Platform : Strivers A2Z 
// Approach : Brute Force
// Time Complexity : O(nlogn)
// Space Complexity : O(1)

import java.util.Arrays;
class Solution {
    // Method to find the second smallest element in the array
    public static void findSecondSmallest(int[] arr, int n) {
        // Edge case: when the array has less than 2 elements
        if (n == 0 || n == 1) {
            System.out.println(-1);  // Print -1 for second smallest
            return;
        }
        // Sort the array to easily find the second smallest element
        Arrays.sort(arr);
        // Second smallest element is at index 1 after sorting
        int small = arr[0];
        for(int i = 1; i < n;i++){
            if(arr[i] != small){
                small = arr[i];
                break;
            }
        }
        // Output the second smallest element
        if(small == arr[0]){
          System.out.println("No second smallest element");
        }else{
        System.out.println("Second smallest is " + small);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Initialize the array with elements
        int[] arr = {1, 2, 4, 6, 7, 5};
        // Calculate the size of the array
        int n = arr.length;
        // Call the method to find and print the second smallest element
        Solution.findSecondSmallest(arr, n);
    }
}



// Approach : Better
// Time Complexity : O(2n)
// Space Complexity : O(1)

import java.util.*;
class Solution {
    // Method to find the second smallest elements in the array
    public static void findSecondSmallest(int[] arr, int n) {
        // Edge case: when the array has less than 2 elements
        if (n == 0 || n == 1) {
            System.out.println(-1);  // Print -1 for second smallest
            return;
        }
        // Initialize variables to track the smallest, and second smallest elements
        int small = Integer.MAX_VALUE, second_small = Integer.MAX_VALUE;
        // Find the smallest element in the array
        for (int i = 0; i < n; i++) {
            small = Math.min(small, arr[i]);  // Update the smallest element
        }
        // Find the second smallest element
        for (int i = 0; i < n; i++) {
            if (arr[i] < second_small && arr[i] != small) {
                second_small = arr[i];  // Update second smallest if a smaller element is found
            }
        }
      // Output the second smallest element
        if(second_small == Integer.MAX_VALUE){
            System.out.println("No second smallest element");
        }else{
        System.out.println("Second Smallest is " + second_small);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Driver code
        int n = 6;
        // Array of elements
        int[] arr = {1, 2, 4, 6, 7, 5};  
        // Call the function to find and print the second smallest element
        Solution.findSecondSmallest(arr, n);
    }
}



// Approach : Optimal
// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.*;
class Solution {
    // Function to find the second smallest element in the array
    public static int secondSmallest(int[] arr, int n) {
        // Edge case: if the array has fewer than 2 elements
        if (n < 2)
            return -1;
        int small = Integer.MAX_VALUE;
        int second_small = Integer.MAX_VALUE;
        // Loop through the array to find the second smallest element
        for (int i = 0; i < n; i++) {
            // Update the smallest and second smallest values
            if (arr[i] < small) {
                second_small = small;
                small = arr[i];
            } 
            else if (arr[i] < second_small && arr[i] != small) {
                second_small = arr[i];
            }
        }
        if(second_small == Integer.MAX_VALUE){
            return -1;
        }
        return second_small; // Return the second smallest element
    }
}

public class Main {
    public static void main(String[] args) {
        // Array of elements
        int[] arr = {1, 2, 4, 7, 7, 5};
        // Calculate the size of the array
        int n = arr.length;
        // Find the second smallest element
        int sS = Solution.secondSmallest(arr, n);
        // Output the result
        if(ss == -1){
            System.out.println("No second smallest element");
        }else{
            System.out.println("Second smallest is " + sS);
        }
    }
}
