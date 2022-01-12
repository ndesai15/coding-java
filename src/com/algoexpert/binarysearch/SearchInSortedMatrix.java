package com.algoexpert.binarysearch;

public class SearchInSortedMatrix {
    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int i = 0;
        c--;
        while (i < r && c >= 0) {
            int current = matrix[i][c];
            if (current == target) {
                return new int[] {i, c};
            }
            if (current > target) {
                c--;
            }
            else {
                i++;
            }
        }
        return new int[]{-1, -1};
    }
}
