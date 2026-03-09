// Problem : Find Second Largest Element in an Array
// Platform : Strivers A2Z 
// Approach : Brute Force
// Time Complexity : O(nlogn)
// Space Complexity : O(1)

import java.util.Arrays;
class Solution {
    // Method to find the second largest element in the array
    public static void findSecondLargest(int[] arr, int n) {
        // Edge case: when the array has less than 2 elements
        if (n == 0 || n == 1) {
            System.out.println(-1);  // Print -1 for second largest
            return;
        }
        // Sort the array to easily find the second largest elements
        Arrays.sort(arr);
        // Second largest element is at index n-2 after sorting
        int large = arr[n - 1];
        for(int i = n - 2; i >= 0;i--){
            if(arr[i] != large){
                large = arr[i];
                break;
            }
        }
        // Output the second largest element
        if(large == arr[n - 1]){
          System.out.println("No second largest element");
        }else{
        System.out.println("Second largest is " + large);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Initialize the array with elements
        int[] arr = {1, 2, 4, 6, 7, 5};
        // Calculate the size of the array
        int n = arr.length;
        // Call the method to find and print the second largest element
        Solution.findSecondLargest(arr, n);
    }
}



// Approach : Better
// Time Complexity : O(2n)
// Space Complexity : O(1)

import java.util.*;
class Solution {
    // Method to find the second largest elements in the array
    public static void findSecondLargest(int[] arr, int n) {
        // Edge case: when the array has less than 2 elements
        if (n == 0 || n == 1) {
            System.out.println(-1);  // Print -1 for second largest
            return;
        }
        // Initialize variables to track the largest, and second largest elements
        int large = Integer.MIN_VALUE, second_large = Integer.MIN_VALUE;
        // Find the largest elements in the array
        for (int i = 0; i < n; i++) {
            large = Math.max(large, arr[i]);  // Update the largest element
        }
        // Find the second largest elements
        for (int i = 0; i < n; i++) {
            if (arr[i] > second_large && arr[i] != large) {
                second_large = arr[i];  // Update second largest if a larger element is found
            }
        }
        // Output the second largest element
        if(second_large == Integer.MIN_VALUE){
            System.out.println("No second largest element");
        else{
            System.out.println("Second largest is " + second_large);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Driver code
        int n = 6;
       // Array of elements
        int[] arr = {1, 2, 4, 6, 7, 5}; 
        // Call the function to find and print the second largest element
        Solution.findSecondLargest(arr, n);
    }
}



// Approach : Optimal
// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.*;
class Solution {
    // Function to find the second largest element in the array
    public static int findSecondLargest(int[] arr, int n) {
        // Edge case: if the array has fewer than 2 elements
        if (n < 2)
            return -1;
        int large = Integer.MIN_VALUE, second_large = Integer.MIN_VALUE;
        // Loop through the array to find the second largest element
        for (int i = 0; i < n; i++) {
            // Update the largest and second largest values
            if (arr[i] > large) {
                second_large = large;
                large = arr[i];
            } 
            else if (arr[i] > second_large && arr[i] != large) {
                second_large = arr[i];
            }
        }
        if(second_large == Integer.MIN_VALUE){
            return -1;
        }
        return second_large; // Return the second largest element
    }
}

public class Main {
    public static void main(String[] args) {
        // Array of elements
        int[] arr = {1, 2, 4, 7, 7, 5};
        // Calculate the size of the array
        int n = arr.length;
        // Find the second largest element
        int sL = Solution.secondLargest(arr, n);
        // Output the result
        if(sL == -1){
            System.out.println("No second largest element");
        }else{
        System.out.println("Second largest is " + sL);
        }
    }
}
