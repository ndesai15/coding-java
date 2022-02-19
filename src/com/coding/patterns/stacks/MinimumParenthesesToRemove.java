package com.coding.patterns.stacks;

/**
 * LeetCode Problem: https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */

// Time Complexity: O(N)
// Space Complexity: O(N)
public class MinimumParenthesesToRemove {
    public static String minRemoveToMakeValid(String str) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for (char ch: str.toCharArray()) {
            if (ch == '(') {
                open++;
            }
            else if (ch == ')') {
                if (open == 0) continue;
                open--;
            }

            sb.append(ch);
        }

        StringBuilder result = new StringBuilder();
        for (int i = result.length() - 1; i >= 0; i++) {
            if (sb.charAt(i) == '(' && open-- > 0) continue;
            result.append(sb.charAt(i));
        }
        return result.reverse().toString();
    }
}
