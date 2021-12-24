package com.algorithms;

import java.util.*;


/**
 * LeetCode problem:
 */

/*
    Time Complexity : O(E * k)
    Space Complexity: O(N)
 */
public class CheapestFlightsWithinKStops {

    private static HashMap<Integer, Integer> copyHashMap(HashMap<Integer, Integer> originalMap) {
        HashMap<Integer, Integer> copy = new HashMap<>();
        for(Map.Entry<Integer, Integer> entry: originalMap.entrySet()) {
            copy.put(entry.getKey(), entry.getValue());
        }
        return copy;
    }

    public static int cheapestFlights(int n, int[][] flights, int src, int dst, int k) {
       HashMap<Integer, Integer> prices = new HashMap<>();
       for (int i = 0; i < n; i++) {
           prices.put(i, Integer.MAX_VALUE);
       }
       prices.put(src, 0);
       for (int i = 0; i <= k; i++) {
           HashMap<Integer, Integer> tmpPrices = copyHashMap(prices);

           for (int[] flight: flights) {
               if (prices.get(flight[0]) == Integer.MAX_VALUE) {
                   continue;
               }
               if (prices.get(flight[0]) + flight[2] < tmpPrices.get(flight[1])) {
                   tmpPrices.put(flight[1], prices.get(flight[0]) + flight[2]);
               }
           }
           prices = copyHashMap(tmpPrices);
       }
       return prices.get(dst) == Integer.MAX_VALUE ? -1 : prices.get(dst);
    }
}
