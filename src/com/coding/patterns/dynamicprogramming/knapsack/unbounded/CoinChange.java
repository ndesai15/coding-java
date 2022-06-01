package com.coding.patterns.dynamicprogramming.knapsack.unbounded;

import java.util.Arrays;

// Bottom Up approach
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        if (amount < 0 || coins.length == 0 || coins == null) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for(int i = 1; i <= amount; i++){
            for(int coin : coins){
                if(i - coin >= 0){
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return dp[amount] != amount + 1? dp[amount]: -1;
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2,5}, 11));
    }
}
