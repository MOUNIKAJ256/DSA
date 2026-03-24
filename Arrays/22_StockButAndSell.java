// Problem : Stock Buy And Sell
// Platform : Strivers A2Z 
// Approach : Brute Force
// Time Complexity : O(n^2)
// Space Complexity : O(1)

import java.util.*;
class Solution {
    // Function to calculate max profit using brute force
    public int stockbuySell(int[] prices) {
        // Initialize max profit to 0
        int maxProfit = 0;

        // Loop through each day as a potential buy day
        for (int i = 0; i < prices.length; i++) {
            // Loop through each future day as a potential sell day
            for (int j = i + 1; j < prices.length; j++) {
                // Calculate profit
                int profit = prices[j] - prices[i];

                // Update max profit if higher
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        // Return the maximum profit
        return maxProfit;
    }
}

// Driver class
class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit: " + sol.stockbuySell(prices));
    }
}




// Approach : Optimal
// Time Complexity : O(n)
// Space Complexity : O(1)

import.java.util.*;
class Solution {
    // Function to calculate maximum profit using single pass
    public int stockbuySell(int[] prices) {
        // Initialize the minimum price to a large number
        int minPrice = Integer.MAX_VALUE;

        // Initialize the maximum profit to 0
        int maxProfit = 0;

        // Traverse each price in the array
        for (int price : prices) {
            // If current price is less than minPrice, update minPrice
            if (price < minPrice) {
                minPrice = price;
            }
            // Else calculate profit and update maxProfit if it's greater
            else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        // Return the maximum profit found
        return maxProfit;
    }
}

// Driver code
class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println(obj.stockbuySell(prices));
    }
}
