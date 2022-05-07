package com.coding.patterns.stacks;

import java.util.*;;

/**
 * LeetCode Problems: https://leetcode.com/problems/generate-parentheses/
 */

public class GenerateParentheses {
    public static void main(String[] args) {

        final int n = 2;

        final GenerateParentheses instanse = new GenerateParentheses();

        System.out.println(instanse.generateParenthesis(n).toString());
    }

    final List<String> res = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0, "");

        return res;
    }

    public void backtrack(final int max, final int open, final int close, final String s) {
        if (open == close && open == max) {
            res.add(s);
            return;
        }

        if (open < max)
            backtrack(max, open + 1, close, s + "(");

        if (close < open)
            backtrack(max, open, close + 1, s + ")");
    }
}
