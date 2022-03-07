package com.coding.patterns.binarysearch;


/**
 * Educative io:https://www.educative.io/courses/grokking-the-coding-interview/qA5wW7R8ox7
 */

// Time Complexity: O(LogN)
// Space Complexity: O(1)
public class CeilingOfNumber {
    public static int searchCeilingOfANumber(int[] arr, int key) {
        if (key > arr[arr.length - 1]) return -1;

        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == key) return mid;
            else if (arr[mid] > key) right = mid - 1;
            else left = mid - 1;
        }

        return left;
    }
}
