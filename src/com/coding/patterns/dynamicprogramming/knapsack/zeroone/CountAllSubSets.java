package com.coding.patterns.dynamicprogramming.knapsack.zeroone;

public class CountAllSubSets {
    public static int countSubSets(int[] num, int sum) {
        int n = num.length;
        int[][] dp = new int[n][sum + 1];

        // populate 0th column
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        // fill out the first row
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = (num[0] == j? 1: 0);
        }

        // apply the algorithm
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                // exclude the number
                dp[i][j] = dp[i-1][j];
                if (j >= num[i]) {
                    dp[i][j] += dp[i-1][j-num[i]];
                }
            }
        }
        return dp[n - 1][sum];
    }

    public static void main(String[] args) {
        int[] num = {1, 1, 2, 3};
        System.out.println(countSubSets(num, 4));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(countSubSets(num, 9));
        num = new int[]{0,0,0,0,0,0,0,0,1};
        System.out.println(countSubSets(num, 1));
    }
}
