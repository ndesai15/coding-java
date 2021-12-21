package com.coding.patterns.twoPointers;

import java.util.Arrays;

public class TripletSumSmallerThanTargetCount {
    public static int countTriplets(int[] nums, int target) {
        int count = 0;
        // Sort the array to use two pointers pattern
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            count += searchPair(nums, target - nums[i], i);
        }
        return count;
    }

    private static int searchPair(int[] arr, int targetSum, int index) {
        int count = 0;
        int left = index + 1;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] < targetSum) {
                // found the triplet
                // since arr[right] >= arr[left], therefore, we can replace arr[right] by any number between
                // left and right to get a sum less than the target sum
                count += right - left;
                // left pointer
                left++;
            }
            else {
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countTriplets(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(countTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
    }
}
