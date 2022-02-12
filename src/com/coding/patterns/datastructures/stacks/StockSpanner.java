package com.coding.patterns.datastructures.stacks;

import java.util.Stack;

/**
 * LeetCode Problem: https://leetcode.com/problems/online-stock-span/
 */

// Time Complexity: O(N)
// Space Complexity: O(N)
public class StockSpanner {
    Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<int[]>(); // (price, span)
    }

    public int next(int price) {
        int span = 1;
        while(!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.peek()[1];
            stack.pop();
        }
        stack.push(new int[]{price, span});
        return span;
    }
}
