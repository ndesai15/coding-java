package com.coding.patterns.basicprogramming;

/**
 * LeetCode Problem:
 */

// Time Complexity: O(2*N)
// Space Complexity: O(1)
public class MinDominiRotations {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] targets = new int[]{tops[0], bottoms[0]};
        int missingT = 0, missingB = 0;
        for (int target: targets) {
            for (int i = 0; i < tops.length; i++) {
                int top = tops[i], bottom = bottoms[i];
                if (!(top == target || bottom == target)) {
                    break;
                }
                if (top != target) missingT++;
                if (bottom != target) missingB++;

                if (i == tops.length - 1) {
                    return Math.min(missingT, missingB);
                }
            }
        }
        return -1;
    }
}
