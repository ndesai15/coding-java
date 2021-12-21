package com.coding.patterns.binarysearch;

public class MinimumElementInRotatedArray {
    public static int findMinRotated(int[] nums) {
        // Apply binary search
        int n = nums.length - 1;
        int left = 0, right = n;
        int boundary_Index = -1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] <= nums[n]) {
                boundary_Index = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return nums[boundary_Index];
    }

    public static void main(String[] args) {
        System.out.println(findMinRotated(new int[]{30, 40, 50, 10, 20}));
        System.out.println(findMinRotated(new int[]{11, 13, 15, 17}));
    }
}
