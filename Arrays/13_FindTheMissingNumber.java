// Problem : find the missing number
// Platform : Strivers A2Z 
// Approach : Brute Force
// Time Complexity : O(n^2)
// Space Complexity : O(1)

public class MissingNumber {
    public static int missingNum(int[] arr) {
        int n = arr.length + 1;

        // Iterate from 1 to n and check
        // if the current number is present
        for (int i = 1; i <= n; i++) {
            boolean found = false;
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] == i) {
                    found = true;
                    break;
                }
            }

            // If the current number is not present
            if (!found)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {8, 2, 4, 5, 3, 7, 1};  
        System.out.println(missingNum(arr));
    }
}



// Approach : Better ( Using Hashing )
// Time Complexity : O(n)
// Space Complexity : O(n)

import java.util.Arrays;
public class MissingNumber {
    public static int missingNum(int[] arr) {
        int n = arr.length + 1;

        // Create hash array of size n+1
        int[] hash = new int[n + 1];

        // Store frequencies of elements
        for (int i = 0; i < n - 1; i++) {
            hash[arr[i]]++;
        }

        // Find the missing number
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {8, 2, 4, 5, 3, 7, 1};
        int res = missingNum(arr);
        System.out.println(res);
    }
}



// Approach : Optimal-1 [ Using Sum of n terms Formula ]
// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.*;
public class MissingNumber {
   public static int missingNum(int[] arr) {
        long n = arr.length + 1;
    
        // Calculate the sum of array elements
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
    
        // Use long for expected sum to avoid overflow
        long expSum = n * (n + 1) / 2;
    
        // Return the missing number
        return (int)(expSum - sum);
    }

    public static void main(String[] args) {
        int[] arr = {8, 2, 4, 5, 3, 7, 1};
        System.out.println(missingNum(arr));
    }
}


// Approach : Optimal-2 [ Using XOR Operation ]
// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.Arrays;
public class MissingNumber {
    public static int missingNum(int[] arr) {
        int n = arr.length + 1;
        int xor1 = 0, xor2 = 0;

        // XOR all array elements
        for (int i = 0; i < n - 1; i++) {
            xor2 ^= arr[i];
        }

        // XOR all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            xor1 ^= i;
        }
      
        // Missing number is the XOR of xor1 and xor2
        return xor1 ^ xor2;
    }

    public static void main(String[] args) {
        int[] arr = {8, 2, 4, 5, 3, 7, 1};
        int res = missingNum(arr);
        System.out.println(res);
    }
}
