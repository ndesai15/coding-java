package com.coding.patterns.bitwiseXOR;

public class FindMissingNumber {
    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;

        int x1 = 1;
        // find XOR of all numbers from 1 to n
        for(int i = 2; i <= n; i++) {
            x1 = x1 ^ i;
        }

        int x2 = arr[0];
        // find XOR of all numbers from 1 to n
        for(int i = 1; i < arr.length; i++) {
            x2 = x2 ^ arr[i];
        }

        return x1 ^ x2;
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 4, 5, 6};
        System.out.print("Missing number is: " + findMissingNumber(arr));
    }



}
