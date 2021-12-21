package com.coding.patterns.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {

    public static List<List<Integer>> searchTripletsSumToZer(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i= 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i-1]){
                continue;
            }
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                int threeSum = arr[i] + arr[left] + arr[right];
                if (threeSum > 0) {
                    right--;
                }
                else if (threeSum < 0){
                    left++;
                }
                else {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(arr[i]);
                    triplet.add(arr[left]);
                    triplet.add(arr[right]);
                    triplets.add(triplet);
                    left++;
                    while (arr[left] == arr[left - 1] && left < right){
                        left++;
                    }
                }
            }
        }
        return triplets;
    }
    public static void main(String[] args) {
        System.out.println(searchTripletsSumToZer(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        System.out.println(searchTripletsSumToZer(new int[] { -5, 2, -1, -2, 3 }));
    }
}
