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

class Item {
    int vertex;
    int distance;

    public Item(int id, int value) {
        this.vertex = id;
        this.distance = value;
    }
}
public class DijkstraAlgorithm {
   public static void dijkstra(int[][] adjacencyList, int source) {
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
    public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
        int vertices = edges.length;
        int[] distances = new int[vertices];
        boolean[] visited = new boolean[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;
        PriorityQueue<Item> minHeap =
                new PriorityQueue<Item>((a, b) -> a.distance - b.distance);

        minHeap.add(new Item(start, 0));

        while (!minHeap.isEmpty()) {
            Item currentItem = minHeap.remove();
            int vertex = currentItem.vertex;
            int currentMinDistance = currentItem.distance;
            visited[vertex] = true;
            if (currentMinDistance > distances[vertex]) continue;
            for(int[] edge: edges[vertex]) {
                if (visited[edge[0]]) {
                    continue;
                }
                int newDist = distances[vertex] + edge[1];
                if (newDist < distances[edge[0]]) {
                    distances[edge[0]] = newDist;
                    minHeap.add(new Item(edge[0], newDist));
                }
            }
            for (int distance = 0; distance < distances.length; distance++) {
                if (distances[distance] == Integer.MAX_VALUE) {
                    distances[distance] = -1;
                }
            }
        }
        return distances;
    }
    public static void main(String[] args) {
        int[][] arr = { {2,1,1},{2,3,1},{3,4,1} };
        dijkstra(arr, 2);
    }
}
