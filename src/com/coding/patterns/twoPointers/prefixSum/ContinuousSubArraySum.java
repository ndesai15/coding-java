package com.coding.patterns.twoPointers.prefixSum;

import java.util.HashMap;

/**
 * LeetCode Problem: https://leetcode.com/problems/continuous-subarray-sum/
 */

// Time Complexity: O(N)
// Space Complexity: O(N)
public class ContinuousSubArraySum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1);
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            int remainer = total % k;
            if (!remainderMap.containsKey(remainer)) {
                remainderMap.put(remainer, i);
            }
            else if (i - remainderMap.get(remainer) > 1) {
                return true;
            }
        }

        return false;
    }
}
