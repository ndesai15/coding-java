package com.coding.patterns.twoPointers;

import java.util.Arrays;

public class TripletSumCloseToTarget {

    public static int searchTriplet(int[] arr, int sum) {
        Arrays.sort(arr);
        int minDifference = Integer.MAX_VALUE;
        int closetSum = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                int tripletSum = arr[i] + arr[left] + arr[right];
                if (Math.abs(sum - tripletSum) <= minDifference && tripletSum < closetSum) {
                    minDifference = Math.abs(sum - tripletSum);
                    closetSum = tripletSum;
                }

                if(tripletSum == sum) return tripletSum;
                else if (tripletSum < sum) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return closetSum;
    }
    public static void main(String[] args) {
        System.out.println(searchTriplet(new int[] { 2,-3,4,-2 }, 1));
        System.out.println(searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
        System.out.println(searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
    }
}
