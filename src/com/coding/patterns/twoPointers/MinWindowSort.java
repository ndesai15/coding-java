package com.coding.patterns.twoPointers;

/**
 * Pattern: Two Pointers
 * Problem: https://www.educative.io/courses/grokking-the-coding-interview/gxL951y9xj3
 */
// Time Complexity: O(N)
// Space Complexity: O(1)
public class MinWindowSort {
    public static int minWindowSort(int[] arr) {
        int left = 0, right = arr.length - 1;
        // Find an element from beginning that is smaller than it's previous element
        while(left < arr.length - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }
        if (left == arr.length - 1) return 0;

        // Find an element from end that is bigger than it's next element
        while(right > 0 && arr[right] >= arr[right - 1]) {
            right--;
        }

        // Find min and max from this window
        int subarrayMax = Integer.MIN_VALUE, subarrayMin = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            subarrayMax = Math.max(subarrayMax, arr[i]);
            subarrayMin = Math.min(subarrayMin, arr[i]);
        }
        // extend the subarray to include any number which is bigger than the minimum of the subarray
        while (left > 0 && arr[left - 1] > subarrayMin) left--;
        while (right < arr.length - 1 && arr[right + 1] < subarrayMax) right++;
        return right - left + 1;
    }
}
