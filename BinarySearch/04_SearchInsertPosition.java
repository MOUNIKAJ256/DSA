// Problem : Search Insert Position
// Platform : Striver A2Z 
// Approach : Brute force
// Time Complexity : O(logn)
// Space Complexity : O(1)

import java.util.*;

public class BinarySearchInsert {
    // Function to find the insert position of x in sorted array
    public int searchInsert(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int ans = n; // Default to end if x is greater than all elements

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= x) {
                // Potential answer found, try to go left
                ans = mid;
                high = mid - 1;
            } else {
                // Go right
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7};
        int x = 6;

        BinarySearchInsert obj = new BinarySearchInsert();
        int index = obj.searchInsert(arr, x);

        System.out.println("The index is: " + index);
    }
}
