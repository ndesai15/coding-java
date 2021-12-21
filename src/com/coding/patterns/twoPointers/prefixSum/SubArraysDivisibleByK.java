package com.coding.patterns.twoPointers.prefixSum;


import java.util.HashMap;

/**
 * Leetcode problem: https://leetcode.com/problems/subarray-sums-divisible-by-k/
 * Pattern: Prefix Sum (Two Pointers)
 */
public class SubArraysDivisibleByK {
    private static int totalSubArraysDivisibleByK(int[] nums, int k) {
        // Solve by Prefix sum
        int result = 0;

        /*
             Example: nums = [3 1 2 5 1], k = 3
         */
        HashMap<Integer, Integer> prefixSum = new HashMap<>();

        /*
            prefix sum:
               0 -> 1
         */

        prefixSum.put(0, 1);

        int currentSum = 0;
        for (int n: nums) {
            currentSum += n;
            /*
                1) currentSum = 3
                   reminder = 0
                   diff = 0

                2)
             */
            int reminder = currentSum % k;
            int diff = (k - reminder) % k;
            result += prefixSum.getOrDefault(diff, 0);
            prefixSum.put(diff, prefixSum.getOrDefault(diff, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {3,1,2,5,1};
        System.out.println(totalSubArraysDivisibleByK(a, 3));

        int[] b = {3,1,2,1};
        System.out.println(totalSubArraysDivisibleByK(b, 3));
    }
}
