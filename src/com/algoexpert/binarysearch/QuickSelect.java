package com.algoexpert.binarysearch;

public class QuickSelect {
    public static int quickSelect(int[] array, int k) {
        int position = k - 1;
        return quickSelectHelper(array, 0, array.length - 1, position);
    }
    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    private static int quickSelectHelper(int[] array, int startIdx, int endIdx, int position) {
        while (true) {
            if (startIdx > endIdx) throw new RuntimeException("This should never happen!");
            int pivotIdx = startIdx;
            int leftIdx = startIdx + 1;
            int rightIdx = endIdx;
            while (leftIdx <= rightIdx) {
                if (array[leftIdx] > array[pivotIdx] && array[rightIdx] < array[pivotIdx]) {
                    swap(leftIdx, rightIdx, array);
                }
                if (array[leftIdx] <= array[pivotIdx]) {
                    leftIdx++;
                }
                if (array[rightIdx] >= array[pivotIdx]) {
                    rightIdx--;
                }
            }
            swap(pivotIdx, rightIdx, array);
            if (rightIdx == position) return array[rightIdx];
            if (rightIdx > position) {
                endIdx = rightIdx - 1;
            }
            else {
                startIdx = rightIdx + 1;
            }
        }
    }
}
