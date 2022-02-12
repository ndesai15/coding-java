package com.algoexpert.Recursion;


// Time Complexity: O(2^(N + M))
// Space Complexity: O(N + M)
public class StrInterleavingRecursion {
    private static boolean areInterleave(String one, String two, String three, int i, int j) {
        int k = i + j;

        if (k == three.length()) {
            return true;
        }

        if ((i < one.length()) && (one.charAt(i) == three.charAt(k))) {
            if (areInterleave(one, two, three, i + 1, j)) {
                return true;
            }
        }

        if ((j < two.length()) && (two.charAt(j) == three.charAt(k))) {
            return areInterleave(one, two, three, i, j + 1);
        }

        return false;
    }
    public static boolean isInterLeave(String one, String two, String three) {
        if (three.length() != one.length() + two.length()) {
            return false;
        }
        return areInterleave(one, two, three, 0, 0);
    }
}
