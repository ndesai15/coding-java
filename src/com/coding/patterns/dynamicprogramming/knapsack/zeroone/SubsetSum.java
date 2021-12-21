package com.coding.patterns.dynamicprogramming.knapsack.zeroone;

public class SubsetSum {
    public static boolean doesExist(int[] arr, int sum) {
        boolean[][] t = new boolean[arr.length + 1][sum + 1];

        // fill out 1st row
        for (int j = 0; j <= sum; j++) {
            t[0][j] = false;
        }

        // fill out 1st column
        for (int i = 0; i <= arr.length; i++) {
            t[i][0] = true;
        }

        for (int i = 1; i <= arr.length;i++) {
            for(int j = 1; j <=sum; j++) {
                if (arr[i-1] <= j) {
                    t[i][j] = t[i-1][j] || t[i-1][j-arr[i-1]];
                }
                else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[arr.length][sum];
    }

    public static void main(String[] args) {
        int[] a = {2,3,7,8,10};
        System.out.println(doesExist(a, 11));
        System.out.println(doesExist(a, 14));
        System.out.println(doesExist(a, 12));
    }
}
