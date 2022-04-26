package com.coding.patterns.strings;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * LeetCode Problem: https://leetcode.com/problems/simplify-path/
 */
// Time Complexity: O(N)
// Space Complexity: O(N)

public class SimplifyPath {
    private static boolean isImportantToken(String str) {
        return str.length() > 0 && !str.equals(".");
    }
    public static String shortenPath(String path) {
        boolean startsWithPath = path.charAt(0) == '/';
        String[] tokens = path.split("/");
        List<String> tokensList = Arrays.asList(tokens);
        List<String> filteredTokens = tokensList.stream()
                .filter(token -> isImportantToken(token)).collect(Collectors.toList());
        Stack<String> stack = new Stack<String>();
        if (startsWithPath) stack.push("");
        for (String token: filteredTokens) {
            if (token.equals("..")) {
                if (stack.isEmpty() || stack.peek().equals("..")) {
                    stack.push(token);
                } else if(!stack.peek().equals("")) {
                    stack.pop();
                }
            }
            else {
                stack.push(token);
            }
        }
        return stack.size() == 1 && stack.peek().equals("") ? "/" : String.join("/", stack);
    }
}
