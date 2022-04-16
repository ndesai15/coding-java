package com.coding.patterns.backtracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode Problem: https://leetcode.com/problems/combination-sum-ii/
 */

// Time Complexity: O(N * 2^N), Space Complexity: O(1)
public class CombinationSumII {
    private void dfs(int i, int[] candidates, int target, int sum, List<List<Integer>> result, List<Integer> path) {
        if (sum == target) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        if (i >= candidates.length || sum > target) {
            return;
        }
        path.add(candidates[i]);
        dfs(i + 1, candidates, target, sum + candidates[i], result, path);
        path.remove(path.size() - 1);

        while (i + 1 < candidates.length && candidates[i + 1] == candidates[i]) {
            i++;
        }
        dfs(i + 1, candidates, target, sum, result, path);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<Integer>();
        dfs(0, candidates, target, 0, result, path);
        return result;
    }
}
