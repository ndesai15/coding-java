package com.coding.patterns.binarysearch;


/**
 * Educative.io problem: Rotation Count https://www.educative.io/courses/grokking-the-coding-interview/R1v4P0R7VZw
 */
// Time Complexity: O(logN)
// Space Complexity: O(1)
public class RotationCount {
    public static int countRotationCounts(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid < right && arr[mid] > arr[mid + 1]) {
                return mid + 1;
            }

            if (mid > left && arr[mid - 1] > arr[mid]) {
                return mid;
            }

            if (arr[left] < arr[mid]) {
                // left side is sorted portion, so min(pivot) is on right side
                left = mid + 1;
            }
            else {
                // Right side is sorted portion, so min(pivot) is on left side
                right = mid - 1;
            }

        }

        return 0; // The array has not been rotated
    }
}
