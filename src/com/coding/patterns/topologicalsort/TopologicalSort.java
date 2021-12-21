package com.coding.patterns.topologicalsort;

import java.util.*;

public class TopologicalSort {
    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> topologicalSorted = new ArrayList<>();
        if (vertices <= 0) {
            return topologicalSorted;
        }

        // Step 1 - Initialize the graph
        HashMap<Integer, Integer> inDegree = new HashMap<>(); // vertex -> Count(in-degree to vertex)
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); // adjacency list graph
        for (int i = 0; i < vertices; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        // Step 2 - Build the graph
        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            graph.get(parent).add(child); // put child to parent's list
            inDegree.put(child, inDegree.get(child) + 1); // increment child's inDegree
        }

        // Step 3: Find all the sources i.e., all the vertices with 0 in-degree
        Queue<Integer> sources = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry: inDegree.entrySet()) {
            if(entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        // Step 4. For each source, add it to the sortedOrder and subtract one from all of its children's in-degrees
        // if a child's in-degree becomes zero, add it to the sources queue
        while (!sources.isEmpty()) {
            int vertex = sources.remove();
            topologicalSorted.add(vertex);
            List<Integer> children = graph.get(vertex);
            for(int child: children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if(inDegree.get(child) == 0) {
                    sources.add(child);
                }
            }
        }

        // topological sort is not possible as the graph has a cycle
        if (topologicalSorted.size() != vertices)
            return new ArrayList<>();

        return topologicalSorted;
    }

    public static void main(String[] args) {
        List<Integer> result = sort(4,
                new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println(result);

        result = sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
                new int[] { 2, 1 }, new int[] { 3, 1 } });
        System.out.println(result);

        result = sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
                new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
        System.out.println(result);
    }
}
