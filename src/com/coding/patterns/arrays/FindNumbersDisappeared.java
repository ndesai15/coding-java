package com.coding.patterns.arrays;


import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(N)
// Space Complexity: O(1)
public class FindNumbersDisappeared {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int n: nums){
            int i = Math.abs(n) - 1;
            nums[i] = -1 * Math.abs(nums[i]);
        }

        // Response array that would contain the missing numbers
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
