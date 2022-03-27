package com.coding.patterns.designs;

import java.util.*;

public class RandomizedCollection {
    Map<Integer, Set<Integer>> map;
    List<Integer> list;
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, new HashSet<>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return map.get(val).size() == 1;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        Set<Integer> idx = map.get(val);
        int tempIDx = idx.size() - 1;
        idx.remove(tempIDx);
        int lastVal = list.get(list.size() - 1);
        list.set(tempIDx, lastVal);
        map.get(lastVal).add(tempIDx);
        map.get(lastVal).remove(list.size() - 1);
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}
