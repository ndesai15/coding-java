package com.coding.patterns.binarysearch;


// Time Complexity: O(logN)
// Space Complexity: O(1)
class ArrayReader {
    int[] arr;

    ArrayReader(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        if (index >= arr.length)
            return Integer.MAX_VALUE;
        return arr[index];
    }
}

public class SearchInInfiniteSortedArray {
    private static int binarySearch(ArrayReader array, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2; // left + (right - left) / 2;
            if (array.get(mid) == target) return mid;
            else if (array.get(mid) > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
    public static int searchInInfiniteSortedArray(ArrayReader array, int key) {
        // Input array is infinite array, so we should first find "Proper" range, then apply
        // regular binary search to find a key in that range.

        int left = 0, right = 1;

        while (array.get(right) < key) {
            int newLeft = right + 1;
            right += (right - left + 1) *2;
            left = newLeft;
        }
        return binarySearch(array, left, right, key);
    }
}
