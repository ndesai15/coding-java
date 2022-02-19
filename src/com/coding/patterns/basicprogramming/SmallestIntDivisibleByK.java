package com.coding.patterns.basicprogramming;

/**
 * LeetCode Problem: https://leetcode.com/problems/smallest-integer-divisible-by-k/
 */
// Time Complexity: O(K)
// Space Complexity: O(1)
public class SmallestIntDivisibleByK {
    public static int lengthOfIntDivisibleByK(int k) {
        /*
           n can contain only 1 digits
           Possible n:
             1, 11, 111, 1111, 11111, 111111,...

           Now value of n can be large and can't fit in int so we should % k to keep it in range

           if k is multiplier of 2 or 5 then we can directly return -1 because 2 can only divide even numbers while here n contains
           only 1 digit. 5 can only divide 0/5th last digit number
         */
        if (k % 2 == 0 || k % 5 == 0) return -1;

        int n = 1, length = 1;
        while (n % k != 0) {
            n = (n * 10 + 1) % k;
            length++;
        }
        return length;
    }
}
