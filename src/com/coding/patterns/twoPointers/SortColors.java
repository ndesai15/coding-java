package com.coding.patterns.twoPointers;

public class SortColors {
    public static void sort(int[] arr) {
        /*
            Let's create a pointers low & high where low = 0th index, high = arr.length - 1;

            Move all 0's to left of low, all 2's to right of high
            so at the end we will have 0's, 1's (at low), 2's (at high)
         */

        if (arr == null || arr.length == 0) {
            return;
        }
        int low = 0, high = arr.length - 1;
        int i = 0;
        while (i <= high) {
            if (arr[i] == 0) {
                // swap 0 with low
                swap(arr, i, low);
                i++;
                low++;
            }
            else if (arr[i] == 1) {
                i++;
            }
            else {
                swap(arr, i, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int i, int low) {
        int temp = arr[i];
        arr[i] = arr[low];
        arr[low] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 0, 2, 1, 0 };
        sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 2, 2, 0, 1, 2, 0 };
        sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
    }
}
