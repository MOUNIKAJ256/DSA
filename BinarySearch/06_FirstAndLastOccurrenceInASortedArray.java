// Problem : First and Last occurrence in a sorted array
// Platform : Striver A2Z 
// Approach : Brute force
// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.*;

// provides last-occurrence logic
class Solution {
    // find last index of key by scanning from right
    public int solve(int n, int key, List<Integer> v) {
        // initialize result as not found
        int res = -1;
        // scan from the end toward the start
        for (int i = n - 1; i >= 0; i--) {
            // update and stop when match found
            if (v.get(i) == key) {
                res = i;
                break;
            }
        }
        // return index or -1
        return res;
    }
}

// separate main class (as requested)
public class Main {
    // program entry
    public static void main(String[] args) {
        // set size
        int n = 7;
        // set key to search
        int key = 13;
        // define input list
        List<Integer> v = Arrays.asList(3, 4, 13, 13, 13, 20, 40);
        // compute answer
        Solution sol = new Solution();
        int ans = sol.solve(n, key, v);
        // print last occurrence index (or -1)
        System.out.println(ans);
    }
}



// Approach : Optimal
// Time Complexity : O(logn)
// Space Complexity : O(1)

import java.util.*;

// provides last-occurrence binary search
class Solution {
    // find last index of key using binary search
    public int solve(int n, int key, List<Integer> v) {
        // initialize search bounds and result
        int start = 0;
        int end = n - 1;
        int res = -1;

        // binary search loop
        while (start <= end) {
            // compute mid safely
            int mid = start + (end - start) / 2;
            // when match found, store index and move right
            if (v.get(mid) == key) {
                res = mid;
                start = mid + 1;
            }
            // when key is smaller, move left
            else if (key < v.get(mid)) {
                end = mid - 1;
            }
            // otherwise move right
            else {
                start = mid + 1;
            }
        }
        // return last occurrence or -1
        return res;
    }
}

// separate main class
public class Main {
    // program entry
    public static void main(String[] args) {
        // define input size and key
        int key = 13;
        // define sorted list
        List<Integer> v = Arrays.asList(3, 4, 13, 13, 13, 20, 40);
        // compute n from list size
        int n = v.size();
        // run search
        Solution sol = new Solution();
        int ans = sol.solve(n, key, v);
        // print result
        System.out.println(ans);
    }
}

