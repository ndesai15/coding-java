package com.algoexpert.Recursion;

import java.util.ArrayList;

/**
 * AlgoExpert Problem:https://www.algoexpert.io/questions/Solve%20Sudoku
 */

// Time Complexity: O(1), Space Complexity: O(1)
public class SudokuSolver {
    public static ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
        solvePartialSudoku(0, 0, board);
        return board;
    }

    private static boolean solvePartialSudoku(int row, int col, ArrayList<ArrayList<Integer>> board) {
        int currentRow = row;
        int currentCol = col;

        if (currentCol == board.get(row).size()) {
            currentCol = 0;
            currentRow++;
            if (currentRow == board.size()) {
                return true;
            }
        }

        if (board.get(currentRow).get(currentCol) == 0) {
            return tryDigits(currentRow, currentCol, board);
        }
        return solvePartialSudoku(currentRow, currentCol + 1, board);
    }
    private static boolean tryDigits(int row, int col, ArrayList<ArrayList<Integer>> board) {
        for (int digit = 1; digit < 10; digit++) {
            if (isValidAtLocation(digit, row, col, board)) {
                board.get(row).set(col,digit);
                if(solvePartialSudoku(row, col
                 + 1, board)) {
                    return true;
                }
            }
        }
        board.get(row).set(col, 0);
        return false;
    }
    private static boolean isValidAtLocation(int value, int row, int col,ArrayList<ArrayList<Integer>> board) {
        boolean isRowValid = !board.get(row).contains(value);
        boolean isColumnValid = true;

        for (int r = 0; r < board.size(); r++) {
            if (board.get(r).get(col) == value) isColumnValid = false;
        }

        if (!isColumnValid || !isRowValid) return false;

        int subGridRowStart = row / 3;
        int subGridColStart = col / 3;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                int rowToStart = subGridRowStart * 3 + r;
                int colToStart = subGridColStart * 3 + c;
                int existingValue = board.get(rowToStart).get(colToStart);
                if (existingValue == value) return false;
            }
        }
        return true;
    }
}
