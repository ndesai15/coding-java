package com.coding.patterns.basicprogramming;

/**
 * LeetCode Problem: https://leetcode.com/problems/valid-perfect-square/
 */

// Time Complexity: O(logN)
// Space Complexity: O(1)
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        long l = 1, r = num;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (mid * mid > num) {
                r = mid -1 ;
            }
            else if (mid * mid < num) {
                l = mid + 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
