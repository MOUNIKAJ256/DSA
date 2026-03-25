// Problem : Rearrange Array Elements by Sign
// Platform : Strivers A2Z 
// Approach : Brute Force
// Time Complexity : O(n + n/2)
// Space Complexity : O(n)

import java.util.*;
class ArrayManipulator {
    // Method to rearrange elements so that positives and negatives alternate
    public int[] rearrangeBySign(int[] A, int n) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        // Step 1: Separate positives and negatives
        for (int i = 0; i < n; i++) {
            if (A[i] > 0)
                pos.add(A[i]); // Add to positives
            else
                neg.add(A[i]); // Add to negatives
        }

        // Step 2: Place positives at even indices and negatives at odd indices
        for (int i = 0; i < n / 2; i++) {
            A[2 * i] = pos.get(i);       // Even index → positive
            A[2 * i + 1] = neg.get(i);   // Odd index → negative
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, -4, -5};
        int n = A.length;

        ArrayManipulator obj = new ArrayManipulator();
        int[] result = obj.rearrangeBySign(A, n);

        // Print the result
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}



// Approach : Optimal
// Time Complexity : O(n)
// Space Complexity : O(n)

import java.util.*;
public class ArrayManipulator {
    // Function to rearrange elements by alternating sign
    public int[] rearrangeBySign(int[] A) {
        int n = A.length;

        // Result array initialized to size n
        int[] ans = new int[n];

        // posIndex for even indices (positive), negIndex for odd (negative)
        int posIndex = 0, negIndex = 1;

        // Traverse input array
        for (int i = 0; i < n; i++) {
            if (A[i] < 0) {
                // Place negative number at odd index
                ans[negIndex] = A[i];
                negIndex += 2;
            } else {
                // Place positive number at even index
                ans[posIndex] = A[i];
                posIndex += 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, -4, -5};

        ArrayManipulator obj = new ArrayManipulator();
        int[] result = obj.rearrangeBySign(A);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
