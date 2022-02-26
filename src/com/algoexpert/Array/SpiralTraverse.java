package com.algoexpert.Array;
import java.util.List;
import java.util.ArrayList;

/**
 * AlgoExpert: https://www.algoexpert.io/questions/Spiral%20Traverse
 */
public class SpiralTraverse {
    public static List<Integer> spiralTraverse(int[][] array) {
        List<Integer> result = new ArrayList<Integer>();
        if (array.length == 0) return result;

        int startRow = 0, startCol = 0, endRow = array.length - 1, endCol = array[0].length - 1;

        while(startRow <= endRow && startCol <= endCol) {
            for (int col = startCol; col <= endCol; col++) {
                result.add(array[startRow][col]);
            }

            for (int row = startRow + 1; row <= endRow; row++) {
                result.add(array[row][endCol]);
            }

            for (int col = endCol - 1; col >= startCol; col--) {
                if (startRow == endRow) break;
                result.add(array[endRow][col]);
            }

            for (int row = endRow - 1; row > startRow; row--) {
                if (startCol == endCol) break;
                result.add(array[row][startCol]);
            }
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        return result;
    }
}
