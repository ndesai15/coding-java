package com.coding.patterns.stacks;

import java.util.Stack;

/**
 * LeetCode Problem: https://leetcode.com/problems/design-browser-history/
 */
public class BrowserHistory {
    Stack<String> history;
    Stack<String> future;

    public BrowserHistory(String homePage) {
        history = new Stack<>();
        future = new Stack<>();
        // We will keep at least one entry in history stack to know where we are currently at
        history.push(homePage);
    }

    public void visit(String url) {
        history.push(url);
        future = new Stack<>();
    }

    public String back(int steps) {
        while (steps > 0 && history.size() > 1) {
            future.push(history.pop());
            steps--;
        }
        return history.peek();
    }

    public String forward(int steps) {
        while (steps > 0 && !future.isEmpty()) {
            history.push(future.pop());
            steps--;
        }
        return history.peek();
    }
}
