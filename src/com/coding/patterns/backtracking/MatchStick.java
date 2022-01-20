package com.coding.patterns.backtracking;

import java.util.Arrays;

/**
 * LeetCode problem: https://leetcode.com/problems/matchsticks-to-square/
 */

// Time Complexity: O(4^N)
public class MatchStick {
    private static boolean backtrack(int[] sticks, int i, int[] square, int length) {
        if (i == sticks.length) return true;

        for (int j = 0; j < 4; j++) {
            if (sticks[i] + square[j] <= length) {
                square[j] += sticks[i];
                if (backtrack(sticks, i + 1, square, length)) {
                    return true;
                }
                square[j] -= sticks[i];
            }
        }
        return false;
    }
    private static void reverse(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n/2; i++) {
            int temp = nums[i];
            nums[i] = nums[n - i - 1];
            nums[n - i - 1] = temp;
        }
    }
    public static boolean makeSquare(int[] matchsticks) {
        int sum = 0;
        for (int stick: matchsticks) {
            sum += stick;
        }
        if (sum % 4 != 0) return false;
        int[] square = new int[4];
        int length = sum / 4;
        // Optimization
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return backtrack(matchsticks, 0, square, length);
    }
}
