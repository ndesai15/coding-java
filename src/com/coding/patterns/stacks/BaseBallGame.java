package com.coding.patterns.stacks;

import java.util.Stack;

/**
 * LeetCode Problems: https://leetcode.com/problems/baseball-game/
 */

// Time Complexity: O(N)
// Space Complexity: O(N)
public class BaseBallGame {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<Integer>();

        for (String op: ops) {
            if (op.equals("+")) {
                int firstElement = stack.pop();
                int secondElement = stack.pop();
                int sum = firstElement + secondElement;
                stack.push(secondElement);
                stack.push(firstElement);
                stack.push(sum);
            }
            else if(op.equals("D")) {
                stack.push(2  * stack.peek());
            }
            else if (op.equals("C")) {
                stack.pop();
            }
            else {
                stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
