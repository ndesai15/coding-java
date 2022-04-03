package com.coding.patterns.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * LeetCode Problem: https://leetcode.com/problems/walls-and-gates/
 *
 * Pattern: Multi-Source BFS
 */

// Time Complexity: O(M*N)
// Space Complexity: O(M*N)
public class WallsAndGates {
    private static void addRoom(int r, int c, Queue<int[]> queue, Set<String> visited, int rows, int cols, int[][] rooms) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || visited.contains(r +","+ c) || rooms[r][c] == -1) {
            return;
        }
        queue.add(new int[]{r, c});
        visited.add(r + "," + c);
    }
    public static void wallsAndGates(int[][] rooms) {
        int rows = rooms.length, cols = rooms[0].length;
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (rooms[r][c] == 0) {
                    queue.add(new int[]{r, c});
                    visited.add(r + "," + c);
                }
            }
        }
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.remove();
                int r = current[0], c = current[1];
                rooms[r][c] = dist;
                addRoom(r + 1, c, queue, visited, rows, cols, rooms);
                addRoom(r - 1, c, queue, visited, rows, cols, rooms);
                addRoom(r, c + 1, queue, visited, rows, cols, rooms);
                addRoom(r, c - 1, queue, visited,  rows, cols, rooms);
            }
            dist += 1;
        }
    }
}
