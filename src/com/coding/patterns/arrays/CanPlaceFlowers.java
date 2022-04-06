package com.coding.patterns.arrays;


/**
 * LeetCode Problem: https://leetcode.com/problems/can-place-flowers/
 */

// Time Complexity: O(N)
// Space Complexity: O(1)
public class CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 &&
                    (i == 0 || flowerbed[i - 1] == 0) &&
                    (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                n--;
            }
            if (n <= 0) return true;
            i++;
        }
        return false;
    }
}
