package com.coding.patterns.twoPointers;

import java.util.Arrays;

public class TripletSumCloseToTarget {

    // Time Complexity O(N* logN + N^2)
    public static int searchTriplet(int[] arr, int sum) {
        if (arr == null || arr.length < 3) throw new IllegalArgumentException();
        Arrays.sort(arr); // O(N* logN)
        int smallestDiff = Integer.MAX_VALUE;
        int right = arr.length - 1;
        // O(N^2)
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;

            while (left < right) {
                int targetDiff = sum - arr[i] - arr[left] - arr[right];
                if (targetDiff == 0) return sum;

                if (Math.abs(targetDiff) < Math.abs(smallestDiff) ||
                        (Math.abs(targetDiff) == Math.abs(smallestDiff) && targetDiff > smallestDiff)) {
                    smallestDiff = targetDiff;
                }

                if (targetDiff > 0) left++;
                else right--;
            }
        }
        return sum - smallestDiff;
    }
    public static void main(String[] args) {
        System.out.println(searchTriplet(new int[] { 2,-3,4,-2 }, 1));
        System.out.println(searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
        System.out.println(searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
    }
}
