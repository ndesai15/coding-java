package com.coding.patterns.datastructures.hashmap;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualK {
    public static int subArraySum(int[] nums, int k) {
        int result = 0;
        int currentSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int n: nums) {
            currentSum += n;
            int diff = currentSum - k;
            result += map.getOrDefault(diff, 0);
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1};
        System.out.println(subArraySum(arr, 2));
    }
}
