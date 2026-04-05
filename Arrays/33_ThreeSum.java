// Problem : 3 Sum : Find triplets that add up to a zero
// Platform : Striver A2Z 
// Approach : Brute Force
// Time Complexity : O(N3 * log(no. of unique triplets))
// Space Complexity : O(2 * no. of the unique triplets)

import java.util.*;
// Class to solve 3-sum problem
class Solution {
    // Function to find triplets with sum zero
    public List<List<Integer>> threeSum(int[] arr, int n) {
        // Store unique triplets
        Set<List<Integer>> st = new HashSet<>();

        // First loop for first element
        for (int i = 0; i < n; i++) {
            // Second loop for second element
            for (int j = i + 1; j < n; j++) {
                // Third loop for third element
                for (int k = j + 1; k < n; k++) {
                    // If triplet sum is zero
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        // Store sorted triplet to avoid duplicates
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        Collections.sort(temp);
                        st.add(temp);
                    }
                }
            }
        }

        // Convert set to list
        return new ArrayList<>(st);
    }
}

// Driver class
public class Main {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        int n = arr.length;
        Solution obj = new Solution();
        List<List<Integer>> res = obj.threeSum(arr, n);

        for (List<Integer> triplet : res) {
            for (int num : triplet) System.out.print(num + " ");
            System.out.println();
        }
    }
}



// Approach : Better
// Time Complexity : O(N^2 * log(no. of unique triplets))
// Space Complexity : O(2 * no. of the unique triplets) + O(N) 

import java.util.*;
// Class to solve 3-sum problem
class Solution {
    // Function to find triplets with sum zero
    public List<List<Integer>> threeSum(int[] arr, int n) {
        // Store unique triplets
        Set<List<Integer>> ans = new HashSet<>();

        // First loop for first element
        for (int i = 0; i < n; i++) {
            // Set to store elements seen in this iteration
            Set<Integer> hashset = new HashSet<>();

            // Second loop for second element
            for (int j = i + 1; j < n; j++) {
                // Calculate third element needed
                int third = -(arr[i] + arr[j]);

                // If third already in set, we found a triplet
                if (hashset.contains(third)) {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    Collections.sort(temp);
                    ans.add(temp);
                }

                // Add current element to set
                hashset.add(arr[j]);
            }
        }

        // Convert set to list
        return new ArrayList<>(ans);
    }
}

// Driver class
public class Main {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        int n = arr.length;
        Solution obj = new Solution();
        List<List<Integer>> res = obj.threeSum(arr, n);

        for (List<Integer> triplet : res) {
            for (int num : triplet) System.out.print(num + " ");
            System.out.println();
        }
    }
}



// Approach : Optimal
// Time Complexity : O(NlogN)+O(N^2)
// Space Complexity : O(no. of quadruplets)

import java.util.*;
// Class to solve 3-sum problem
class Solution {
    // Function to find triplets with sum zero
    public List<List<Integer>> threeSum(int[] arr, int n) {
        // Sort the array
        Arrays.sort(arr);
        // Store final result
        List<List<Integer>> ans = new ArrayList<>();

        // First loop for first element
        for (int i = 0; i < n; i++) {
            // Skip duplicates for first element
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            // Two pointers
            int left = i + 1, right = n - 1;

            // Find pairs for current arr[i]
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == 0) {
                    ans.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    left++;
                    right--;

                    // Skip duplicates for left
                    while (left < right && arr[left] == arr[left - 1]) left++;
                    // Skip duplicates for right
                    while (left < right && arr[right] == arr[right + 1]) right--;
                }
                else if (sum < 0) left++;
                else right--;
            }
        }
        return ans;
    }
}

// Driver class
public class Main {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        int n = arr.length;
        Solution obj = new Solution();
        List<List<Integer>> res = obj.threeSum(arr, n);

        for (List<Integer> triplet : res) {
            for (int num : triplet) System.out.print(num + " ");
            System.out.println();
        }
    }
}
