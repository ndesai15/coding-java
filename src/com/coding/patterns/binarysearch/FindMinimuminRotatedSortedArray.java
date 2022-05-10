package com.coding.patterns.binarysearch;

/**
 * LeetCode Problems: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
// Time Complexity: O(logN)

public class FindMinimuminRotatedSortedArray {

    public static void main(String[] args) {
        final int[] nums = { 4, 5, 6, 7, 0, 1, 2, 3 };
        System.out.println(findMin(nums));
    }

    static public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, res = nums[0];

        while (l <= r) {
            if (nums[l] < nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }

            final int mid = (l + r) / 2;
            res = Math.min(res, nums[mid]);

            if (nums[mid] >= nums[l])
                l = mid + 1;
            else
                r = mid - 1;
        }

        return res;
    }
}
