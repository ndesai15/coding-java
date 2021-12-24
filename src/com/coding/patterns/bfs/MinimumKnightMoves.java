package com.coding.patterns.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * LeetCode Problem: https://leetcode.com/problems/minimum-knight-moves/
 */
class Position {
    public int x;
    public int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
/*
  1. Given Board is infinite in size.
  2. Problem asks for Shortest Path from (0,0) to (x,y)

  Based on above 2 factors, we will perform BFS to find shortest Path

  Time Complexity: O(N) , where N is number of moves
  Space Complexity: O(N) , where N is number of moves
*/
public class MinimumKnightMoves {

    public int minKnightMoves(int x, int y) {
        int absX = Math.abs(x);
        int absY = Math.abs(y);

        // Note: We can store Position to Set but in that case we will require to override equals method
        Set<String> visited = new HashSet<>();
        Queue<Position> queue = new LinkedList<>();
        Position source = new Position(0, 0) ;
        queue.add(source);
        visited.add("0,0");
        int[] delta_row = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] delta_col = {-1, 1, -2, 2, -2, 2, -1, 1};

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Position p = queue.remove();
                if (p.x == absX && p.y == absY) {
                    return steps;
                }
                else {
                    for (int k = 0; k < delta_row.length; k++) {
                        int px = p.x + delta_row[k];
                        int py = p.y + delta_col[k];
                        String s = px + ","+ py;
                        if (!visited.contains(s) && px >= -2 && py >= -2) {
                            queue.add(new Position(px, py));
                            visited.add(s);
                        }
                    }
                }
            }
            steps++;
        }
        return steps;
    }
}
