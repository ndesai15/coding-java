package com.coding.patterns.inplace.arrayInPlace;


/**
 * LeetCode Problem: https://leetcode.com/problems/rotate-array/
 */

/*
   Time Complexity: O(N)
   Space Complexity: O(1)
 */
public class RotateArrays {
    private static void reverseArray(int[] array, int left, int right) {
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverseArray(nums, 0, n - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, n - 1);
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        rotate(a, 3);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
    }
}
