package com.coding.patterns.twoPointers;

/**
 * LeetCode problem: https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation {
    public void nextPermutations(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int i = nums.length - 2;

        // find out first element index where nums[i] < nums[i + 1]
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // check if we have such an index or not
        if (i >= 0) {
           // find out second largest element to ith index element
            int j = nums.length - 1;
            while (j >= 0 && nums[j] < nums[i]) {
                j--;
            }
            // now swap such elements (i, j)
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
