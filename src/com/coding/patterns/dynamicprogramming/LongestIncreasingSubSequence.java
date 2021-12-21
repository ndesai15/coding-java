package com.coding.patterns.dynamicprogramming;

import java.util.Arrays;

/**
 * Pattern: Dynammic Programming
 * LeetCode: https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubSequence {
    public int lengthOfLIS(int[] nums) {
        int[] maxLength = new int[nums.length];
        Arrays.fill(maxLength,1);
        int maximumSoFar = 1;
        for (int j = 1; j < nums.length; j++) {
            int i = 0;
            while (i < j) {
                if (nums[i] < nums[j]) {
                    maxLength[j] = Math.max(1 + maxLength[i], maxLength[j]);
                }
                i++;
            }
            maximumSoFar = Math.max(maximumSoFar, maxLength[j]);
        }
        return maximumSoFar;
    }
}
