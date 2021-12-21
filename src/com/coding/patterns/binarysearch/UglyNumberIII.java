package com.coding.patterns.binarysearch;

/**
 * Pattern: Binary Search (+ LCM => Lowest Common Multiplier)
 * LCM of integer a & b is, lcm = a * b / GCD(a,b). GCD => Greatest Common Divisor of integers a & b
 * LCM of 2 integers can result cause overflow so to avoid it, you should consider to work with long/BigInt values
 *
 * left = 1, right = Given Max Value that could be.
 * mid = left + (right - left) / 2
 * find out all the numbers from 1 to mid that are divisible by a, b, c
 * if total numbers >= n, set right = mid - 1 else left = mid + 1
 */
public class UglyNumberIII {
    private static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        else return gcd(b % a, a);
    }
    private static int lcm(int a, int b) {
        return a * b / (gcd(a, b));
    }
    private static boolean isUgly(int middle, int a, int b, int c, int n) {
        return (middle / a + middle/ b + middle / c - middle / lcm(a,b) - middle / lcm(b, c) - middle / lcm(c, a)
        + middle / lcm(a, lcm(b,c))) >= n;
    }
    public static int nthUglyNumber(int n, int a, int b, int c) {
        // Apply binary Search
        int left = 1, right = Integer.MAX_VALUE;
        int boundary_Index = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isUgly(mid, a, b, c, n)) {
                boundary_Index = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return boundary_Index;
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(3, 2, 3, 5));
        System.out.println(nthUglyNumber(4, 2, 3, 4));
    }
}
