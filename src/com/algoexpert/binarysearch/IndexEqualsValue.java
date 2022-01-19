package com.algoexpert.binarysearch;

public class IndexEqualsValue {
    // Time Complexity: O(logN)
    // Space Complexity: O(1)
    public int indexEqualsValue(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (mid == array[mid]) {
                if (mid == 0) return mid;
                if (mid - 1 == array[mid - 1]) {
                    // perform binary search again
                    right = mid - 1;
                }
                else {
                    return mid;
                }
            }
            else if (array[mid] < mid) {
                // Eliminate left subpart
                left = mid + 1;
            }
            else {
                // Eliminate right subpart
                right = mid - 1;
            }
        }
        return -1;
    }
}
