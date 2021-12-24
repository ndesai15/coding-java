package com.algoexpert.BFS;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    public int r;
    public int c;

    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class MinimumPassOfMatrix {
    public int minimumPassesOfMatrix(int[][] matrix) {
        Queue<Pair> queue = new LinkedList<Pair>();
        int rows = matrix.length, cols = matrix[0].length;

        int totalNegatives = 0, pass = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] < 0) {
                    totalNegatives++;
                }
                if(matrix[i][j] > 0) {
                    queue.add(new Pair(i, j));
                }
            }
        }
        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        // Run BFS
        while (!queue.isEmpty() && totalNegatives > 0) {
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++) {
                Pair p = queue.remove();
                for(int j = 0; j < directions.length; j++) {
                    int dr = p.r + directions[j][0];
                    int dc = p.c + directions[j][1];
                    if (dr < 0 || dr == rows || dc < 0 || dc == cols || matrix[dr][dc] >= 0){
                        continue;
                    }
                    matrix[dr][dc] = (-1) * matrix[dr][dc];
                    queue.offer(new Pair(dr, dc));
                    totalNegatives--;
                }
            }
            pass++;
        }
        return totalNegatives == 0 ? pass : -1;
    }
}
