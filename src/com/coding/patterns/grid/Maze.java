package com.coding.patterns.grid;

/**
 * Problem : https://leetcode.com/problems/the-maze/
 */
public class Maze {

    /*
         Time Complexity: O(MN)
         In worst case, it will do complete maze traverse

         Space Complexity: O(MN). visited array size
     */

    public boolean hasPath(int[][] maze, int[] source, int[] destination) {
        int[][] directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

        int numberOfRows = maze.length;
        int numberOfColumns = maze[0].length;

        boolean[][] visited = new boolean[numberOfRows][numberOfColumns];

        // DFS
        return dfs(maze, source, destination, visited, numberOfRows,numberOfColumns, directions);
    }

    // DFS
    private boolean dfs(int[][] maze, int[] s, int[] d, boolean[][] visited, int numberOfRows, int numberOfColumns,
                        int[][] directions) {
        if (s[0] == d[0] && s[1] == d[1]) {
            return true;
        }
        visited[s[0]][s[1]] = true;
        for(int[] dir: directions) {
            int x = s[0], y = s[1];
            // Roll until we hit the wall
            // wall = 1 & empty space = 0
            while (x + dir[0] < numberOfRows && x + dir[0] >= 0 && y + dir[1] < numberOfColumns &&
                    y + dir[1] >=0 && maze[x+dir[0]][y+dir[1]] != 1) {
                x += dir[0];
                y += dir[1];
            }
            if(!visited[x][y] && dfs(maze, new int[]{x, y}, d, visited, numberOfRows,
                    numberOfColumns, directions)) return true;
        }
        return false;
    }

}
