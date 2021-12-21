package com.coding.patterns.dfs;

import javafx.util.Pair;


public class WordSearch {
    private boolean dfs(int r, int c, int i, int rows, int cols, char[][] board, String word){
        if (i == word.length()) {
            return true;
        }
        if (r < 0 || r >= rows || c < 0 || c >= cols || word.charAt(i) != board[r][c] ||
                board[r][c] == '#') {
            return false;
        }
        char ch = board[r][c];
        board[r][c] = '#';
        boolean result;
        result = dfs(r + 1, c, i + 1, rows, cols, board, word) ||
                dfs(r, c + 1, i + 1, rows, cols, board, word) ||
                dfs(r - 1, c, i + 1, rows, cols, board, word) ||
                dfs(r, c - 1, i + 1, rows, cols, board, word);
        board[r][c] = ch;
        return result;
    }

    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(r,c, 0, rows, cols, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }
}
