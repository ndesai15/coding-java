package com.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
    int city, cost;

    public Pair(int city, int cost) {
        this.city = city;
        this.cost = cost;
    }
}

class City {
    int city, distFromSrc, costFromSrc;

    City(int city, int distFromSrc, int costFromSrc) {
        this.city = city;
        this.costFromSrc = costFromSrc;
        this.distFromSrc = distFromSrc;
    }
}
public class FindCheapestFlights {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (flights.length == 0 || K < 0 || flights == null || n <= 0) {
            return -1;
        }

        // Dijkstra's implementation
        return dijkstraImplementation(n, flights, src, dst, K);
    }

    private static int dijkstraImplementation(int n, int[][] flights, int src, int dst, int K) {

        // Step - 1 initialize the graph
        List<List<Pair>> graph = new ArrayList<>();

        // Step - 2 build the graph
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] flight: flights) {
            graph.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }

        // Step - 3 Run Dijkstra's algorithm
        PriorityQueue<City> pq = new PriorityQueue<>((a,b) -> a.costFromSrc- b.costFromSrc);
        pq.offer(new City(src, 0, 0));

        while (!pq.isEmpty()) {
            City top = pq.poll();

            if (top.city == dst) {
                return top.costFromSrc;
            }
            if (top.distFromSrc > K) {
                continue;
            }
            List<Pair> neighbors = graph.get(top.city);
            for (Pair neighbor: neighbors) {
                pq.offer(new City(neighbor.city,top.distFromSrc + 1, top.costFromSrc + neighbor.cost));
            }
        }
        return -1;
    }
}
