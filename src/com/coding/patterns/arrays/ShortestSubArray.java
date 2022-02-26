package com.coding.patterns.arrays;

/**
 * LeetCode Problem: https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 */
public class ShortestSubArray {
    // Time Complexity : O(N)
    // Space Complexity: O(1)
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length < 2) return 0;
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (isOutOfOrder(n, i, nums)) {
                minVal = Math.min(minVal, n);
                maxVal = Math.max(maxVal, n);
            }
        }
        if (minVal == Integer.MAX_VALUE) {
            return 0;
        }
        int subLeftIdx = 0;
        while (minVal >= nums[subLeftIdx]) {
            subLeftIdx++;
        }
        int subRightIdx = nums.length - 1;
        while (maxVal <= nums[subRightIdx]) {
            subRightIdx--;
        }
        return subRightIdx - subLeftIdx + 1;
    }

    private boolean isOutOfOrder(int n, int i, int[] array) {
        if (i == 0) {
            return n > array[i + 1];
        }
        if (i == array.length - 1) {
            return n < array[i - 1];
        }
        return n < array[i - 1] || n > array[i + 1];
    }
}
