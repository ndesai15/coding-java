package com.coding.patterns.dynamicprogramming;

import java.util.Arrays;

public class MinPaintCost {

    // Solution - 1
    public static int minCost (int[][] costs) {
        // Solve this using Top-Down Dynamic Pattern
        int n = costs.length;  // `n` - number of house
        // `n` - number of house
        // 3 - number of colors
        int[][] dp = new int[n][3];

        for (int j = 0; j < 3; j++) {
            dp[0][j] = costs[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j] = costs[i][j] + Math.min(dp[i-1][j+1], dp[i-1][j+2]);
                }
                if (j == 1) {
                    dp[i][j] = costs[i][j] + Math.min(dp[i-1][j-1], dp[i-1][j+1]);
                }
                if (j == 2) {
                    dp[i][j] = costs[i][j] + Math.min(dp[i-1][j-1], dp[i-1][j-2]);
                }
            }
        }

        Arrays.sort(dp[n-1]);

        return dp[n-1][0];
    }

    // Solution - 2
    public static int minCost2(int[][] costs) {
        // Solve this using Top-Down Dynamic Pattern
        int n = costs.length;
        int[] dp = new int[] {0,0,0};
        int dp0 = Integer.MAX_VALUE, dp1 = Integer.MAX_VALUE, dp2 = Integer.MAX_VALUE;
        for (int i = 0; i < costs.length; i++) {
            dp0 = costs[i][0] + Math.min(dp[1], dp[2]);
            dp1 = costs[i][1] + Math.min(dp[0], dp[2]);
            dp2 = costs[i][2] + Math.min(dp[0], dp[1]);
            dp = new int[]{dp0, dp1, dp2};
        }
        Arrays.sort(dp);
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(minCost(new int[][]{{17,2,17},{16,16,5},{14,3,19}}));  // 10
        System.out.println(minCost2(new int[][]{{17,2,17},{16,16,5},{14,3,19}}));  // 10
        System.out.println(minCost(new int[][]{{7,6,2}}));  // 2
        System.out.println(minCost2(new int[][]{{7,6,2}}));  // 2
    }
}
