package com.coding.patterns.binarysearch;

import java.util.Arrays;

public class KokoEatsBanana {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            if (maxValue < piles[i]) {
                maxValue = piles[i];
            }
        }
        int right = maxValue;
        int minSpeed = right;
        
        // Binary Search
        while (left <= right) {
            int k = (left + right) / 2;
            long hours = count(piles, k);
            
            if (hours <= h) {
                // search in left
                minSpeed = Math.min(minSpeed, k);
                right = k - 1;
            }
            else {
                // search in right
                left = k + 1;
            }
        }
        return minSpeed;
    }
    
    private static long count(int[] arr, int num) {
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += (arr[i] / num) + (arr[i] % num == 0 ? 0 : 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Math.ceil(5/2));
    }
}
