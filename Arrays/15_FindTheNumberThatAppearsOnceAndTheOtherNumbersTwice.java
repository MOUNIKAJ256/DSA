// Problem : Find the number that appears once, and the other numbers twice
// Platform : Strivers A2Z 
// Approach : Brute Force
// Time Complexity : O(n^2)
// Space Complexity : O(1)

import java.util.*;
class Solution {
    // Function to find the single element using brute force
    public int getSingleElement(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int count = 0;

            // Count how many times num occurs
            for (int j = 0; j < n; j++) {
                if (arr[j] == num)
                    count++;
            }

            // If only once, return it
            if (count == 1) return num;
        }
        // fallback, won't be hit if array has a single element
        return -1; 
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};

        Solution obj = new Solution();
        int ans = obj.getSingleElement(arr);

        System.out.println("The single element is: " + ans);
    }
}



// Approach : Better
// Time Complexity : O(3n)
// Space Complexity : O(1)

import java.util.*;
import java.util.*;

class Solution {
    // Function to find the single element using a hash array
    public int getSingleElement(int[] arr) {
        int n = arr.length;

        // Find maximum element
        int maxi = arr[0];
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }

        // Create frequency array of size maxi+1
        int[] hash = new int[maxi + 1];

        // Count frequencies
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }

        // Find element with frequency = 1
        for (int i = 0; i < n; i++) {
            if (hash[arr[i]] == 1)
                return arr[i];
        }
        // fallback
        return -1; 
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};
        Solution obj = new Solution();
        int ans = obj.getSingleElement(arr);
        System.out.println("The single element is: " + ans);
    }
}



// Approach : Optimal
// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.*;
class Solution {
    // Function to find the element that appears once using XOR
    public int getSingleElement(int[] arr) {
        int xorr = 0;

        // XOR all elements — duplicates cancel each other out
        for (int num : arr) {
            xorr ^= num;
        }

        return xorr;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};

        Solution obj = new Solution();
        int ans = obj.getSingleElement(arr);
        System.out.println("The single element is: " + ans);
    }
}
