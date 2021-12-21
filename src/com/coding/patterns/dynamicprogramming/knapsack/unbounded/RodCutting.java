package com.coding.patterns.dynamicprogramming.knapsack.unbounded;

public class RodCutting {
    public static int maxProfit(int[] len, int[] price, int N) {
        if (len == null || price == null || len.length != price.length) {
            return 0;
        }

        // Step 1 - Create Memoization table
        int[][] t = new int[len.length + 1][N +  1];

        // Step - 2 Initialization

        // Initialize 1st row
        for (int j = 0; j <= N; j++) {
            t[0][j] = 0;
        }

        // Initialize 1st column
        for (int i = 0; i <= len.length; i++) {
            t[i][0] = 0;
        }

        // Step - 3 Run Unbounded knapsack
        for (int i = 1; i <= len.length; i++) {
            for (int j = 1; j <= N; j++) {
                if (len[i-1] <= j) {
                    t[i][j] = Math.max(
                            t[i-1][j],
                            price[i-1] + t[i][j-len[i-1]]
                    );
                }
                else {
                    t[i][j] = t[i-1][j];
                }
            }
        }

        // Step - 4 return answer
        return t[len.length][N];
    }
}
