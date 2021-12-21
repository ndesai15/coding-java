package com.coding.patterns.bfs;


import java.util.*;

public class ShortestPath {
    private static List<Integer> getNeighbors(List<List<Integer>> graph, int node) {
        return graph.get(node);
    }
    public static int bfs(List<List<Integer>> graph, int root, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++) {
                int node = queue.poll();
                if (node == target) {
                    return level;
                }
                for (int n: getNeighbors(graph, node)) {
                    if (!visited.contains(n)) {
                        visited.add(n);
                        queue.offer(n);
                    }
                }
            }
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        List<Integer> temp1 = new ArrayList<>();
        temp1.add(1);
        temp1.add(2);

        List<Integer> temp2 = new ArrayList<>();
        temp2.add(0);
        temp2.add(2);
        temp2.add(3);

        List<Integer> temp3 = new ArrayList<>();
        temp3.add(0);
        temp3.add(1);

        List<Integer> temp4 = new ArrayList<>();
        temp4.add(1);

        List<List<Integer>> graph = new ArrayList<>();
        graph.add(temp1);
        graph.add(temp2);
        graph.add(temp3);
        graph.add(temp4);
        System.out.println(bfs(graph, 0, 3));

    }
}
