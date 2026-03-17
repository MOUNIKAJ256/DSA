// Problem : Longest Subarray with given Sum K(Positives)
// Platform : Strivers A2Z 
// Approach : Brute Force
// Time Complexity : O(n^3)
// Space Complexity : O(1)

import java.util.*;
class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int maxLength = 0;
        // starting index
        for (int startIndex = 0; startIndex < n; startIndex++) {
            // ending index
            for (int endIndex = startIndex; endIndex < n; endIndex++) {
                /* add all the elements of
                   subarray = nums[startIndex...endIndex] */
                int currentSum = 0;
                for (int i = startIndex; i <= endIndex; i++) {
                    currentSum += nums[i];
                }
                if (currentSum == k) {
                    maxLength = Math.max(maxLength, endIndex - startIndex + 1);
                }
            }
        }
        return maxLength;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] a = { -1, 1, 1 };
        int k = 1;
      
        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Function call to get the result
        int len = solution.longestSubarray(a, k);
        System.out.println("The length of the longest subarray is: " + len);
    }
}



// Approach : Optimal
// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.*;
// Class containing the sliding window algorithm
class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        // To store the maximum length of the subarray
        int maxLen = 0;
        // Pointers for sliding window
        int left = 0, right = 0;
        // Sum of the current window
        int sum = nums[0];
        // Traverse through the array
        while (right < n) {
            // Shrink the window if sum exceeds k
            while (left <= right && sum > k) {
                sum -= nums[left];
                left++;
            }
            // Update max length if sum equals k
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            // Expand the window to the right
            right++;
            if (right < n) {
                sum += nums[right];
            }
        }
        return maxLen;
    }
}

// Separate class containing only the main method
public class Main {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 7, 1, 9};
        int k = 15;

        // Create Solution object
        Solution sol = new Solution();

        // Function call to find the result
        int ans = sol.longestSubarray(nums, k);

        // Output the result
        System.out.println("The length of longest subarray having sum k is: " + ans);
    }
}
