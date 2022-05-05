package com.coding.patterns.binarysearch;

public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {  //[10]
            int mid = ( left + right ) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // Search in left portion
            if (nums[left] <= nums[mid]) {
                if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
            // Search in right portion
            else {
                if (target > nums[right] || target < nums[mid]) {
                    // go to left
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
