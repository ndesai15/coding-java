package com.coding.patterns.binarysearch;

/**
 * LeetCode Problem: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
// Time Complexity: O(logN)
// Space Complexity: O(1)
public class SearchRange {
    public static int binarySearch(int[] nums, int left, int right, int target, boolean isLeftSearch) {
        while (left <= right) {
           int mid = (left + right) / 2;
           if (nums[mid] == target) {
               if (isLeftSearch) {
                   if (mid == 0) {
                       return mid;
                   }
                   if (nums[mid] != nums[mid - 1]) {
                       return mid;
                   }
                   right = mid - 1;
               }
               else {
                   if (mid == nums.length - 1) {
                       return mid;
                   }
                   if (nums[mid] != nums[mid + 1]) {
                       return mid;
                   }
                   left = mid + 1;
               }
           }
           else if (nums[mid] > target) {
               right = mid - 1;
           }
           else {
               left = mid + 1;
           }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums, 0, nums.length - 1, target, true);
        int right = binarySearch(nums, 0, nums.length - 1, target, false);
        if (left != -1 && right != -1) {
            return new int[]{left, right};
        }
        return new int[] {-1, -1};
    }
}
