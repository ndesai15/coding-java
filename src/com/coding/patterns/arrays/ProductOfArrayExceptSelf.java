package com.coding.patterns.arrays;

/**
 * LeetCode Problem: https://leetcode.com/problems/product-of-array-except-self/
 */

// Time Complexity: O(N)
// Space Complexity: O(1)
public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Perform Prefix product operation by traversing Left -> Right
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        // Perform Postfix product operation by traversing Right -> Left
        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }
        return result;
    }
}
