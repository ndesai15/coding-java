package com.coding.patterns.dynamicprogramming.knapsack.zeroone;

public class CountSubsetOfDiff {
    public static int getCountOfSubsetOfDiff(int[] arr, int diff) {
        int sum = 0;
        for(int n: arr) {
            sum += n;
        }
        return CountAllSubSets.countSubSets(arr, (diff + sum)/ 2);
    }

    public static void main(String[] args) {
        int[] a = {1,1,2,3};
        System.out.println(getCountOfSubsetOfDiff(a, 1));
    }
}
