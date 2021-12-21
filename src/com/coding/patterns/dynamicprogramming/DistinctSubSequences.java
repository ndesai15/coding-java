package com.coding.patterns.dynamicprogramming;

/**
 * Pattern : Bottom - Up DP Table
 * LeetCode: 115 # Distinct Subsequences
 */
public class DistinctSubSequences {
    public static int numDistinct(String s, String t) {
        // Pattern : Bottom - Up Dynamic Programming Approach

        // Initialize dp table
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        // Initialize the last column
        for (int i = 0; i <= s.length(); i++) {
            dp[i][t.length()] = 1;
        }

        // Initialize the last row
        for (int j = 0; j < t.length(); j++) {
            dp[s.length()][j] = 0;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = t.length() - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];

                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] += dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit","rabbit"));
    }
}
