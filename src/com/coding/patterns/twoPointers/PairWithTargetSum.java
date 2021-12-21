package com.coding.patterns.twoPointers;

/**
 * Pattern: Two pointers pattern
 * Problem: https://www.educative.io/courses/grokking-the-coding-interview/xog6q15W9GP
 */

/** Two pointers approach*/
public class PairWithTargetSum {
    public static int[] search(int[] arr, int targetSum) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum > targetSum) {
                right--;
            }
            else if (currentSum < targetSum) {
                left++;
            }
            else {
                return new int[]{left, right};
            }
        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        int[] result = search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}
