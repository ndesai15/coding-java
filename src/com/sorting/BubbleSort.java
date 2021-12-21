package com.sorting;

/**
 * Sorting: Bubble Sort
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 */

public class BubbleSort {
    public static int[] sort(int[] arr) {
        for(int i = arr.length - 1; i >= 0; i--) {
            boolean swapped = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap the elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) {
                return arr;
            }
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
