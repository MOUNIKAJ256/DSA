// Problem : Implement Lower Bound
// Platform : Striver A2Z 
// Approach : Brute force
// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.*;

class LowerBoundFinder {
    // Function to find the lower bound index
    public int lowerBound(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= x) {
                return i;  // First index where element >= x
            }
        }
        return arr.length;  // If x is greater than all elements
    }

    public static void main(String[] args) {
      // Sorted array
        int[] arr = {3, 5, 8, 15, 19};
       // Target value        
        int x = 9;                      
        // Create object 
        LowerBoundFinder finder = new LowerBoundFinder();  
        // Find lower bound
        int ind = finder.lowerBound(arr, x);                  
        // Print result
        System.out.println("The lower bound is the index: " + ind);  
    }
}



// Approach : Optimal
// Time Complexity : O(logn)
// Space Complexity : O(1)

import java.util.*;

class LowerBoundFinder {
    // Function to find the lower bound index using binary search
    public int lowerBound(int[] arr, int x) {
        int low = 0;                  // Start index
        int high = arr.length - 1;    // End index
        int ans = arr.length;         // Default value if not found

        while (low <= high) {
            int mid = (low + high) / 2;  // Find mid index

            if (arr[mid] >= x) {
                ans = mid;            // Store possible answer
                high = mid - 1;       // Move left
            } else {
                low = mid + 1;        // Move right
            }
        }
        return ans;  // Return the lower bound index
    }

    public static void main(String[] args) {
         // Sorted array
        int[] arr = {3, 5, 8, 15, 19}; 
        // Target value        
        int x = 9;                      
        // Create object 
        LowerBoundFinder finder = new LowerBoundFinder();  
        // Find lower bound
        int ind = finder.lowerBound(arr, x);                  
        // Print result
        System.out.println("The lower bound is the index: " + ind);  
    }
}
