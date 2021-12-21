package com.sorting;

/**
 * Sorting: Selection Sort
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 */

public class SelectionSort {
    public static int[] sort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
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
        sort(arr);
        for(int i: arr) {
            System.out.println(i);
        }
    }
}
