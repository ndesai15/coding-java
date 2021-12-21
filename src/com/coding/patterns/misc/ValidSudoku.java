package com.coding.patterns.misc;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                if (set.contains(c + " found in row " + r) ||
                set.contains(c + " found in column " + c) ||
                set.contains(c + " found in grid " + r / 3 + '-' + c / 3)) {
                    return false;
                }
                set.add(c + " found in row " + r);
                set.add(c + " found in column " + c);
                set.add(c + " found in grid " + r / 3 + '-' + c / 3);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
            {
                '5', '3', '.', '.', '7', '.', '.', '.', '.'
            },{
                '6', '.', '.', '1', '9', '5', '.', '.', '.'
            },{
                '.', '9', '8', '.', '.', '.', '.', '6', '.'}
            ,{'8', '.', '.', '.', '6', '.', '.', '.', '3'}
            ,{'4', '.', '.', '8', '.', '3', '.', '.', '1'}
            ,{'7', '.', '.', '.', '2', '.', '.', '.', '6'}
            ,{'.', '6', '.', '.', '.', '.', '2', '8', '.'}
            ,{'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                ,{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board));
    }
}
