package com.coding.patterns.basicprogramming;

/**
 * LeetCode Problem: https://leetcode.com/problems/sum-of-two-integers/
 */
// Time Complexity: O(1)
// Space Complexity
public class SumOfTwoIntegers {
    public static int sumOfTwoInt(int a, int b) {
        while (b != 0) {
            int temp = (a & b) << 1;
            a = a ^ b;
            b = temp;
        }
        return a;
    }
}
