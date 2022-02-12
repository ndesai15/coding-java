package com.algoexpert.Recursion;

import java.util.HashMap;

/**
 * AlgoExpert Problem:https://www.algoexpert.io/questions/Number%20Of%20Binary%20Tree%20Topologies
 */

// Time Complexity: O(N^2)
// Space Complexity: O(N)
public class NumberOfTreeTopology {

    private static int helper(int n, HashMap<Integer, Integer> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int numberOfTreeTopology = 0;
        for (int leftTreeSize = 0; leftTreeSize < n; leftTreeSize++) {
            int rightTreeSize = n - 1 - leftTreeSize;
            int numberOfLeftTreeTopology = helper(leftTreeSize, cache);
            int numberOfRightTreeTopology = helper(rightTreeSize, cache);
            numberOfTreeTopology += numberOfLeftTreeTopology * numberOfRightTreeTopology;
        }
        cache.put(n, numberOfTreeTopology);
        return numberOfTreeTopology;
    }
    public static int totalBinaryTreeTopology(int n) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 1);
        return helper(n, cache);
    }
}
