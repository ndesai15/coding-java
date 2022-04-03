package com.coding.patterns.arrays;

import java.util.Arrays;

/**
 * LeetCode Problem: https://leetcode.com/problems/split-array-largest-sum/
 */

// Time Complexity: O(N * logS)
public class SplitArrayLargestSum {
    private static boolean canSplit(int largest, int[] arr, int m) {
        int subArray = 0, currentSum = 0;
        for (int n: arr) {
            currentSum += n;
            if (currentSum > largest) {
                subArray += 1;
                currentSum = n;
            }
        }
        return subArray + 1 <= m;
    }
    public static int splitArray(int[] nums, int m) {
        /*
             left = min sum could be max element of an array
             right = max sum could be sum of array elements
         */
        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();
        int result = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canSplit(mid, nums, m)) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return result;
    }
}
