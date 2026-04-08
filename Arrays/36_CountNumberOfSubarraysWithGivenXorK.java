// Problem : Count the number of subarrays with given xor K
// Platform : Striver A2Z 
// Approach : Brute Force
// Time Complexity : O(n ^ 2)
// Space Complexity : O(1)

import java.util.*;
class Solution {
    // Function to count subarrays with XOR equal to B
    public int countSubarraysXOR(int[] A, int B) {
        // Initialize count of valid subarrays
        int count = 0;
        // Traverse all starting points
        for (int i = 0; i < A.length; i++) {
            // Maintain xor of current subarray
            int xorVal = 0;
            // Extend subarray till end
            for (int j = i; j < A.length; j++) {
                // Update xor
                xorVal ^= A[j];
                // If xor equals B, increment count
                if (xorVal == B) {
                    count++;
                }
            }
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        // Input array
        int[] A = {4, 2, 2, 6, 4};
        // Target xor
        int B = 6;

        Solution sol = new Solution();
        System.out.println(sol.countSubarraysXOR(A, B));
    }
}



// Approach : Optimal
// Time Complexity : O(n)
// Space Complexity : O(n)

import java.util.*;
class Solution {
    // Function to count subarrays with given XOR
    public int countSubarrays(int[] A, int k) {
        // Store frequency of prefix XORs
        Map<Integer, Integer> freq = new HashMap<>();
        // Initialize with prefix XOR 0
        freq.put(0, 1);

        // Current prefix XOR
        int prefixXor = 0;
        // Answer count
        int count = 0;

        // Traverse array
        for (int num : A) {
            // Update prefix XOR
            prefixXor ^= num;

            // Compute required XOR
            int target = prefixXor ^ k;

            // If target exists in map, add its frequency
            if (freq.containsKey(target)) {
                count += freq.get(target);
            }

            // Store current prefix XOR in map
            freq.put(prefixXor, freq.getOrDefault(prefixXor, 0) + 1);
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] A = {4, 2, 2, 6, 4};
        int k = 6;
        Solution sol = new Solution();
        System.out.println(sol.countSubarrays(A, k));
    }
}

