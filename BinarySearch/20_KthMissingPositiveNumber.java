// Problem : Kth Missing Positive Number
// Platform : Striver A2Z 
// Approach : Brute force
// Time Complexity : O(N)
// Space Complexity : O(1)

import java.util.*;

class MissingKFinder {
    // Method to find the k-th missing number
    public int missingK(int[] vec, int k) {
        for (int i = 0; i < vec.length; i++) {
            if (vec[i] <= k) {
                k++;  // Skip current number and adjust k
            } else {
                break; // Stop if current number is greater than k
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] vec = {4, 7, 9, 10};  // Sorted array
        int k = 4;                  // We want the 4th missing number

        MissingKFinder finder = new MissingKFinder();
        int ans = finder.missingK(vec, k);  // Call method

        System.out.println("The missing number is: " + ans);  // Output result
    }
}



// Approach : Optimal
// Time Complexity : O(logn)
// Space Complexity : O(1)

import java.util.*;

class MissingKFinder {
    // Function to return the k-th missing number
    public int missingK(int[] vec, int k) {
        int low = 0, high = vec.length - 1;

        // Binary search loop
        while (low <= high) {
            int mid = (low + high) / 2;

            // Number of missing elements before index mid
            int missing = vec[mid] - (mid + 1);

            if (missing < k) {
                low = mid + 1;  // Move right
            } else {
                high = mid - 1; // Move left
            }
        }

        // Final result after binary search
        return k + high + 1;
    }

    public static void main(String[] args) {
        int[] vec = {4, 7, 9, 10};
        int k = 4;

        MissingKFinder finder = new MissingKFinder();
        int ans = finder.missingK(vec, k);

        System.out.println("The missing number is: " + ans);
    }
}
