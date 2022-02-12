package com.algoexpert.Stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AlgoExpert Problem:https://www.algoexpert.io/questions/Min%20Max%20Stack%20Construction
 */
public class MinMaxStack {
    List<Integer> stack = new ArrayList<>();
    List<Map<String, Integer>> minMaxStack = new ArrayList<>();

    public void push(Integer number) {
        stack.add(number);
        Map<String, Integer> newHM = new HashMap<>();
        newHM.put("min", number);
        newHM.put("max", number);

        if (stack.size() > 0) {
            Map<String, Integer> lastEntry = minMaxStack.get(minMaxStack.size() - 1);
            newHM.put("min", Math.min(lastEntry.get("min"), number));
            newHM.put("max", Math.max(lastEntry.get("min"), number));
        }
        minMaxStack.add(newHM);
    }

    public Integer pop() {
        minMaxStack.remove(minMaxStack.size() - 1);
        return stack.remove(stack.size() - 1);
    }

    public Integer peek() {
        return stack.get(stack.size() - 1);
    }

    public Integer getMin() {
        return minMaxStack.get(minMaxStack.size() - 1).get("min");
    }

    public Integer getMax() {
        return minMaxStack.get(minMaxStack.size() - 1).get("max");
    }
}
