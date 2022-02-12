package com.coding.patterns.slidingWindow;

/**
 * LeetCode Problem: https://leetcode.com/problems/minimum-size-subarray-sum/
 */

// Time Complexity: O(N)
// Space Complexity: O(1)
public class MinSizeSubArraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE, windowStart = 0, runningSum = 0;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            int rightVal = nums[windowEnd];
            runningSum += rightVal;
            while(runningSum >= target) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                runningSum -= nums[windowStart++];
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
