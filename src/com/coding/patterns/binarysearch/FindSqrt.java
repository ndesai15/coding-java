package com.coding.patterns.binarysearch;

/**
 * Leetcode problem: https://leetcode.com/problems/sqrtx/
 * Pattern: Binary Search
 */
public class FindSqrt {
    public static int findSqrt(int n) {
        int left = 0;
        int right = n;
        int sqrt = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid <= n / mid ) {
                left = mid + 1;
                sqrt = mid;
            }
            else {
                right = mid - 1;
            }
        }
        return sqrt;
    }

    public static void main(String[] args) {
        System.out.println(findSqrt(8));
        System.out.println(findSqrt(16));
    }
}
