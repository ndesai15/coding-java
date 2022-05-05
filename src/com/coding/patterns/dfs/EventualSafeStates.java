package com.coding.patterns.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * LeetCode Problem: https://leetcode.com/problems/find-eventual-safe-states/
 */

// Time Complexity: O(E +V), E is the # of edges & V is the # of nodes

/*
  Thought Process
  - To find a safe node, we need to check if there is any cycle exists or not
  - Find all the paths to safe nodes using DFS
  - Use HashMap to avoid recomputation
 */
public class EventualSafeStates {
    private static boolean dfs(int i, int[][] graph, HashMap<Integer, Boolean> safe) {
        if (safe.containsKey(i)) {
            return safe.get(i);
        }
        safe.put(i, false);

        for (int neigh: graph[i]) {
            if (!dfs(neigh, graph, safe)) {
                return false;
            }
        }
        safe.put(i, true);
        return true;
    }
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        int n = graph.length;
        HashMap<Integer, Boolean> safe = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, safe)) {
                result.add(i);
            }
        }
        return result;
    }
}
