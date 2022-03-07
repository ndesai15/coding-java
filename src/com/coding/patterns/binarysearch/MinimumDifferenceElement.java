package com.coding.patterns.binarysearch;


// Time Complexity: O(logN)
// Space Complexity: O(1)
public class MinimumDifferenceElement {
    private static int binarySearchMin(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                return arr[mid];
            }
            else if (arr[mid] > key) {
                right = mid - 1;
            }
            else left = mid + 1;
        }

        return Math.abs(key - arr[left]) < Math.abs(key - arr[right]) ? arr[left] : arr[right];
    }
    public static int minDifferenceElement(int[] arr, int key) {
        // We will try to search a key in a sorted array using a binary search
        // At the end if we don't find key, we can just subtract left - key & right - key, take min value out of it
        return binarySearchMin(arr, key);
    }
}
