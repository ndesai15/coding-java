package com.algoexpert.Graph;

/**
 * AlgoExpert problem: https://www.algoexpert.io/questions/Cycle%20In%20Graph
 */

// Time Complexity: O(V + E), where V is number of vertices, E is number of edges
// Space Complexity: O(V)
public class CycleInGraph {
    private static int GREY = 1;
    private static int BLACK = 2;

    private static boolean dfs (int node, int[][] edges, int[] colors) {
        colors[node] = GREY;
        int[] neighbors = edges[node];
        for (int neighbor: neighbors) {
            if (colors[neighbor] == GREY) return true;
            if (colors[neighbor] == BLACK) continue;
            dfs(neighbor, edges, colors);
        }
        colors[node] = BLACK;
        return false;
    }

    public static boolean hasCycle(int[][] edges) {
        int vertices = edges.length;
        int[] colors = new int[vertices];
        // Run DFS on every vertex
        for (int i = 0; i < vertices; i++) {
            if (colors[i] != BLACK) {
                return dfs(i, edges, colors);
            }
        }
        return false;
    }
}
