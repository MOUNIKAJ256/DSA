// Problem : Capacity to Ship Packages within D Days
// Platform : Striver A2Z 
// Approach : Brute force
// Time Complexity : O((sum_weights - max_weight) * N)
// Space Complexity : O(1)

import java.util.*;

class Solution {
    // Function to check how many days needed for given capacity
    int daysNeeded(int[] weights, int capacity) {
        // Initialize day count to 1
        int days = 1;
        // Current load for the day
        int currentLoad = 0;

        // Iterate over all package weights
        for (int w : weights) {
            // If adding weight exceeds capacity
            if (currentLoad + w > capacity) {
                // Increase day count and reset load
                days++;
                currentLoad = w;
            } else {
                // Otherwise, add weight to current load
                currentLoad += w;
            }
        }
        // Return total days needed
        return days;
    }

    // Function to find minimum ship capacity to ship in d days
    int shipWithinDays(int[] weights, int d) {
        // Find maximum weight as minimum capacity
        int left = Arrays.stream(weights).max().getAsInt();
        // Find total sum as maximum capacity
        int right = Arrays.stream(weights).sum();

        // Iterate from minimum to maximum capacity
        for (int capacity = left; capacity <= right; capacity++) {
            // Calculate days needed for current capacity
            int needed = daysNeeded(weights, capacity);
            // If days needed are less than or equal to d, return capacity
            if (needed <= d) {
                return capacity;
            }
        }
        // Should never reach here given constraints
        return right;
    }
}

public class Main {
    public static void main(String[] args) {
        // Input weights
        int[] weights = {5,4,5,2,3,4,5,6};
        // Days to ship
        int d = 5;
        // Create Solution instance
        Solution sol = new Solution();
        // Call the function and print result
        System.out.println(sol.shipWithinDays(weights, d));
    }
}



// Approach : Optimal
// Time Complexity :  O(N * log(S))
// Space Complexity : O(1)

import java.util.*;

class Solution {
    // Function to calculate how many days are needed to ship
    // all packages with the given ship capacity
    int daysNeeded(int[] weights, int capacity) {
        // Initialize count of days to 1
        int days = 1;
        // Initialize current load on ship to 0
        int currentLoad = 0;

        // Iterate over all package weights
        for (int w : weights) {
            // Check if adding current package exceeds capacity
            if (currentLoad + w > capacity) {
                // If yes, increase days count since we start a new day
                days++;
                // Reset current load to current package weight
                currentLoad = w;
            } else {
                // Else, add current package weight to current load
                currentLoad += w;
            }
        }
        // Return total days required
        return days;
    }

    // Function to find minimum ship capacity to ship all packages within d days
    int shipWithinDays(int[] weights, int d) {
        // Calculate minimum capacity as max weight in packages
        int left = Arrays.stream(weights).max().getAsInt();
        // Calculate maximum capacity as sum of all weights
        int right = Arrays.stream(weights).sum();

        // Binary search between left and right capacity values
        while (left < right) {
            // Calculate mid value to test
            int mid = left + (right - left) / 2;
            // Calculate how many days needed for capacity mid
            int needed = daysNeeded(weights, mid);

            // If days needed is less or equal to allowed days,
            // try to find smaller capacity on left side
            if (needed <= d) {
                right = mid;
            } else {
                // Else, need more capacity, search on right side
                left = mid + 1;
            }
        }
        // Return minimum capacity found
        return left;
    }
}

public class Main {
    public static void main(String[] args) {
        // Define array of package weights
        int[] weights = {5,4,5,2,3,4,5,6};
        // Define number of days allowed for shipping
        int d = 5;
        // Create Solution object
        Solution sol = new Solution();
        // Print minimum capacity required to ship within d days
        System.out.println(sol.shipWithinDays(weights, d));
    }
}
