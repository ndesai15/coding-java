package com.coding.patterns.dynamicprogramming;

/**
 * LeetCode : https://leetcode.com/problems/minimum-cost-for-tickets/
 */
public class MinimumCostForTickets {
    public int minCostTickets(int[] days, int[] costs) {
        // Create a cache to avoid repeated work
        int[] dp = new int[days.length];
        int[] durations = new int[]{1, 7, 30};
        return dfs(0, days, dp, durations, costs);
    }

    private int dfs(int index, int[] days, int[] dp, int[] durations, int[] costs) {
        // Time Complexity: O(38*N)
        if (index >= days.length) {
            return 0;
        }
        if (dp[index] != 0) {
            return dp[index];
        }
        int result = Integer.MAX_VALUE;
        int j = index;
        for (int day = 0; day < 3; day++) {
            while (j < days.length && days[j] < days[index] + durations[day]) {
                j++;
            }
            result = Math.min(result, costs[day] + dfs(j, days, dp, durations, costs));
        }
        dp[index] = result;
        return result;
    }
}
