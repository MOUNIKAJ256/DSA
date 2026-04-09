// Problem : Merge Overlapping Sub-intervals
// Platform : Striver A2Z 
// Approach : Brute Force
// Time Complexity : O(n ^ 2)
// Space Complexity : O(n)

import java.util.*;
class Solution {
    // Function to merge overlapping intervals using brute force
    public List<List<Integer>> merge(int[][] intervals) {

        // Sort intervals based on starting point
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<List<Integer>> ans = new ArrayList<>();

        int n = intervals.length;
        int i = 0;

        // Loop through intervals
        while (i < n) {
            // Start of merged interval
            int start = intervals[i][0];
            int end = intervals[i][1];

            int j = i + 1;

            // Check all overlapping intervals
            while (j < n && intervals[j][0] <= end) {
                // Extend the end of current interval
                end = Math.max(end, intervals[j][1]);
                j++;
            }

            // Add merged interval to result
            ans.add(Arrays.asList(start, end));

            // Move to next non-overlapping interval
            i = j;
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        List<List<Integer>> result = sol.merge(intervals);
        for (List<Integer> interval : result) {
            System.out.print(interval + " ");
        }
    }
}



// Approach : Optimal
// Time Complexity : O(N * logN) + O(N)
// Space Complexity : O(n)

import java.util.*;
class Solution {
    // Function to merge overlapping intervals
    public List<List<Integer>> merge(int[][] intervals) {
        // Sort intervals based on start time
        Arrays.sort(
            intervals,
            (a, b) -> Integer.compare(a[0], b[0])
        );

        // List to store merged intervals
        List<List<Integer>> merged = new ArrayList<>();

        // Traverse through all intervals
        for (int[] interval : intervals) {
            // If merged list is empty or no overlap
            if (
                merged.isEmpty() ||
                merged.get(merged.size() - 1).get(1) < interval[0]
            ) {
                // Add current interval as a new block
                merged.add(
                    Arrays.asList(interval[0], interval[1])
                );
            } else {
                // Overlapping: update end to max of both
                int last = merged.size() - 1;
                int maxEnd = Math.max(
                    merged.get(last).get(1),
                    interval[1]
                );
                merged.get(last).set(1, maxEnd);
            }
        }

        return merged;
    }
}

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] intervals = {
            {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };

        List<List<Integer>> result = sol.merge(intervals);

        for (List<Integer> interval : result) {
            System.out.print(
                "[" + interval.get(0) + "," + interval.get(1) + "] "
            );
        }
    }
}
