package com.coding.patterns.dynamicprogramming.knapsack.zeroone;

public class EqualPartition {
    public static boolean canPartition(int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i ++) {
            sum += num[i];
        }

        // If 'sum' is a an odd Number, we can't have a subsets with equal numbers
        if (sum % 2 != 0) {
            return false;
        }

        sum = sum / 2;
        boolean[][] dp = new boolean[num.length + 1][sum+1];
        for (int row = 0; row < num.length; row++) {
            dp[row][0] = true;
        }
        for (int row = 1; row <= num.length; row++) {
            for (int col = 1; col <= sum; col++) {
                if (col - num[row - 1] >= 0) {
                    dp[row][col] = dp[row-1][col - num[row-1]] || dp[row-1][col];
                }
                else {
                    dp[row][col] = dp[row-1][col];
                }
            }
        }

        printSelectedElements(dp, num);
        return dp[num.length-1][sum];
    }

    public static void printSelectedElements(boolean[][] dp, int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i ++) {
            sum += num[i];
        }

        // If 'sum' is a an odd Number, we can't have a subsets with equal numbers
        if (sum % 2 != 0) {
            return;
        }
        sum = sum / 2;
        boolean finalResult = dp[num.length-1][sum];
        if(!finalResult) {
            return;
        }

        System.out.println("Jay bahuchar Mataji");
        for (int i = num.length; i > 0; i--) {
            if(finalResult == dp[i-1][sum]) {
                continue;
            }
            else {
                System.out.println(num[i-1]);
                sum = sum - num[i-1];
            }
        }
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4};
        System.out.println(canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(canPartition(num));
    }
}
