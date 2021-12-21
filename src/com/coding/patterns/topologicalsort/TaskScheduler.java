package com.coding.patterns.topologicalsort;

import java.util.*;

public class TaskScheduler {
    public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {
        List<Integer> topologicalSorted = new ArrayList<>();
        // Step 1 - Initialization
        HashMap<Integer, Integer> inDegrees = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < tasks; i++) {
            graph.put(i, new ArrayList<Integer>());
            inDegrees.put(i, 0);
        }

        // Step 2 - Build the graph & find all in-Degrees
        for(int prerequisite = 0; prerequisite < prerequisites.length; prerequisite++) {
            int parent = prerequisites[prerequisite][0];
            int child = prerequisites[prerequisite][1];
            graph.get(parent).add(child);
            inDegrees.put(child, inDegrees.get(child) + 1); // increment child's inDegrees count
        }

        // Step - 3 Find all the sources
        Queue<Integer> sources = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry: inDegrees.entrySet()) {
            if(entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        // Step 4 - Sort
        while (!sources.isEmpty()) {
            int vertex = sources.remove();
            topologicalSorted.add(vertex);
            for(int child: graph.get(vertex)) {
                inDegrees.put(child, inDegrees.get(child) - 1);
                if (inDegrees.get(child) == 0) {
                    sources.add(child);
                }
            }
        }

        if (topologicalSorted.size() != tasks) {
            return false;
        }

        return true;

    }
    public static void main(String[] args) {

        boolean result = isSchedulingPossible(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println("Tasks execution possible: " + result);

        result = isSchedulingPossible(3,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
        System.out.println("Tasks execution possible: " + result);

        result = isSchedulingPossible(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 },
                new int[] { 0, 4 }, new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println("Tasks execution possible: " + result);
    }
}
