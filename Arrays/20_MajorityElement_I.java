// Problem : Find the Majority Element that occurs more than N/2 times
// Platform : Strivers A2Z 
// Approach : Brute Force
// Time Complexity : O(n^2)
// Space Complexity : O(1)

import java.util.*;

// Class containing the majority element logic
class Solution {
    // Function to find the majority element in an array
    public int majorityElement(int[] nums) {
        
        // Size of the given array
        int n = nums.length;
        
        // Iterate through each element of the array
        for (int i = 0; i < n; i++) {
            
            // Counter to count occurrences of nums[i]
            int cnt = 0; 
            
            // Count the frequency of nums[i] in the array
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    cnt++;
                }
            }
            
            // Check if frequency of nums[i] is greater than n/2
            if (cnt > (n / 2)) {
                // Return the majority element
                return nums[i]; 
            }
        }
        
        // Return -1 if no majority element is found
        return -1; 
    }
}

// Separate class containing only the main method
public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        
        // Create an instance of Solution class
        Solution sol = new Solution();
 
        int ans = sol.majorityElement(arr);
        
        // Print the majority element found
        System.out.println("The majority element is: " + ans);
    }
}



// Approach : Better
// Time Complexity : O(n)
// Space Complexity : O(n)

import java.util.*;

// Class containing the majority element logic
class Solution {
    // Function to find the majority element in an array
    public int majorityElement(int[] nums) {
        
        // Size of the given array
        int n = nums.length;
        
        // Hash map to store element counts
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Count occurrences of each element
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        /* Iterate through the map to
           find the majority element */
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 2) {
                return entry.getKey();
            }
        }
        
        // Return -1 if no majority element is found
        return -1;
    }
}

// Separate class containing only the main method
public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        
        // Create an instance of Solution class
        Solution sol = new Solution();
 
        int ans = sol.majorityElement(arr);
        
        // Print the majority element found
        System.out.println("The majority element is: " + ans);
    }
}



// Approach : Optimal
// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.*;

// Class containing the majority element logic
class Solution {
    // Function to find the majority element in an array
    public int majorityElement(int[] nums) {
        // Size of the given array
        int n = nums.length;
        
        // Count variable
        int cnt = 0;
        
        // Candidate element
        int el = 0;
        
        // Step 1: Find the potential majority element
        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                cnt = 1;
                el = nums[i];
            } else if (el == nums[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }
        
        // Step 2: Verify the candidate
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == el) {
                cnt1++;
            }
        }
        
        // Return the element if it's a majority
        if (cnt1 > (n / 2)) {
            return el;
        }
        
        // No majority found
        return -1;
    }
}

// Separate Main class for execution
public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        
        // Create an instance of Solution class
        Solution sol = new Solution();

        // Call the majorityElement function
        int ans = sol.majorityElement(arr);
        
        // Print the majority element
        System.out.println("The majority element is: " + ans);
    }
}
