package com.coding.patterns.stacks;

import java.util.Stack;

/**
 * LeetCode Problem: Decode String: https://leetcode.com/problems/decode-string/
 *
 * Time Complexity: O(maxK ^ countK * N) -> maxK is the maximum value of k, countK is the # of nested k values &
 * N is the maximum length of Encoded string. Ex., s = 20[a10[bc]], maxK is 20, countK is 2.
 *
 * Space Complexity: O(Sum(maxK ^ countK * N))
 */
public class DecodeString {
    private static String repeat (String s, int times) {
        if (times <= 0) return s;
        else return s + repeat(s, times - 1);
    }
    public static String decodeString(String str) {
        Stack<String> stack = new Stack<>();
        String strChecker = "0123456789";
        for (char ch: str.toCharArray()) {
            if (ch != ']') {
                stack.push(String.valueOf(ch));
            }
            else {
                String tempStr = "";
                while(stack.peek() != "[") {
                    tempStr = stack.pop() + tempStr;
                }
                String k = "";
                while (!stack.isEmpty() && strChecker.contains(stack.peek())) {
                    k = stack.pop() + k;
                }

                int tempVal = k == "" ? 0 : Integer.parseInt(k);
                stack.push(repeat(tempStr, tempVal));
            }
        }
        return String.join("", stack);
    }
}
