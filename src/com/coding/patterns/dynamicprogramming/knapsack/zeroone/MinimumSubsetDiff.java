package com.coding.patterns.dynamicprogramming.knapsack.zeroone;

public class MinimumSubsetDiff {
    private static boolean[] findSubSetSum(int[] arr, int target) {
        boolean[][] t = new boolean[arr.length + 1][target + 1];
        for(int j = 0; j <= target; j++) {
            t[0][j] = false;
        }
        for (int i = 0; i <= arr.length; i++) {
            t[i][0] = true;
        }

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (arr[i-1] <= j) {
                    t[i][j] = t[i-1][j] || t[i-1][j-arr[i-1]];
                }
                else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[arr.length];
    }
    public static int minDiff(int[] arr) {
        int sum = 0;
        for(int n: arr) {
            sum += n;
        }
        boolean[] lastRow = findSubSetSum(arr, sum / 2);
        int[] interMediateSum = new int[lastRow.length];
        int count = 0;
        for (int i = 0; i < lastRow.length; i++) {
            if (lastRow[i]) {
                interMediateSum[count++] = i;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < interMediateSum.length;i++) {
            min = Math.min(min, sum - 2 * interMediateSum[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,9};
        System.out.println(minDiff(a));

        int[] b = {1,2,7,1,5};
        System.out.println(minDiff(b));

        int[] c = {1,3, 100, 4};
        System.out.println(minDiff(c));
    }
}
