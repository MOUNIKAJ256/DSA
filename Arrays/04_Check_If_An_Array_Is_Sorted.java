// Problem : Check if an Array is Sorted
// Platform : Strivers A2Z 
// Approach : Brute Force
// Time Complexity : O(n^2)
// Space Complexity : O(1)

class Solution {
    // Function to check if the array is sorted
    public boolean isSorted(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // If any element is smaller than the previous one, return false
                if (arr[j] < arr[i]) 
                    return false;
            }
        }
        return true; // Return true if no unsorted elements are found
    }
}

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = 5;
        Solution obj = new Solution();
        boolean ans = obj.isSorted(arr, n);
        // Output result
        if (ans) 
            System.out.println("True");
        else 
            System.out.println("False");
    }
}



// Approach : optimal
// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    // Function to check if the array is sorted
    public boolean isSorted(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
           // If any element is smaller than the previous one, return false
            if (arr[i] < arr[i - 1]) 
                return false;
        }
        return true;  // Return true if the array is sorted
    }
}

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;
        Solution obj = new Solution();
        // Output result
        System.out.println(obj.isSorted(arr, n) ? "True" : "False");
    }
}

