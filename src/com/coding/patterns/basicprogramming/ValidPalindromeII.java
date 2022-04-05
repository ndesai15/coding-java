package com.coding.patterns.basicprogramming;


/**
 * LeetCode Problem: https://leetcode.com/problems/valid-palindrome-ii/
 */
// Time Complexity: O(2 *N)
// Space Complexity: O(1)
public class ValidPalindromeII {
    private static boolean checkPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
    public static boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return (checkPalindrome(s, left, right - 1) || checkPalindrome(s, left + 1, right));
            }
        }
        return true;
    }
}
