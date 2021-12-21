package com.algorithms;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Algorithm: Dijkstra's Algorithm
 * Problem: https://leetcode.com/problems/swim-in-rising-water/
 * Time Complexity: O(N^2 * logN)
 */
class Triplet {
    int height;
    int row;
    int col;

    public Triplet(int height, int row, int col) {
        this.height = height;
        this.row = row;
        this.col = col;
    }
}
public class DijkstraAlgorithmVariation {
    public int swimInWater(int[][] grid) {
        // square grid
        int N = grid.length;
        Set<Pair> visited = new HashSet<Pair>();
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        // Min heap by height
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a,b) -> a.height - b.height);
        pq.offer(new Triplet(grid[0][0], 0 , 0));
        visited.add(new Pair(0, 0));
        int minTime = 0;

        while (!pq.isEmpty()) {
            Triplet triplets = pq.poll();
            if (triplets.row == N-1 && triplets.col == N-1) {
                minTime = triplets.height;
                break;
            }
            for (int[] direction : directions) {
                int neighR = triplets.row + direction[0];
                int neighC = triplets.col + direction[1];

                // check if neighR & neighC are out of bound or not
                if (neighR < 0 || neighC < 0 || neighR >= N || neighC >= N ||
                        visited.contains(new Pair(neighR, neighC))) {
                    continue;
                }

                visited.add(new Pair(neighR, neighC));
                pq.offer(new Triplet(Math.max(grid[neighR][neighC], triplets.height), neighR, neighC));
            }
        }
        return minTime;
    }
}
