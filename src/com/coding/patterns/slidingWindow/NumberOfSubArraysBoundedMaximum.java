package com.coding.patterns.slidingWindow;


/**
 * LeetCode Problem: https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/
 */
// Time Complexity: O(N)
// Space Complexity: O(1)
public class NumberOfSubArraysBoundedMaximum {
    public static int numSubArrayBoundedMaximum(int[] nums, int left, int right) {
        int result = 0, temp = 0, windowStart = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            int currentNum = nums[windowEnd];

            if (left <= currentNum && currentNum <= right) {
                result += windowEnd - windowStart + 1;
                temp =  windowEnd - windowStart + 1;
            }
            else if (currentNum < left) {
                result += temp;
            }
            else if (currentNum > right) {
                temp = 0;
                windowStart = windowEnd + 1;
            }
        }
        return result;
    }
}
