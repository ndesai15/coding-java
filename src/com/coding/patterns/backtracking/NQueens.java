package com.coding.patterns.backtracking;

import java.util.*;

/**
 * LeetCode Problem: https://leetcode.com/problems/n-queens/
 *
 */

// Time Complexity: O(N!)
// Space Complexity: O(N^2)
public class NQueens {
    private static List<String> createBoard(char[][] board) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < board.length;i++) {
            String row = new String(board[i]);
            temp.add(row);
        }
        return temp;
    }
    private static void backTrack(int n, int r, char[][] board, Set<Integer> cols, Set<Integer> negDiag, Set<Integer> posDiag, List<List<String>> result) {
        if (r == n) {
            result.add(createBoard(board));
            return;
        }

        for (int c = 0; c < n; c++) {
            if (cols.contains(c) || negDiag.contains(r - c) || posDiag.contains(r + c)) {
                continue;
            }
            cols.add(c);
            negDiag.add(r - c);
            posDiag.add(r + c);
            board[r][c] = 'Q';

            // Go to next row
            backTrack(n, r + 1, board, cols, negDiag, posDiag, result);

            cols.remove(c);
            negDiag.remove(r - c);
            posDiag.remove(r + c);
            board[r][c] = '.';
        }
    }
    public static List<List<String>> solveNQueens(int n) {
        Set<Integer> cols = new HashSet<>();
        Set<Integer> negDiag = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>();

        // Keep Track of Current Board
        char[][] board = new char[n][n];
        for(char[] row: board) {
            Arrays.fill(row, '.');
        }
        List<List<String>> result = new ArrayList<>();
        backTrack(n, 0, board, cols, negDiag, posDiag, result);

        return result;
    }
}
