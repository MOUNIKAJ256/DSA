// Problem : Painter's Partition
// Platform : Striver A2Z 
// Approach : Brute force
// Time Complexity : O(N * (sum(arr[])-max(arr[])+1))
// Space Complexity : O(1)

import java.util.*;

public class PainterPartition {

    // Function to count how many painters are required if each painter paints at most 'time' units
    public int countPainters(int[] boards, int time) {
        int painters = 1;         // Start with one painter
        int boardsPainter = 0;    // Time consumed by current painter

        for (int board : boards) {
            if (boardsPainter + board <= time) {
                // Assign board to current painter
                boardsPainter += board;
            } else {
                // Assign board to next painter
                painters++;
                boardsPainter = board;
            }
        }

        return painters;
    }

    // Function to find the minimum possible maximum time to paint all boards using k painters
    public int findLargestMinDistance(int[] boards, int k) {
        int low = Arrays.stream(boards).max().getAsInt();  // Largest single board
        int high = Arrays.stream(boards).sum();            // Sum of all boards

        for (int time = low; time <= high; time++) {
            if (countPainters(boards, time) <= k) {
                return time;  // Found a valid minimum time
            }
        }

        return low;  // Fallback (shouldn't usually reach here)
    }

    public static void main(String[] args) {
        int[] boards = {10, 20, 30, 40};  // Length of boards
        int k = 2;  // Number of painters

        PainterPartition pp = new PainterPartition();
        int ans = pp.findLargestMinDistance(boards, k);

        System.out.println("The answer is: " + ans);  // Expected: 60
    }
}



// Approach : Optimal
// Time Complexity : O(N * log(sum(arr[])-max(arr[])+1))
// Space Complexity : O(1)

import java.util.*;

public class PainterPartition {

    // Count how many painters are needed for a given max time
    public int countPainters(int[] boards, int time) {
        int painters = 1;
        int boardsPainter = 0;

        for (int board : boards) {
            if (boardsPainter + board <= time) {
                boardsPainter += board;
            } else {
                painters++;
                boardsPainter = board;
            }
        }

        return painters;
    }

    // Binary search to find minimum possible time to paint all boards
    public int findLargestMinDistance(int[] boards, int k) {
        int low = Arrays.stream(boards).max().getAsInt();
        int high = Arrays.stream(boards).sum();
        int result = high;

        while (low <= high) {
            int mid = (low + high) / 2;
            int painters = countPainters(boards, mid);

            if (painters > k) {
                low = mid + 1; // Too few painters → increase allowed time
            } else {
                result = mid; // Valid time → try to reduce it
                high = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] boards = {10, 20, 30, 40};
        int k = 2;

        PainterPartition pp = new PainterPartition();
        int ans = pp.findLargestMinDistance(boards, k);
        System.out.println("The answer is: " + ans); // Expected: 60
    }
}
