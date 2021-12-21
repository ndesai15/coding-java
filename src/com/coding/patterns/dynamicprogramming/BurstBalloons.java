package com.coding.patterns.dynamicprogramming;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        // Use Bottom-up approach
        int[][] dp = new int[nums.length][nums.length];

        for (int len = 1; len <= nums.length; len++) {
            for (int i = 0; i <= nums.length - len; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    /*
                        leftValue/rightValue is initially 1.
                        If there is element on left/right of k then left/right will take that value.
                     */
                    int leftValue = 1;
                    int rightValue = 1;
                    if (i != 0) {
                        leftValue = nums[i-1];
                    }
                    if (j != nums.length - 1) {
                        rightValue = nums[j+1];
                    }
                    // before is initially 0. If k is i then before will
                    // stay 0 otherwise it gets value dp[i][k-1]
                    // after is similarly 0. If k is j then after will stay 0
                    // otherwise will get value dp[k+1][j]
                    int before = 0;
                    int after = 0;
                    if (i != k) {
                        before = dp[i][k-1];
                    }
                    if (j != k) {
                        after = dp[k+1][j];
                    }
                    dp[i][j] = Math.max(leftValue * nums[k] * rightValue + before + after,
                            dp[i][j]);
                }
            }
        }

        return dp[0][nums.length - 1];
    }
}
