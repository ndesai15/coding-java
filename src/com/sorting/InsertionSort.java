package com.sorting;

/**
 * Sorting: Insertion Sort
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 */

public class InsertionSort {
    public static int[] insertionSort(int[] arr) {
        // i, will keep track of elements in unsorted array
        for (int i = 1; i < arr.length; i++) {
            int element = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > element) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = element;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 33;
        arr[1] = 30;
        arr[2] = 27;
        arr[3] = 25;
        arr[4] = 20;
        insertionSort(arr);
        for(int i: arr) {
            System.out.println(i);
        }
    }
}
