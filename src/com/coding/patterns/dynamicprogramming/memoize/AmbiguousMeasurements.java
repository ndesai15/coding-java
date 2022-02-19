package com.coding.patterns.dynamicprogramming.memoize;

import java.util.HashMap;


// Time Complexity: O(low * high * n) - Where n is the # of measuring cup
// Space Complexity: O(low * high)
public class AmbiguousMeasurements {
    private boolean canMeasureInRange(HashMap<String, Boolean> cache, int[][] cups, int low, int high) {
        if (cache.containsKey(String.valueOf(low) + ":" + String.valueOf(high))) {
            return cache.get(String.valueOf(low) + ":" + String.valueOf(high));
        }
        if (low < 0 && high < 0) return false;
        boolean temp = false;
        for (int[] cup: cups) {
            if(low <= cup[0] && high >= cup[1]) {
                return true;
            }
            temp = canMeasureInRange(cache, cups, low - cup[0], high - cup[1]);
            if (temp) break;
        }
        cache.put(String.valueOf(low) + ":" + String.valueOf(high), temp);
        return temp;
    }

    public boolean ambiguousMeasurements(int[][] measuringCups, int low, int high) {
        HashMap<String, Boolean> cache = new HashMap<>();
        return canMeasureInRange(cache, measuringCups, low, high);
    }
}
