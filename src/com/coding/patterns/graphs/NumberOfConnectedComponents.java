package com.coding.patterns.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Pattern: Depth First Search
 * Problem: https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 */
public class NumberOfConnectedComponents {
    public static int countComponents(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        boolean[] visited = new boolean[n];

        int count = 0;
        // Step - 1 Build the graph
        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<Integer>());
        }

        for (int i = 0; i < edges.length; i++){
            // Make Undirected Graph
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        // Step -2 run algorithm
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                count++;
                dfs(i, graph, visited);
            }
        }
        return count;

    }

    private static void dfs(int at, HashMap<Integer, List<Integer>> graph, boolean[] visited) {
        visited[at] = true;
        for(Integer child: graph.get(at)) {
            if(!visited[child]) {
                dfs(child, graph, visited);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(countComponents(5, new int[][] {{0,1},{1,2},{3,4}}));
        System.out.println(countComponents(5, new int[][] {{0,1},{1,2},{2,3},{3,4}}));
    }
}
