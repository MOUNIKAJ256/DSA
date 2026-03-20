// Problem : Two Sum
// Platform : Strivers A2Z 
// Approach : Brute Force
// Time Complexity : O(n^2)
// Space Complexity : O(1)

import.java.util.*;
class Solution {
    // Function to check if any two numbers sum up to target (variant 1)
    public String twoSumExists(int[] arr, int target) {
        int n = arr.length;
        // Outer loop picks one element at a time
        for (int i = 0; i < n; i++) {
            // Inner loop searches for another element that complements arr[i]
            for (int j = i + 1; j < n; j++) {
                // If sum equals target, return "YES"
                if (arr[i] + arr[j] == target) {
                    return "YES";
                }
            }
        }
        // No pair found that sums to target
        return "NO";
    }

    // Function to return indices of two numbers that sum to target (variant 2)
    public int[] twoSumIndices(int[] arr, int target) {
        int n = arr.length;
        // Outer loop picks one element at a time
        for (int i = 0; i < n; i++) {
            // Inner loop searches for another element that complements arr[i]
            for (int j = i + 1; j < n; j++) {
                // If sum equals target, return the pair of indices
                if (arr[i] + arr[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        // No such pair found
        return new int[]{-1, -1};
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;

        // Variant 1
        System.out.println(sol.twoSumExists(arr, target));

        // Variant 2
        int[] res = sol.twoSumIndices(arr, target);
        System.out.println("[" + res[0] + ", " + res[1] + "]");
    }
}



// Approach : Better
// Time Complexity : O(n)
// Space Complexity : O(n)

import java.util.HashMap;
class Solution {
    // Variant 1: Check if two numbers sum to target using hashing
    public String twoSumExists(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // Iterate over all elements
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            // Check if complement exists in map
            if (map.containsKey(complement)) {
                return "YES";  // Pair found
            }
            // Store current element and its index
            map.put(arr[i], i);
        }
        // No pair found
        return "NO";
    }

    // Variant 2: Return indices of two numbers that sum to target using hashing
    public int[] twoSumIndices(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            // If complement found, return indices
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            // Store current element and index
            map.put(arr[i], i);
        }
        // No pair found
        return new int[] { -1, -1 };
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;

        System.out.println(sol.twoSumExists(arr, target));
        int[] res = sol.twoSumIndices(arr, target);
        System.out.println("[" + res[0] + ", " + res[1] + "]");
    }
}



// Approach : Optimal
// Time Complexity : O(nlogn)
// Space Complexity : O(n)

import java.util.Arrays;
class Solution {
    // Variant 1: Check if two numbers sum to target using two-pointer approach
    public String twoSumExists(int[] arr, int target) {
        int n = arr.length;
        
        // Create an array of pairs [value, original_index]
        int[][] numsWithIndex = new int[n][2];
        
        // Store each element with its original index
        for (int i = 0; i < n; i++) {
            numsWithIndex[i][0] = arr[i]; // value
            numsWithIndex[i][1] = i;      // original index
        }
        
        // Sort the array based on the value, not index
        Arrays.sort(numsWithIndex, (a, b) -> Integer.compare(a[0], b[0]));

        // Initialize two pointers: one at start, one at end
        int left = 0, right = n - 1;
        
        // Run loop until pointers cross
        while (left < right) {
            // Calculate the sum of values at pointers
            int sum = numsWithIndex[left][0] + numsWithIndex[right][0];
            
            if (sum == target) {
                // Found the pair, return "YES"
                return "YES";
            } else if (sum < target) {
                // Sum is less than target, so move left pointer right to increase sum
                left++;
            } else {
                // Sum is greater than target, so move right pointer left to decrease sum
                right--;
            }
        }
        
        // If loop ends without returning, no pair found
        return "NO";
    }

    // Variant 2: Return indices of two numbers that sum to target
    public int[] twoSumIndices(int[] arr, int target) {
        int n = arr.length;
        int[][] numsWithIndex = new int[n][2];
        
        // Store element with original index
        for (int i = 0; i < n; i++) {
            numsWithIndex[i][0] = arr[i];
            numsWithIndex[i][1] = i;
        }
        
        // Sort by the value to apply two-pointer
        Arrays.sort(numsWithIndex, (a, b) -> Integer.compare(a[0], b[0]));

        int left = 0, right = n - 1;
        while (left < right) {
            int sum = numsWithIndex[left][0] + numsWithIndex[right][0];
            if (sum == target) {
                // Return original indices of the two numbers found
                return new int[] {numsWithIndex[left][1], numsWithIndex[right][1]};
            } else if (sum < target) {
                // Increase sum by moving left pointer forward
                left++;
            } else {
                // Decrease sum by moving right pointer backward
                right--;
            }
        }
        
        // No pair found
        return new int[] {-1, -1};
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;

        System.out.println(sol.twoSumExists(arr, target)); // Output: YES
        int[] res = sol.twoSumIndices(arr, target);
        System.out.println("[" + res[0] + ", " + res[1] + "]"); // Output: [1, 3]
    }
}
