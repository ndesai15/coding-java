package com.coding.patterns.dynamicprogramming.knapsack.unbounded;

// Bottom Up approach
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        if (amount < 0 || coins.length == 0 || coins == null) {
            return 0;
        }

        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        // fill out first column
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 0;
        }

        // fill out first row
        for (int j = 0; j <= amount; j++) {
            dp[0][j] = Integer.MAX_VALUE - 1;
        }

        for (int j = 1; j <= amount; j++) {
            if (j % coins[0] == 0) {
                dp[1][j] = j / coins[0];
            }
            else {
                dp[1][j] = Integer.MAX_VALUE - 1;
            }
        }

        // apply logic
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i-1] <= j) {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount] == Integer.MAX_VALUE - 1 ? -1: dp[n][amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2,5}, 11));
    }
}
