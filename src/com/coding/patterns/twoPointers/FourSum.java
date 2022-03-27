package com.coding.patterns.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * LeetCode Problem: https://leetcode.com/problems/4sum/
 */

// Time Complexity: O(N^k-1); here k is 4
// Space Complexity: O(n)
public class FourSum {
    public static List<List<Integer>> fourSumQuadruplets(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> quad = new ArrayList<>();
        kSum(4, 0, nums, quad, result, target);
        return result;
    }

    private static void kSum(int k, int start, int[] nums, List<Integer> quad, List<List<Integer>> result, int target) {
        if (k != 2) {
            for (int i = start; i < nums.length - k + 1; i++) {
                if ((i > start) && nums[i] == nums[i-1]) continue;
                quad.add(nums[i]);
                kSum(k - 1, i + 1, nums, quad, result, target - nums[i]);
                quad.remove(quad.size() - 1);
            }
            return;
        }

        // base case, when k = 2
        int l = start, r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] > target) {
                r--;
            }
            else if (nums[l] + nums[r] > target) {
                l++;
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[l]);
                list.add(nums[r]);
                for (int n: quad) {
                    list.add(n);
                }
                result.add(list);
                l++;

                while(l < r && nums[l] == nums[l - 1]) {
                    l++;
                }
            }
        }
    }
}
