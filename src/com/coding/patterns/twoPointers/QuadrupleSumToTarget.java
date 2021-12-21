package com.coding.patterns.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrupleSumToTarget {
    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return quadruplets;
        }
        // Step 1 - Sort the array so that we can use two pointers
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i-1]) {
                continue;
            }
            for (int j = i + 1; j < arr.length - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j-1]) {
                    continue;
                }
                searchPairs(arr, i, j, target, quadruplets);
            }
        }
        return quadruplets;
    }
    private static void searchPairs(int[] arr, int first, int second, int target, List<List<Integer>> quadruplets) {
        int left = second + 1;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right] + arr[first] + arr[second];
            if (sum == target) {
                quadruplets.add(Arrays.asList(arr[first], arr[second], arr[left], arr[right]));
                left++;
                right--;
                while (left < right && arr[left] == arr[left - 1]) {
                    left++;
                }
                while (left < right && arr[right] == arr[right+1]) {
                    right--;
                }
            }
            else if (sum > target) {
                right--;
            }
            else {
                left++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(searchQuadruplets(new int[] { 4, 1, 2, -1, 1, -3 }, 1));
        System.out.println(searchQuadruplets(new int[] { 2, 0, -1, 1, -2, 2 }, 2));
    }
}
