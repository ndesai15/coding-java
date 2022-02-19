package com.coding.patterns.stacks;

import java.util.Stack;

/**
 * LeetCode Problem: https://leetcode.com/problems/remove-k-digits/
 */

// Time Complexity: O(N)
// Space Complexity: O(N)
public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for(char ch: num.toCharArray()) {
            while ((k > 0) && (!stack.isEmpty() && stack.peek() > ch)) {
                k--;
                stack.pop();
            }
            stack.push(ch);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0? "0" : sb.toString();
    }
}
