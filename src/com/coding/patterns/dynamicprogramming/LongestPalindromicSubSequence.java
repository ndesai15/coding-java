package com.coding.patterns.dynamicprogramming;

/**
 * Pattern: Top-Down DP Table
 */
public class LongestPalindromicSubSequence {
    public static int getMaxLengthOfPalindromicSubSequence(String str) {
        int[][] dp = new int[str.length()][str.length()];
        int len = str.length();

        for (int  i = len - 1; i >=0; i--) {
            dp[i][i] = 1;

            for (int j = i + 1; j < len; j++) {
                if(str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = 2 + dp[i+1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }

    public static void main(String[] args) {
        System.out.println(getMaxLengthOfPalindromicSubSequence("agbdba"));
    }
}
