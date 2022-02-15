package com.coding.patterns.sorts;


/**
 * LeetCode Problem: https://leetcode.com/problems/wiggle-sort/
 */

// Time Complexity: O(N)
// Space Complexity: O(1)
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (((i % 2 != 0) && (nums[i] < nums[i - 1])) || ((i % 2 == 0) && (nums[i] > nums[i - 1]))) {
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
        }
    }
}
