// Problem : Longest Consecutive Sequence in an Array
// Platform : Striver A2Z 
// Approach : Brute Force
// Time Complexity : O(n^2)
// Space Complexity : O(1)

import java.util.*;
class Solution {
    // Function to search for a given number in the array
    private boolean linearSearch(int[] a, int num) {
        // Get length of the array
        int n = a.length;
        // Traverse through the array to check if the number exists
        for (int i = 0; i < n; i++) {
            // If element matches the number, return true
            if (a[i] == num)
                return true;
        }
        // Number not found
        return false;
    }

    // Function to find the length of the longest consecutive sequence
    public int longestConsecutive(int[] nums) {
        // If the array is empty, no sequence exists
        if (nums.length == 0) {
            return 0;
        }
        
        // Get length of the array
        int n = nums.length;
        
        // Initialize the longest sequence length to 1 (minimum possible)
        int longest = 1;

        // Iterate over each element of the array
        for (int i = 0; i < n; i++) {
            // Store the current number
            int x = nums[i];
            
            // Start sequence length count from 1
            int cnt = 1;

            // Search for consecutive numbers starting from x + 1
            while (linearSearch(nums, x + 1) == true) {
                // Move to the next consecutive number
                x += 1;
                
                // Increase the count of the current sequence
                cnt += 1;
            }

            // Update the longest sequence length if the current is longer
            longest = Math.max(longest, cnt);
        }
        
        // Return the longest consecutive sequence length found
        return longest;
    }

    public static void main(String[] args) {
        // Input array of integers
        int[] a = {100, 4, 200, 1, 3, 2};

        // Create an instance of Solution class
        Solution solution = new Solution();

        // Call the function and store the result
        int ans = solution.longestConsecutive(a);
        
        // Output the result
        System.out.println("The longest consecutive sequence is " + ans);
    }
}



// Approach : Better
// Time Complexity : O(nlogn)
// Space Complexity : O(1)

import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        // Store the size of the array
        int n = nums.length;

        // Return 0 if array is empty
        if (n == 0) return 0; 

        // Sort the array to bring consecutive numbers together
        Arrays.sort(nums); 

        // Variable to track the last smaller element in sequence
        int lastSmaller = Integer.MIN_VALUE; 

        // Variable to store the current sequence length
        int cnt = 0; 

        // Variable to store the longest sequence length found
        int longest = 1; 

        // Iterate through the sorted array
        for (int i = 0; i < n; i++) {
            // Case 1: Current element is exactly one greater than lastSmaller → part of sequence
            if (nums[i] - 1 == lastSmaller) {
                // Increment the sequence length
                cnt += 1; 
                // Update the last smaller element
                lastSmaller = nums[i]; 
            } 
            // Case 2: Current element is not consecutive and not a duplicate
            else if (nums[i] != lastSmaller) {
                // Reset the sequence length count to 1
                cnt = 1; 
                // Update the last smaller element
                lastSmaller = nums[i]; 
            }
            // Update the longest sequence length if the current sequence is longer
            longest = Math.max(longest, cnt); 
        }
        
        // Return the length of the longest consecutive sequence
        return longest;
    }

    public static void main(String[] args) {
        // Input array
        int[] a = {100, 4, 200, 1, 3, 2}; 

        // Create an instance of Solution class
        Solution solution = new Solution(); 
        
        // Function call for finding longest consecutive sequence
        int ans = solution.longestConsecutive(a); 
        
        // Output the result
        System.out.println("The longest consecutive sequence is " + ans);
    }
}



// Approach : Optimal
// Time Complexity : O(n)
// Space Complexity : O(n)

import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        // Get the length of the array
        int n = nums.length;

        // If the array is empty, no sequence exists
        if (n == 0) return 0;

        // Variable to store the longest sequence length found
        int longest = 1; 

        // HashSet to store unique elements for O(1) lookup
        Set<Integer> st = new HashSet<>();

        // Add all elements to the set to remove duplicates
        for (int i = 0; i < n; i++) {
            st.add(nums[i]);
        }

        /* Loop through each element in the set to find 
           the starting point of consecutive sequences */
        for (int it : st) {
            // If there is no number before 'it', it’s the start of a sequence
            if (!st.contains(it - 1)) {
                // Start the count for this sequence
                int cnt = 1; 
                // Store the current number
                int x = it; 

                // Keep checking for the next consecutive number
                while (st.contains(x + 1)) {
                    // Move to the next number in sequence
                    x = x + 1; 
                    // Increment the length of current sequence
                    cnt = cnt + 1; 
                }

                // Update the longest sequence length if needed
                longest = Math.max(longest, cnt);
            }
        }

        // Return the length of the longest sequence
        return longest;
    }

    public static void main(String[] args) {
        // Input array
        int[] a = {100, 4, 200, 1, 3, 2}; 

        // Create an instance of Solution class
        Solution solution = new Solution(); 
        
        // Call the function to get the longest consecutive sequence length
        int ans = solution.longestConsecutive(a); 
        
        // Print the result
        System.out.println("The longest consecutive sequence is " + ans); 
    }
}
