package com.coding.patterns.bfs;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    private static boolean isValid(int r, int c, int n) {
        return r < 0 || c < 0 || r == n || c == n;
    }

    private static void dfs(int r, int c, int[][] grid, HashSet<Pair<Integer, Integer>> visited, int n, int[][] dirs) {
        if (isValid(r,c, n) || grid[r][c] != 1 || visited.contains(new Pair(r, c))) {
            return;
        }
        visited.add(new Pair(r, c));
        for (int[] dir: dirs) {
            int newR = r + dir[0];
            int newC = c + dir[1];
            dfs(newR, newC, grid, visited, n, dirs);
        }
    }

    private static int bfs(HashSet<Pair<Integer, Integer>> visited,int[][] grid, int[][] dirs, int n) {
        int result = 0;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>(visited);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair pair = queue.remove();
                for (int[] dir: dirs) {
                    int newR = Integer.parseInt(pair.getKey().toString()) + dir[0];
                    int newC = Integer.parseInt(pair.getValue().toString()) + dir[1];

                    if (isValid(newR, newC, n) || visited.contains(new Pair(newR, newC))) {
                        continue;
                    }

                    if (grid[newR][newC] == 1) {
                        return result;
                    }
                    queue.add(new Pair(newR, newC));
                    visited.add(new Pair(newR, newC));
                }
            }
            result += 1;
        }
        return -1;
    }
    public static int shortestBridge(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        HashSet<Pair<Integer, Integer>> visited = new HashSet<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    dfs(r, c, grid, visited, rows, dirs);
                    return bfs(visited, grid, dirs, rows);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(shortestBridge(new int[][]{{0,1,0},{0,0,0},{0,0,1}}));
    }
}
