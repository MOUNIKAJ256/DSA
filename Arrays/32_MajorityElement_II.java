// Problem : Majority Elements(&gt;N/3 times) | Find the elements that appears more than N/3 times in the array
// Platform : Striver A2Z 
// Approach : Brute Force
// Time Complexity : O(n ^ 2)
// Space Complexity : O(1)

import java.util.*;
public class Solution {
    // Function to find majority elements in an array
    public List<Integer> majorityElementTwo(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // Check if nums[i] is not already part of the result
            if (result.size() == 0 || result.get(0) != nums[i] && (result.size() < 2 || result.get(1) != nums[i])) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (nums[j] == nums[i]) {
                        count++;
                    }
                }
                if (count > n / 3) {
                    result.add(nums[i]);
                }
            }

            if (result.size() == 2) {
                break;
            }
        }

        return result;
    }

    // Main method
    public static void main(String[] args) {
        int[] arr = {11, 33, 33, 11, 33, 11};

        Solution sol = new Solution();
        List<Integer> ans = sol.majorityElementTwo(arr);

        System.out.print("The majority elements are: ");
        for (int it : ans) {
            System.out.print(it + " ");
        }
        System.out.println();
    }
}



// Approach : Better
// Time Complexity : O(n * logn)
// Space Complexity : O(n)

import java.util.*;
class Solution {
    // Function to find majority elements in an array
    public List<Integer> majorityElementTwo(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> mpp = new HashMap<>();
        int mini = n / 3 + 1;

        for (int i = 0; i < n; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);

            // Add to result only when the count just reaches mini
            if (mpp.get(nums[i]) == mini) {
                result.add(nums[i]);
            }

            if (result.size() == 2) break;
        }

        return result;
    }
}

// Separate main class
public class Main {
    public static void main(String[] args) {
        int[] arr = {11, 33, 33, 11, 33, 11};

        Solution sol = new Solution();
        List<Integer> ans = sol.majorityElementTwo(arr);

        System.out.print("The majority elements are: ");
        for (int it : ans) {
            System.out.print(it + " ");
        }
        System.out.println();
    }
}



// Approach : Optimal
// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.*;
class Solution {
    // Function to find majority elements in an array
    public List<Integer> majorityElementTwo(int[] nums) {
        int n = nums.length;
        int cnt1 = 0, cnt2 = 0;
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && el2 != nums[i]) {
                cnt1 = 1;
                el1 = nums[i]; 
            } else if (cnt2 == 0 && el1 != nums[i]) {
                cnt2 = 1;
                el2 = nums[i]; 
            } else if (nums[i] == el1) {
                cnt1++;
            } else if (nums[i] == el2) {
                cnt2++; 
            } else {
                cnt1--; 
                cnt2--;
            }
        }

        cnt1 = 0; cnt2 = 0; 
        for (int i = 0; i < n; i++) {
            if (nums[i] == el1) cnt1++; 
            if (nums[i] == el2) cnt2++;
        }

        int mini = n / 3 + 1;
        List<Integer> result = new ArrayList<>(); 
        if (cnt1 >= mini) result.add(el1);
        if (cnt2 >= mini && el1 != el2) result.add(el2);

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] arr = {11, 33, 33, 11, 33, 11};

        Solution sol = new Solution();
        List<Integer> ans = sol.majorityElementTwo(arr);

        System.out.print("The majority elements are: ");
        for (int it : ans) {
            System.out.print(it + " ");
        }
        System.out.println();
    }
}
