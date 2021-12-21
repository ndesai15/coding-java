package com.coding.patterns.dynamicprogramming;

/**
 * LeetCode Problem: https://leetcode.com/problems/maximum-alternating-subsequence-sum/
 * Pattern: Dynammic Programming
 */
public class MaxAlternatingSum {
    public static long maxAlternatingSum(int[] nums) {
        long sumEven = 0, sumOdd = 0;

        for (int i = nums.length - 1; i >= 0; i --) {
            long tempEven = Math.max(sumOdd + nums[i], sumEven);
            long tempOdd = Math.max(sumEven - nums[i], sumOdd);
            sumEven = tempEven;
            sumOdd = tempOdd;
        }
        return sumEven;
    }

    public static void main(String[] args) {
        System.out.println(maxAlternatingSum(new int[] {4,2,5,3}));
    }
}
