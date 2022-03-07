package com.coding.patterns.binarysearch;


/**
 * Educative.io Problem: https://www.educative.io/courses/grokking-the-coding-interview/RMyRR6wZoYK
 */

// Time Complexity: O(logN)
// Space Complexity: O(1)
public class MaxBitonicArray {
    public static int finMax(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return arr[left];
    }
}
