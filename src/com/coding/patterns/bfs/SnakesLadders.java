package com.coding.patterns.bfs;

import java.util.*;

/**
 * LeetCode Problem: https://leetcode.com/problems/snakes-and-ladders/
 */
class Pair {
    int square;
    int moves;

    public Pair(int square, int moves) {
        this.square = square;
        this.moves = moves;
    }
}

class PositionOnBoard {
    int r;
    int c;

    public PositionOnBoard(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

// Time Complexity: O(N^2)
public class SnakesLadders {
    private static PositionOnBoard positionOnBoard(int square, int n) {
        int r = (square - 1) / n;
        int c = (square - 1) % n;
        if (r % 2 != 0) {
            c = n - 1 - c;
        }
        return new PositionOnBoard(r, c);
    }
    public static int minSnakesLaddersMoves(int[][] board) {
        int n = board.length;
        // Run BFS
        Collections.reverse(Arrays.asList(board));

        Set<Integer> visited = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(1, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            int square = pair.square;
            int moves = pair.moves;
            // Let's roll dice
            for (int i = 1; i <= 6; i++) {
                int nextSquare = square + i;
                PositionOnBoard newPosition = positionOnBoard(nextSquare, n);
                if (board[newPosition.r][newPosition.c] != -1) {
                    nextSquare = board[newPosition.r][newPosition.c];
                }
                if (nextSquare == n * n) {
                    return moves + 1;
                }
                if (!visited.contains(nextSquare)) {
                    visited.add(nextSquare);
                    queue.add(new Pair(nextSquare, moves + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] board = {{-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}};
        System.out.println(minSnakesLaddersMoves(board));
    }
}
