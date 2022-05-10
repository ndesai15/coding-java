package com.coding.patterns.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        Map<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put(')','(');
        closeToOpen.put(']','[');
        closeToOpen.put('}','{');

        for (char c: s.toCharArray()) {
            if (closeToOpen.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == closeToOpen.get(c)) {
                    stack.pop();
                }
                else return false;
            }
            else {
                stack.push(c);
            }
        }

        return  stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}{"));
    }
}
