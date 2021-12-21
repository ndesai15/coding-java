package com.coding.patterns.dynamicprogramming.knapsack.zeroone;

public class Knapsack {
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        // base checks
        if (capacity <=0 || profits.length == 0 || weights.length == 0 || profits.length != weights.length) {
            return 0;
        }

        int n = profits.length;
        int[][] dp = new int[profits.length][capacity + 1];

        // populate the capacity=0 columns with '0' we have '0' profit
        for (int i=0; i < n; i++) {
            dp[i][0] = 0;
        }

        for(int j = 0; j <= capacity; j++){
            if (weights[0] < j) {
                dp[0][j] = 0;
            }
            if (weights[0] == j) {
                dp[0][j] = profits[0];
            }
        }

        // process all the sub-arrays for all the capacities
        for(int i = 1; i < n; i++) {
            for (int j = 1; j<= capacity; j++) {
                int profit1 = 0;
                int profit2 = 0;
                // Include case
                if(weights[i] <= j) {
                    profit1 = profits[i] + dp[i-1][j-weights[i]];
                }
                // exclude case
                profit2 = dp[i-1][j];
                // take the maximum
                dp[i][j] = Math.max(profit1, profit2);
            }
        }

        printSelectedElements(dp, weights, profits, capacity);
        return dp[n-1][capacity];
    }

    public void printSelectedElements(int[][] dp, int[] weights, int[] profits, int capacity) {
        System.out.println("Selected Weights:");
        int totalProfit = dp[profits.length - 1][capacity];
        for(int i = weights.length -1; i >0; i--){
            if (totalProfit != dp[i-1][capacity]) {
                System.out.print(" " + weights[i]);
                totalProfit -= profits[i];
                capacity -= weights[i];
            }
        }
        if (totalProfit != 0){
            System.out.println(" " + weights[0]);
        }
        System.out.println("");

    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
