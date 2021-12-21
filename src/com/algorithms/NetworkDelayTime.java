package com.algorithms;
import java.util.*;

/**
 * Pattern : Dijkstra's algorithm
 * Problem: https://leetcode.com/problems/network-delay-time/
 */
public class NetworkDelayTime {
    public static int dijkstra(int[][] times, int n, int k) {
        // step - 1 Initialize graph
        HashMap<Integer, List<int[]>> graph = new HashMap<>();

        // step -2 build the graph
        for (int i = 0; i < times.length; i++) {
            int parent = times[i][0];
            int child = times[i][1];
            int weight = times[i][2];
            List<int[]> temp = graph.getOrDefault(parent, new ArrayList<>());
            temp.add(new int[] {child, weight});
            graph.put(parent,temp);
        }

        // step - 3 apply Dijkstra's algo
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);

        pq.add(new int[]{k,  0});
        int result = 0;
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int vertex = current[0];
            int distance = current[1];
            if (visited.contains(vertex)) {
                continue;
            }
            visited.add(vertex);
            result = distance;
            n--;
            for(int[] nodes: graph.getOrDefault(vertex, new ArrayList<>())) {
                int node = nodes[0];
                int cost = distance + nodes[1];
                if (!visited.contains(node)) {
                    pq.offer(new int[]{node, cost});
                }
            }
        }
        return n==0? result: -1;
    }

    public static void main(String[] args) {
        int[][] arr = {{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(dijkstra(arr, 4, 2)); // 2

        int[][] arr2 = {{1,2,1}};
        System.out.println(dijkstra(arr2, 2, 1));  // 1

    }
}
