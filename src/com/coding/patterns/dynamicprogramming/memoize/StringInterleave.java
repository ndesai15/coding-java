package com.coding.patterns.dynamicprogramming.memoize;


/**
 * LeetCode Problem: https://leetcode.com/problems/interleaving-string/
 *
 * AlgoExpert Problem: https://www.algoexpert.io/questions/Interweaving%20Strings
 */

// Time Complexity: O(NM)
// Space Complexity: O(NM)
public class StringInterleave {
    private static boolean areInterleave(String one, String two, String three, int i, int j,
                                         Boolean[][] cache) {
        if (cache[i][j] != null) {
            return cache[i][j];
        }
        int k = i + j;

        if (k == three.length()) {
            return true;
        }

        if ((i < one.length()) && (one.charAt(i) == three.charAt(k))) {
            cache[i][j] = areInterleave(one, two, three, i + 1, j, cache);
            if (cache[i][j]) {
                return true;
            }
        }

        if ((j < two.length()) && (two.charAt(j) == three.charAt(k))) {
            cache[i][j] = areInterleave(one, two, three, i, j + 1, cache);
            return cache[i][j];
        }
        cache[i][j] = false;
        return false;
    }

    public static boolean isInterLeave(String one, String two, String three) {
        if (three.length() != one.length() + two.length()) {
            return false;
        }
        Boolean[][] cache = new Boolean[one.length() + 1][two.length() + 1];
        return areInterleave(one, two, three, 0, 0, cache);
    }
}
