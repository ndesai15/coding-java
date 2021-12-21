package com.coding.patterns.datastructures.stacks;

import java.util.Stack;

/**
 * LeetCode problem: https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * Time Complexity : O(N)
 * Space Complexity: O(N)
 */
public class ReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        return calculate(stack, 0, tokens);
    }

    private static int calculate(Stack<Integer> stack, int i, String[] tokens) {
        if (i == tokens.length) {
            return stack.pop();
        }
        String current = tokens[i];
        if(current.equals("+") || current.equals("/") || current.equals("*") || current.equals("-") &&
        stack.size() >= 2) {
            int a = stack.pop();
            int b = stack.pop();
            int c = 0;
            switch (current) {
                case "+":
                    c = b + a;
                    break;
                case "-":
                    c = b - a;
                    break;
                case "*":
                    c = b * a;
                    break;
                case "/":
                    c = b / a;
                    break;
            }
            stack.push(c);
        }
        else {
            stack.push(Integer.valueOf(current));
        }
        return calculate(stack, i + 1, tokens);
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[] {"2","1","+","3","*"}));
        System.out.println(evalRPN(new String[] {"4","13","5","/","+"}));
        System.out.println(evalRPN(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
