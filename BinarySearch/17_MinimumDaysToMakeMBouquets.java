// Problem : Minimum days to make M bouquets
// Platform : Striver A2Z 
// Approach : Brute force
// Time Complexity : O((max(arr[])-min(arr[])+1) * N)
// Space Complexity : O(1)

import java.util.*;

public class RoseGarden {

    // Function to check if it's possible to make 'm' bouquets on 'day'
    public boolean isPossible(int[] bloomDays, int day, int m, int k) {
        int count = 0;  // count of consecutive bloomed flowers
        int bouquets = 0;

        for (int bloom : bloomDays) {
            if (bloom <= day) {
                count++;
                if (count == k) {
                    bouquets++;
                    count = 0;
                }
            } else {
                count = 0;
            }
        }

        return bouquets >= m;
    }

    // Main function to return minimum day to make 'm' bouquets
    public int minDaysToMakeBouquets(int[] bloomDays, int m, int k) {
        long totalFlowers = (long) m * k;
        if (totalFlowers > bloomDays.length) return -1;

        int min = Arrays.stream(bloomDays).min().getAsInt();
        int max = Arrays.stream(bloomDays).max().getAsInt();

        for (int day = min; day <= max; day++) {
            if (isPossible(bloomDays, day, m, k)) {
                return day;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] bloomDays = {7, 7, 7, 7, 13, 11, 12, 7};
        int k = 3;
        int m = 2;

        RoseGarden garden = new RoseGarden();
        int result = garden.minDaysToMakeBouquets(bloomDays, m, k);

        if (result == -1)
            System.out.println("We cannot make m bouquets.");
        else
            System.out.println("We can make bouquets on day " + result);
    }
}



// Approach : Optimal
// Time Complexity : O(N * log(max(bloomDays) - min(bloomDays) + 1))
// Space Complexity : O(1) 

import java.util.*;

public class RoseGarden {

    // Function to check if it's possible to make m bouquets on or before 'day'
    public static boolean isPossible(int[] bloomDays, int day, int m, int k) {
        int count = 0; // counts consecutive flowers that bloomed on or before 'day'
        int bouquets = 0; // number of bouquets made

        for (int bloom : bloomDays) {
            if (bloom <= day) {
                count++; // flower is ready
                if (count == k) {
                    bouquets++; // form one bouquet
                    count = 0; // reset count for next bouquet
                }
            } else {
                count = 0; // break in consecutive flowers
            }
        }

        return bouquets >= m; // check if required bouquets can be made
    }

    // Main function to find minimum day to make m bouquets
    public static int roseGarden(int[] bloomDays, int k, int m) {
        long required = (long) m * k;
        if (required > bloomDays.length) return -1; // not enough flowers

        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;

        // Find the minimum and maximum bloom day
        for (int bloom : bloomDays) {
            minDay = Math.min(minDay, bloom);
            maxDay = Math.max(maxDay, bloom);
        }

        // Binary search between minDay and maxDay
        int low = minDay, high = maxDay, result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(bloomDays, mid, m, k)) {
                result = mid; // possible to form bouquets, try earlier
                high = mid - 1;
            } else {
                low = mid + 1; // need more days
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] bloomDays = {7, 7, 7, 7, 13, 11, 12, 7};
        int k = 3;
        int m = 2;
        int result = roseGarden(bloomDays, k, m);
        if (result == -1)
            System.out.println("We cannot make m bouquets.");
        else
            System.out.println("We can make bouquets on day " + result);
    }
}
