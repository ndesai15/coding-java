package com.coding.patterns.twoPointers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubarrayProductLessThanK {
    public static List<List<Integer>> findSubArrays(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int windowStart = 0;
        double product = 1;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            product *= arr[windowEnd];
            while (product >= target) {
                product /= arr[windowStart++];
            }
            // since the product of all numbers from left to right is less than the target therefore,
            // all subarrays from left to right will have a product less than the target too; to avoid
            // duplicates, we will start with a subarray containing only arr[right] and then extend it
            List<Integer> tempList = new LinkedList<>();
            for (int i = windowEnd; i >= windowStart; i--) {
                tempList.add(0, arr[i]);
                result.add(new ArrayList<>(tempList));
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(findSubArrays(new int[] { 2, 5, 3, 10 }, 30));
        System.out.println(findSubArrays(new int[] { 8, 2, 6, 5 }, 50));
    }

}
