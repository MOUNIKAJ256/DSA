// Problem : Find Largest Element in an Array
// Platform : Striver A2Z 
// Approach : Brute Force
// Time Complexity : O(nlogn)
// Space Complexity : O(1)

import java.util.Arrays;
class Solution {
    // Function to sort the array and return the largest element
    public static int sortArr(int[] arr) {
        // Sort the array
        Arrays.sort(arr);
        // Return the last element
        return arr[arr.length - 1];
    }
}

public class Main {
    public static void main(String[] args) {
        // Initialize arrays
        int[] arr1 = {2, 5, 1, 3, 0};
        // Find and output the largest element in an Array
        System.out.println("The Largest element in the array is: " + Solution.sortArr(arr1));
    }
}

// Approach : optimal
// TimeComplexity : O(n)
// Space Complexity : O(1)

class Solution {
    // Function to find the largest element in the array
    public static int findLargestElement(int[] arr, int n) {
      // Initialize max with the first element in the array
        int max = arr[0];  
        // Iterate through the array to find the maximum element
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {  
              // If the current element is greater than max, update max
                max = arr[i];
            }
        }
      // Return the largest element found
        return max; 
    }
}

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {2, 5, 1, 3, 0};
       // Size of the array
        int n = arr1.length; 
      // Call the function to find the largest element
        int max = Solution.findLargestElement(arr1, n);
      // Output the result
        System.out.println("The largest element in the array is: " + max);  
    }
}
