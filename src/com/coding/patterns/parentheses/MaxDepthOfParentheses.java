package com.coding.patterns.parentheses;

/**
 * https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
 */


// Time Complexity; O(N)
// Space Complexity: O(1)

public class MaxDepthOfParentheses {
    public int maxDepth(String s) {
        int maxDepth = 0, currentDepth = 0;

        for (char ch: s.toCharArray()) {
            if (ch != '(' && ch != ')') continue;
            if (ch == '(') {
                currentDepth += 1;

                if (currentDepth > maxDepth) {
                    maxDepth = currentDepth;
                }
            }
            else if (ch == ')') {
                currentDepth -=1;
            }
        }
        return maxDepth;
    }
}
