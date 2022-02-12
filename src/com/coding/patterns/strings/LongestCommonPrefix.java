package com.coding.patterns.strings;

/**
 * LeetCode problem: https://leetcode.com/problems/longest-common-prefix/
 */
// Time Complexity: O(N * M)
public class LongestCommonPrefix {
    public static String commonPrefix(String[] strs) {
        String result = "";
        for (int i = 0; i < strs[0].length(); i++) {
            for (String str: strs) {
                if ((i == str.length()) || (str.charAt(i) != strs[0].charAt(i))) {
                    return result;
                }
            }
            result += strs[0].charAt(i);
        }
        return result;
    }
}
