// Problem : Aggressive Cows
// Platform : Striver A2Z 
// Approach : Brute force
// Time Complexity : O(NlogN) + O(N *(max(stalls[])-min(stalls[])))
// Space Complexity : O(1)

import java.util.*;

// Class to solve the Aggressive Cows problem
class Solution {
    // Function to check if cows can be placed with min distance d
    public boolean canPlace(int[] stalls, int cows, int d) {
        // Place the first cow at the first stall
        int count = 1;
        int lastPos = stalls[0];

        // Try placing the remaining cows
        for (int i = 1; i < stalls.length; i++) {
            // If current stall is at least 'd' away from last cow
            if (stalls[i] - lastPos >= d) {
                // Place a cow here
                count++;
                lastPos = stalls[i];
            }
            // If all cows placed, return true
            if (count >= cows) return true;
        }
        // Not possible to place all cows
        return false;
    }

    // Function to find maximum minimum distance using brute force
    public int aggressiveCows(int[] stalls, int cows) {
        // Step 1: Sort stall positions
        Arrays.sort(stalls);

        // Step 2: Get the maximum possible distance
        int maxDist = stalls[stalls.length - 1] - stalls[0];

        // Step 3: Variable to store answer
        int ans = 0;

        // Step 4: Try all possible distances
        for (int d = 1; d <= maxDist; d++) {
            // If cows can be placed with distance d
            if (canPlace(stalls, cows, d)) {
                // Update answer
                ans = d;
            }
        }
        // Step 5: Return the maximum valid distance
        return ans;
    }
}

// Driver class
public class Main {
    public static void main(String[] args) {
        // Example input
        int[] stalls = {1, 2, 8, 4, 9};
        int cows = 3;

        // Create object and call function
        Solution obj = new Solution();
        System.out.println(obj.aggressiveCows(stalls, cows));
    }
}



// Approach : Optimal
// Time Complexity : O(NlogN) + O(N * log(max(stalls[])-min(stalls[])))
// Space Complexity : O(1)

import java.util.*;

// Class to solve Aggressive Cows
class Solution {
    // Function to check if cows can be placed with distance d
    public boolean canPlace(int[] stalls, int cows, int d) {
        // Place first cow at first stall
        int count = 1;
        int lastPos = stalls[0];

        // Loop through stalls
        for (int i = 1; i < stalls.length; i++) {
            // If stall is at least d away from last placed cow
            if (stalls[i] - lastPos >= d) {
                // Place cow here
                count++;
                // Update last position
                lastPos = stalls[i];
            }
            // If all cows are placed successfully
            if (count >= cows) return true;
        }
        // Could not place all cows
        return false;
    }

    // Function to maximize minimum distance
    public int aggressiveCows(int[] stalls, int cows) {
        // Sort stalls
        Arrays.sort(stalls);

        // Define search space
        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int ans = 0;

        // Binary search
        while (low <= high) {
            // Find mid distance
            int mid = low + (high - low) / 2;

            // If placement possible
            if (canPlace(stalls, cows, mid)) {
                // Store answer
                ans = mid;
                // Try bigger distance
                low = mid + 1;
            }
            else {
                // Try smaller distance
                high = mid - 1;
            }
        }
        // Return result
        return ans;
    }
}

// Driver class
public class Main {
    public static void main(String[] args) {
        // Input stalls
        int[] stalls = {1, 2, 8, 4, 9};
        // Number of cows
        int cows = 3;

        // Create object
        Solution obj = new Solution();
        // Print result
        System.out.println(obj.aggressiveCows(stalls, cows));
    }
}
