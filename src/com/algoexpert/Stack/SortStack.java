package com.algoexpert.Stack;

import java.util.ArrayList;

/**
 * AlgoExpert Interview: https://www.algoexpert.io/questions/Sort%20Stack
 */

// Time Complexity: O(N^2)
// Space Complexity: O(N)
public class SortStack {
    private void insert(int value, ArrayList<Integer> stack) {
        if (stack.size() == 0 || stack.get(stack.size() - 1) <= value) {
            stack.add(value);
            return;
        }
        int top = stack.remove(stack.size() - 1);
        insert(value, stack);
        stack.add(top);
    }

    public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        if (stack.size() == 0) {
            return stack;
        }
        int top = stack.remove(stack.size() - 1);
        sortStack(stack);
        insert(top, stack);
        return stack;
    }
}
