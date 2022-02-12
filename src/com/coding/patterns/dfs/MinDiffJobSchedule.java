package com.coding.patterns.dfs;

import java.util.Arrays;

/**
 * LeetCode problem: https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
 */

// Time Complexity: O(N^2 * D), Space Complexity: O(N * D)
public class MinDiffJobSchedule {
    private int dfs(int[] jobDifficulty, int d, int[][] dp, int i) {
        int n = jobDifficulty.length;
        if (d == 1) {
            int max = 0;
            while (i < n) {
                max = Math.max(max, jobDifficulty[i++]);
            }
            return max;
        }
        if(dp[d][i] != -1) return dp[d][i];
        int max = 0;
        int result = Integer.MAX_VALUE;
        for (int idx = i; idx < n - d + 1; idx++) {
            max = Math.max(max, jobDifficulty[idx]);
            result = Math.min(result, max + dfs(jobDifficulty, d - 1, dp, idx + 1));
        }
        dp[d][i] = result;
        return result;
    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (d > jobDifficulty.length) return -1;
        int[][] dp = new int[d + 1][jobDifficulty.length];
        for (int[] rows: dp) Arrays.fill(rows, -1);
        return dfs(jobDifficulty, d, dp, 0);
    }
}
