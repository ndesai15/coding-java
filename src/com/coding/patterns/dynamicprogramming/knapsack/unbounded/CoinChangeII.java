package com.coding.patterns.dynamicprogramming.knapsack.unbounded;

public class CoinChangeII {
    public static int change(int amount, int[] coins) {
        if (amount < 0 || coins.length == 0 || coins == null) {
            return 0;
        }

        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        // fill out first column
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // fill out first row
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = 0;
        }

        // apply logic
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }

    public static void main(String[] args) {
        System.out.println(change(5, new int[]{1,2,5}));
        System.out.println(change(0, new int[]{7}));
    }
}
