package com.coding.patterns.designs;

import java.util.*;

/**
 * LeetCode Problem: https://leetcode.com/problems/insert-delete-getrandom-o1/
 */
// Time Complexity: O(1)
public class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    public RandomizedSet() {
        map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
    }

    public boolean insert(int val) {
        boolean result = !map.containsKey(val);
        if (result) {
            map.put(val, list.size());
            list.add(val);
        }
        return result;
    }

    public boolean remove(int val) {
        boolean result = map.containsKey(val);
        if (result) {
            int idx = map.get(val);
            int lastVal = list.get(list.size() - 1);
            list.set(idx, lastVal);
            list.remove(list.size() - 1);
            map.replace(lastVal, idx);
            map.remove(val);
        }
        return result;
    }

    public int getRandom() {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}
