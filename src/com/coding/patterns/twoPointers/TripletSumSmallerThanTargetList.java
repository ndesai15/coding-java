package com.coding.patterns.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumSmallerThanTargetList {

    public static List<List<Integer>> listOfTriplets(int[] nums, int target) {
        // Sort the array to use two pointers pattern
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            searchPair(nums, target - nums[i], i, triplets);
        }
        return triplets;
    }

    private static void searchPair(int[] arr, int targetSum, int index, List<List<Integer>> triplets) {
        int count = 0;
        int left = index + 1;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] < targetSum) {
                // found the triplet
                // since arr[right] >= arr[left], therefore, we can replace arr[right] by any number between
                // left and right to get a sum less than the target sum
                for(int i = right; i > left; i--) {
                    triplets.add(Arrays.asList(arr[i], arr[left], arr[i]));
                }
                // left pointer
                left++;
            }
            else {
                right--;
            }
        }
    }
}
