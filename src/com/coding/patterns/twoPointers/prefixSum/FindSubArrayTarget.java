package com.coding.patterns.twoPointers.prefixSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindSubArrayTarget {
    public static List<Integer> subArraySum(List<Integer> list, int target) {
        List<Integer> result = new ArrayList<>();
        int currentSum = 0;
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        for (int i = 0; i< list.size(); i++) {
            currentSum += list.get(i);
            int diff = currentSum - target;
            if (prefixSum.containsKey(diff)) {
                result.add(prefixSum.get(diff));
                result.add(i+1);
                return result;
            }
            prefixSum.put(diff, prefixSum.getOrDefault(diff, 0 ) + 1);
        }
        return null;
    }
}
