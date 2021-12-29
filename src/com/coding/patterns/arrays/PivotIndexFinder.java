package com.coding.patterns.arrays;


/**
 * LeetCode Problem: https://leetcode.com/problems/find-pivot-index/
 */

// Time Complexity: O(N)
// Space Complexity: O(N)
public class PivotIndexFinder {
    public static int pivotIndex(int[] nums) {
        int total = 0;
        for (int n: nums) {
            total += n;
        }
        int leftSum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int rightSum = total - leftSum - nums[i];
            if (leftSum == rightSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
