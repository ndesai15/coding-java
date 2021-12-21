package com.coding.patterns.dynamicprogramming;

/**
 * Pattern: Longest Common Subsequence
 * Leetcode problem: https://leetcode.com/problems/palindromic-substrings/
 */
public class PalindromeSubStrings {
    public static int countSubStrings(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            // Odd Length
            int left = i, right = i;
            while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                result++;
                left -=1;
                right +=1;
            }
            // Even Length
            left = i;
            right = i + 1;
            while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                result++;
                left -=1;
                right +=1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countSubStrings("abc"));
        System.out.println(countSubStrings("aaa"));
    }
}
