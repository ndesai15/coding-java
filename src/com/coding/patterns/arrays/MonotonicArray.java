package com.coding.patterns.arrays;

/**
 * LeetCode Problem: https://leetcode.com/problems/monotonic-array/
 */

// Time Complexity: O(N)
// Space Complexity: O(1)
public class MonotonicArray {
    public static boolean isMonotic(int[] nums) {
        boolean isUp = true;
        boolean isDown = true;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                isDown = false;
            }
            if (nums[i] < nums[i - 1]) {
                isUp = false;
            }
        }
        return isDown || isUp;
    }
}
