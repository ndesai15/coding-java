package com.coding.patterns.twoPointers;

/**
 * Coding Pattern: Two Pointers Approach
 */
public class RemoveDuplicate {

    public static int removeDuplicate(int[] arr) {
        if (arr.length >= 1) {
            int leftPointer = 1;
            for (int rightPointer = 1; rightPointer < arr.length; rightPointer++) {
                if (arr[rightPointer] != arr[rightPointer-1]) {
                    arr[leftPointer] = arr[rightPointer];
                    leftPointer++;
                }
            }
            return leftPointer++;
        }
        else return -1;
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9};
        System.out.println(removeDuplicate(arr));

        arr = new int[] {2 , 2, 2, 11};
        System.out.println(removeDuplicate(arr));

        System.out.println(removeDuplicate(new int[]{}));
    }
}
