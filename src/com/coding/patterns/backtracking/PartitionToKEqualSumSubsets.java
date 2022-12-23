package com.coding.patterns.backtracking;

import java.util.*;

/**
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
 */

// Time Complexity: O(k * 2 ^ N)

public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);

        int sum = 0;

        for (int n : nums)
            sum += n;

        if (sum % k != 0 || nums.length < k)
            return false;

        return backtrack(nums, k, new boolean[nums.length], 0, 0, sum / k);
    }

    static boolean backtrack(int[] nums, int k, boolean[] visited, int i, int cur, int target) {
        if (k == 0)
            return true;

        if (cur == target)
            return backtrack(nums, k - 1, visited, 0, 0, target);

        for (int j = i; j < nums.length; j++) {
            if (visited[j] || cur + nums[j] > target)
                continue;

            visited[j] = true;

            if (backtrack(nums, k, visited, j + 1, cur + nums[j], target))
                return true;

            visited[j] = false;
            
            if (cur + nums[j] == target)
                break;
        }

        return false;
    }
}
