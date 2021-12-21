package com.algorithms;


import java.util.*;

class Node {
    int id;
    int value;

    public Node(int id, int value) {
        this.id = id;
        this.value = value;
    }
}
public class DijkstraAlgorithm {
   public static void dijkstra(int[][] adjacencyList, int source) {
       Map<Integer, List<int[]>> graph = new HashMap();
       // number of vertices
       int v = adjacencyList.length;
       // array of visited nodes
       boolean[] visited = new boolean[v];
       Arrays.fill(visited, false);
       // distance array that will have shortest distance to all the nodes
       int[] distance = new int[v];
       Arrays.fill(distance, Integer.MAX_VALUE);
       distance[0] = 0;
       PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.value - b.value);
       pq.add(new Node(source, 0));

       System.out.println("HashMap");
       while (!pq.isEmpty()) {
           Node current = pq.poll();
           visited[current.id] = true;
           for (int i = 0; i < adjacencyList[current.id].length; i++) {
               if (visited[adjacencyList[current.id][i]]) {
                   continue;
               }
               visited[adjacencyList[current.id][i]] = true;
               int newDist = distance[current.id] + adjacencyList[current.id][i];
               if (newDist < adjacencyList[current.id][i]) {
                   distance[i] = newDist;
                   pq.offer(new Node(i, distance[i]));
               }
           }
       }

       // Print
       for(int i = 0; i < v; i++) {
           System.out.println(i + ": " + distance[i]);
       }
   }

    public static void main(String[] args) {
        int[][] arr = { {2,1,1},{2,3,1},{3,4,1} };
        dijkstra(arr, 2);
    }
}
