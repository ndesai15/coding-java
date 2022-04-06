package com.coding.patterns.hashmap;

import java.util.HashMap;

/**
 * LeetCode Problem: https://leetcode.com/problems/maximum-number-of-balloons/
 */
public class MaxNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        int result = Integer.MAX_VALUE;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('b', 1);
        map.put('l', 2);
        map.put('a', 1);
        map.put('o', 2);
        map.put('n', 1);

        HashMap<Character, Integer> inputMap = new HashMap<Character, Integer>();

        for (char c: text.toCharArray()) {
            inputMap.put(c, inputMap.getOrDefault(c, 0) + 1);
        }

        for (char c: map.keySet()) {
            result = Math.min(result, inputMap.getOrDefault(c, 0) / map.get(c));
        }
        return result;
    }
}
