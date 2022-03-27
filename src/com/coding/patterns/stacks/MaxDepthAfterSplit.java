package com.coding.patterns.stacks;


/**
 * LeetCode Problem: https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
 */

/**
 * Explanation Of Solution: https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/discuss/358419/Confused-by-this-problem-I-was-too-%3A(-Here-is-how-it-became-crystal-clear...
 */

// Time Complexity; O(N)
// Space Complexity: O(1)
public class MaxDepthAfterSplit {
    public static int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] result = new int[n];

        int depth = 0;

        for (int i = 0; i < n; i++) {
            char ch = seq.charAt(i);
            boolean open = ch == '(';

            if (open) {
                depth += 1;
            }
            result[i] = depth % 2;

            if (!open) {
                depth -= 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxDepthAfterSplit("(())"));
    }
}
