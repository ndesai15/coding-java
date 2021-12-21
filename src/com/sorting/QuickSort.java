package com.sorting;

import java.util.Arrays;

/**
 * Sort: Quick Sort
 */
public class QuickSort {
    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /** Recursion */
    private static void quickSort(int[] arr, int start, int end) {
        if(start < end) {
            // Gets Index position of correctly placed Pivot value
            int q = partition(arr, start, end);
            // Sort the left half of array
            quickSort(arr, start, q - 1);
            // Sort the right half of array
            quickSort(arr, q + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int i = start - 1;
        int pivot = arr[end];
        // All values to left of pivot
        for (int j = start; j <= end; j ++) {
            if (arr[j] <= pivot) {
                i = i + 1;
                // Swap a[i] with a[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
      return i;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 81, 74, 43, 1098, 0, 8, 92, 17, 754, 912, 0, 6, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
