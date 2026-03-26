// Problem : find next lexicographically greater permutation
// Platform : Strivers A2Z 
// Approach : Brute Force
// Time Complexity : O(n! * n)
// Space Complexity : O(n!)

import java.util.*;
class Solution {
    // Function to find the next permutation
    public List<Integer> nextPermutation(int[] nums) {
        // List to hold all permutations
        List<List<Integer>> all = new ArrayList<>();

        // Sort the input to start from the smallest
        Arrays.sort(nums);

        // Generate all permutations
        permute(nums, 0, all);

        // Convert array to list for comparison
        List<Integer> current = new ArrayList<>();
        for (int num : nums)
            current.add(num);

        // Find and return the next permutation
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).equals(current)) {
                if (i == all.size() - 1)
                    return all.get(0);
                return all.get(i + 1);
            }
        }
        return current;
    }

    // Backtracking permutation generator
    private void permute(int[] nums, int start, List<List<Integer>> all) {
        if (start == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) temp.add(num);
            all.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            permute(nums, start + 1, all);
            swap(nums, i, start);
        }
    }

    // Swap helper
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3};

        List<Integer> result = sol.nextPermutation(nums);
        for (int x : result)
            System.out.print(x + " ");
        System.out.println();
    }
}



// Approach : Optimal
// Time Complexity : O(n)
// Space Complexity : O(1)



import java.util.*;

// Solution class
class Solution {
    // Function to find next permutation
    public void nextPermutation(int[] nums) {
        // Set index to -1
        int index = -1;

        // Find the first decreasing element from end
        for (int i = nums.length - 2; i >= 0; i--) {
            // If smaller found
            if (nums[i] < nums[i + 1]) {
                // Store index
                index = i;
                break;
            }
        }

        // If no index found
        if (index == -1) {
            // Reverse the entire array
            reverse(nums, 0, nums.length - 1);
            return;
        }

        // Find just larger element
        for (int i = nums.length - 1; i > index; i--) {
            // Swap them
            if (nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }
        // Reverse part after index
        reverse(nums, index + 1, nums.length - 1);
    }

    // Helper to reverse array
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    // Helper to swap
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Input array
        int[] nums = {1, 2, 3};

        // Create object
        Solution sol = new Solution();

        // Call function
        sol.nextPermutation(nums);

        // Print result
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
