package com.coding.patterns.binarysearch;

import java.util.Arrays;

public class KokoEatsBanana {
    public static int minEatingSpeed(int[] piles, int h) {
        int minSpeed = Integer.MAX_VALUE;
        int start = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length - 1; i ++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }
        int end = max;
        while (start <= end) {
            int mid = (start + end) / 2;
            int hours = count(piles, mid);

            if (hours >= h) {
                minSpeed = Math.min(minSpeed, mid);
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return minSpeed;
    }

    private static int count(int[] arr, int num) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += (arr[i] / num) + (arr[i] % num == 0 ? 0 : 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Math.ceil(5/2));
    }
}
