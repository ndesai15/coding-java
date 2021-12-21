package com.coding.patterns.dynamicprogramming;

public class StringInterleave {
    public static boolean isInterleave(String s1, String s2, String s3) {
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        dp[0][0] = true;
        // If one string is empty, fill out 1st row
        for (int j = 1; j <= s2.length(); j++) {
            if (s2.charAt(j-1) == s3.charAt(j-1)) {
                dp[0][j] = dp[0][j-1];
            }
            else {
                dp[0][j] = false;
            }
        }

        // Fill out 1st column
        for (int i = 1; i <= s1.length(); i++) {
            if (s1.charAt(i-1) == s3.charAt(i-1)) {
                dp[i][0] = dp[i-1][0];
            }
            else {
                dp[i][0] = false;
            }
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                // If Both strings have same character as character in S3, take OR operation
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1) &&
                        s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
                // If S1 String has same character as character in S3
                else if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i - 1][j];
                }
                // If S2 String has same character as character in S3
                else if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j - 1];
                }
                else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
