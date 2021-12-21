package com.coding.patterns.topologicalsort;

import java.util.*;

public class AllTaskSchedulingOrders {
    public static void topologySortedPaths(int tasks, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>();

        if (tasks <= 0)
            return;

        // Step 1- Initialize a graph
        HashMap<Integer, Integer> inDegree = new HashMap<>();  // Count of incoming edges for every vertex
        HashMap<Integer, List<Integer>> graph = new HashMap<>();  // adjacency list graph
        for(int i = 0; i < tasks; i++) {
            inDegree.put(i,0);
            graph.put(i, new ArrayList<Integer>());
        }

        // Step - 2 Build the graph
        for(int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0];
            int child = prerequisites[i][1];
            graph.get(parent).add(child);  //
            inDegree.put(child, inDegree.get(child) + 1);
        }

        // Step 3 - find all the sources with 0 in-Degrees
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry: inDegree.entrySet()) {
            if(entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }
        printAllTopologicalSorts(graph, inDegree, sources, sortedOrder);
    }

    private static void printAllTopologicalSorts(HashMap<Integer, List<Integer>> graph,
                                                 HashMap<Integer, Integer> inDegree, Queue<Integer> sources,
                                                 List<Integer> sortedOrder) {
        if(!sources.isEmpty()) {
            for(Integer vertex: sources){
                sortedOrder.add(vertex);
                Queue<Integer> sourcesForNextCall = cloneQueue(sources);
                sourcesForNextCall.remove(vertex);
                for(int child: graph.get(vertex)) {
                    inDegree.put(child, inDegree.get(child) - 1);
                    if(inDegree.get(child) == 0) {
                        sourcesForNextCall.add(child);  // save the new source for the next call
                    }
                }

                // recursive call to print other ordering from the remaining (and new) sources
                printAllTopologicalSorts(graph, inDegree, sourcesForNextCall, sortedOrder);
                // backtrack, remove the vertex from the sorted order and put all of its children back to consider
                // the next source instead of the current vertex
                sortedOrder.remove(vertex);
                for (int child : graph.get(vertex))
                    inDegree.put(child, inDegree.get(child) + 1);
            }
        }

        // if sortedOrder doesn't contain all tasks, either we've a cyclic dependency between tasks, or
        // we have not processed all the tasks in this recursive call
        if (sortedOrder.size() == inDegree.size())
            System.out.println(sortedOrder);
    }

    private static Queue<Integer> cloneQueue(Queue<Integer> queue) {
        Queue<Integer> clone = new LinkedList<>();
        for (Integer num: queue) {
            clone.add(num);
        }
        return clone;
    }

    public static void main(String[] args) {
        topologySortedPaths(4,
                new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println();
    }
}
