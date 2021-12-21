package com.coding.patterns.dynamicprogramming.knapsack.unbounded;

import java.util.Arrays;

// Bottom Up approach
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        // Base case, for target 0, we just need 0 coin
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int c = 0; c < coins.length; c++) {
                if (i - coins[c] >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[c]]);
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2,5}, 11));
    }
}
