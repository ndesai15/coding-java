package com.coding.patterns.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode Problem: https://leetcode.com/problems/subsets-ii/
 */
public class SubsetsII {
    private static void dfs(int i, int[] nums, List<List<Integer>> subsets, ArrayList<Integer> path) {
        if (i == nums.length) {
            subsets.add(new ArrayList<>(path));
            return;
        }

        // Add all the subsets that include nums[i]
        path.add(nums[i]);
        dfs(i+1, nums, subsets, path);
        // backtrack
        path.remove(path.size() - 1);

        // Add all the subsets that don't include nums[i]
        while ((i + 1 < nums.length) && nums[i+1] == nums[i]) {
            i++;
        }
        dfs(i+1, nums, subsets, path);

    }

    public static List<List<Integer>> getAllSubsets(int[] nums) {
        // Sort the input array
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        dfs(0, nums, subsets, new ArrayList<>());
        return subsets;
    }
}
