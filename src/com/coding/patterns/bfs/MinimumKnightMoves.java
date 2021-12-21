package com.coding.patterns.bfs;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumKnightMoves {
    public static int moves(int x, int y) {
        HashSet<Pair> visited = new HashSet<>();
        visited.add(new Pair(0, 0));
        int move = 0;
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(0,0));
        int[] dir_row = {-2,-2,-1,1,2,2,1,-1};
        int[] dir_col = {-1,1,2,2,1,-1,-2,-2};
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Pair p = queue.remove();
                if (p.getKey().equals(x) && p.getValue().equals(y)) {
                    return move;
                }
                for (int j = 0; j < dir_col.length;j++) {
                    if (!visited.contains(new Pair(p.getKey().getV + dir_row[j], dir_col[j])))
                }
            }
        }
    }
}
