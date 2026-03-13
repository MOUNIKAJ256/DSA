// Problem : Right rotate the array by one
// Platform : Strivers A2Z 
// Approach : Brute Force
// Time Complexity : O(n)
// Space Complexity : O(n)

// Class containing the solve method
class Solution {
    // Function to solve and shift array elements right by one position
    public static void solve(int[] arr, int n) {
      // Temporary array to store shifted elements
        int[] temp = new int[n];  
        // Shift elements to the left by one position
        for (int i = 1; i < n; i++) {
            temp[i] = arr[i - 1];
        }
        // last element moves to the first position
        temp[0] = arr[n - 1];  
        // Print the rotated array
        for (int i = 0; i < n; i++) {
            System.out.print(temp[i] + " ");
        }
        System.out.println();
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Size of the array
        int n = 5;  
        // Original array
        int[] arr = {1, 2, 3, 4, 5};  
        // Call the solve function from Solution class
        Solution.solve(arr, n); 
    }
}



// Approach : Optimal
// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public void rotateArrayByOne(int[] nums) {
        int n = nums.length;
        // Store the last element in a temporary variable
        int temp = nums[n - 1];
        // Shift elements to the left
        for (int i = n - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        // Place the last element at the front
        nums[0] = temp;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        solution.rotateArrayByOne(nums);
        // Output the rotated array
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
