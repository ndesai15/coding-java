package com.coding.patterns.dynamicprogramming;

/**
 * Levenshtein Distance Algorithm
 * What is Algorithm? -> https://www.educative.io/edpresso/the-levenshtein-distance-algorithm
 * Video Explanation -> https://www.youtube.com/watch?v=MiqoA-yF-0M&ab_channel=BackToBackSWE
 * LeetCode problem -> https://leetcode.com/problems/edit-distance/
 */
public class LevenshteinAlgorithm {
    /*
         minDistance("horse", "ros") =


                   r  o  s
             _________________
             | 0 | 1 | 2 | 3 |
             _________________
           h  | 1 | 1 | 2 | 3 |
             _________________
           o  | 2 | 2 | 1 | 2 |
             _________________
           r  | 3 | 2 | 2 | 2 |
             _________________
           s  | 4 | 3 | 3 | 2 |
             _________________
           e  | 5 | 4 | 4 | 3 |
             _________________

          Answer d[5][3] = 3
     */

    public int minDistance(String string1, String string2) {
        // Dynamic Programming top-> bottom approach
        int[][] d = new int[string1.length() + 1][string2.length() + 1];

        // Add first column for base case
        for (int i = 0;  i <= string1.length(); i++) {
            d[i][0] = i;
        }
        // Add first row for base case
        for (int j = 0;  j <= string2.length(); j++) {
            d[0][j] = j;
        }

        // Apply algorithm
        int insertion, deletion, replace;
        for (int i = 1; i <= string1.length(); i++) {
            for (int j = 1; j <= string2.length(); j++) {
                if (string1.charAt(i-1) == string2.charAt(j-1)) {
                    // No operation needed
                    d[i][j] = d[i-1][j-1];
                }
                else {
                    insertion = d[i][j-1];
                    deletion = d[i-1][j];
                    replace = d[i-1][j-1];

                    d[i][j] = 1 + findMin(insertion, deletion, replace);
                }
            }
        }
        return d[string1.length()][string2.length()];
    }

    private int findMin(int x, int y, int z) {
        if (x <= y && x <= z){
            return x;
        }
        else if (y <= x && y <= z) {
            return y;
        }
        else return z;
    }

}
