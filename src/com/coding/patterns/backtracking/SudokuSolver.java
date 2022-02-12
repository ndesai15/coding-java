package com.coding.patterns.backtracking;

/**
 * LeetCode problem: https://leetcode.com/problems/sudoku-solver/
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solvePartialSudoku(0, 0, board);
    }

    private boolean solvePartialSudoku(int row, int col, char[][] board) {
        int currentRow = row;
        int currentCol = col;

        if (currentCol == board[row].length) {
            currentCol = 0;
            currentRow += 1;

            if (currentRow == board.length) {
                return true;
            }
        }
        if (board[currentRow][currentCol] == '.') {
            return tryDigitsAtPosition(currentRow, currentCol, board);
        }
        return solvePartialSudoku(currentRow, currentCol + 1, board);
    }

    private boolean tryDigitsAtPosition(int row, int col, char[][] board) {
        String temp = "123456789";
        for (char digit: temp.toCharArray()) {
            if (isValidAtPosition(digit, row, col, board)) {
                board[row][col] = digit;
                if (solvePartialSudoku(row, col + 1, board)) {
                    return true;
                }
            }
        }
        board[row][col] = '.';
        return false;
    }

    private boolean isValidAtPosition(char value, int row, int col, char[][] board) {
        boolean isRowValid = true;
        for (int c = 0; c < board[row].length; c++) {
            if (Character.compare(board[row][c],value) == 0) isRowValid = false;
        }

        boolean isColumnValid = true;
        for (int r = 0; r < board.length; r++) {
            if (Character.compare(board[r][col],value) == 0) isColumnValid = false;
        }

        if (!isRowValid || !isColumnValid) {
            return false;
        }

        int subGridRowStart = (row / 3);
        int subGridColStart = (col / 3);
        for (int rowIdx = 0; rowIdx < 3; rowIdx++) {
            for (int colIdx = 0; colIdx < 3; colIdx++) {
                int rowToCheck = subGridRowStart * 3 + rowIdx;
                int colToCheck = subGridColStart * 3 + colIdx;
                char existingVal = board[rowToCheck][colToCheck];
                if (Character.compare(existingVal, value) == 0) return false;
            }
        }
        return true;
    }
}
