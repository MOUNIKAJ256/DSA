// Problem : Minimise Maximum Distance between Gas Stations
// Platform : Striver A2Z 
// Approach : Brute force
// Time Complexity : O(k * n) + O(n)
// Space Complexity : O(n - 1)

import java.util.*;

class GasStationSolver {
    public double minimiseMaxDistance(int[] arr, int k) {
        int n = arr.length;
        int[] howMany = new int[n - 1]; // Number of gas stations in each segment

        // Place each gas station
        for (int gasStations = 1; gasStations <= k; gasStations++) {
            double maxSection = -1;
            int maxInd = -1;

            // Find the segment with the maximum distance
            for (int i = 0; i < n - 1; i++) {
                double diff = arr[i + 1] - arr[i];
                double sectionLength = diff / (howMany[i] + 1.0);

                if (sectionLength > maxSection) {
                    maxSection = sectionLength;
                    maxInd = i;
                }
            }

            // Add gas station to the selected segment
            howMany[maxInd]++;
        }

        // Find the final max section length after placing all gas stations
        double maxAns = -1;
        for (int i = 0; i < n - 1; i++) {
            double diff = arr[i + 1] - arr[i];
            double sectionLength = diff / (howMany[i] + 1.0);
            maxAns = Math.max(maxAns, sectionLength);
        }

        return maxAns;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;

        GasStationSolver solver = new GasStationSolver();
        double ans = solver.minimiseMaxDistance(arr, k);

        System.out.println("The answer is: " + ans);
    }
}



// Approach : Better
// Time Complexity : O(nlogn + klogn)
// Space Complexity : O(n-1)+O(n-1)

import java.util.*;

class Pair {
    double distance;
    int index;

    Pair(double distance, int index) {
        this.distance = distance;
        this.index = index;
    }
}

class Solution {
    public double minimiseMaxDistance(int[] arr, int k) {
        int n = arr.length;
        int[] howMany = new int[n - 1];

        // Priority queue (max-heap) to store the largest segment first
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b.distance, a.distance)
        );

        // Add initial segments
        for (int i = 0; i < n - 1; i++) {
            pq.add(new Pair(arr[i + 1] - arr[i], i));
        }

        // Place k additional gas stations
        for (int gasStations = 1; gasStations <= k; gasStations++) {
            Pair top = pq.poll();
            int idx = top.index;
            howMany[idx]++;

            double totalDist = arr[idx + 1] - arr[idx];
            double newDist = totalDist / (howMany[idx] + 1);
            pq.add(new Pair(newDist, idx));
        }

        // Return max distance after placing k stations
        return pq.peek().distance;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        Solution sol = new Solution();
        System.out.println("The answer is: " + sol.minimiseMaxDistance(arr, k));
    }
}




// Approach : Optimal
// Time Complexity : O(n*log(Len)) + O(n)
// Space Complexity : O(1)

import java.util.*;

public class GasStationOptimizer {

    // Method to calculate required number of gas stations
    public int numberOfGasStationsRequired(double dist, int[] arr) {
        int n = arr.length;
        int count = 0;

        for (int i = 1; i < n; i++) {
            int numberInBetween = (int) ((arr[i] - arr[i - 1]) / dist);
            if ((arr[i] - arr[i - 1]) == (dist * numberInBetween)) {
                numberInBetween--;
            }
            count += numberInBetween; //total number of additional gas stations required
        }

        return count;  //total number of additional gas stations required
    }

    // Method to minimize the maximum distance between gas stations
    public double minimiseMaxDistance(int[] arr, int k) {
        int n = arr.length;
        double low = 0, high = 0;

        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, arr[i + 1] - arr[i]);
        }

        double diff = 1e-6;

        while (high - low > diff) {
            double mid = (low + high) / 2.0;
            int count = numberOfGasStationsRequired(mid, arr);

            if (count > k) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return high;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;

        GasStationOptimizer optimizer = new GasStationOptimizer();
        double result = optimizer.minimiseMaxDistance(arr, k);

        System.out.println("The answer is: " + result);
    }
}
