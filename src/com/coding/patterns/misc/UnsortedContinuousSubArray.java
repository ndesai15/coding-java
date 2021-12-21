package com.coding.patterns.misc;

import java.util.Arrays;

/**
 * LeetCode problem: https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 */
public class UnsortedContinuousSubArray {
    public static int findUnSortedSubArrayLength(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int start = nums.length, end = 0;

        for (int i = 0; i <nums.length; i++) {
            if (nums[i] != sorted[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }

        return end - start >= 0 ? end - start + 1: 0;
    }

    public static void main(String[] args) {
       int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};
       int result = 0;
       result = findUnSortedSubArrayLength(nums);
       System.out.println(result);
    }
}
