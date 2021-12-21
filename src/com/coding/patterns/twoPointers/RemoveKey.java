package com.coding.patterns.twoPointers;

public class RemoveKey {

    public static int removeKey(int[] arr, int key) {
        if (arr.length == 0) return -1;
        else {
            int keyFound = 0;
            for (int i=0; i < arr.length; i++) {
                if (arr[i] != key) {
                    arr[keyFound] = arr[i];
                    keyFound++;
                }
            }
            return keyFound;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 3, 2, 3, 6, 3, 10, 9, 3 };
        System.out.println(removeKey(arr, 3));

        arr = new int[] { 2, 11, 2, 2, 1 };
        System.out.println(removeKey(arr, 2));
    }
}
