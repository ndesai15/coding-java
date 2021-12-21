package com.coding.patterns.misc;

/**
 * Leetcode problem: https://leetcode.com/problems/integer-to-roman/
 */
public class IntegerToRoman {
    public static String intToRoman(int num) {
        final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        final String[] symbols = {"M", "CM", "D", "CD","C","XC","L","XL","X","IX","V","IV","I"};

        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (num > 0 && values.length > i) {
            if (num / values[i] > 0) {
                int count = num / values[i];
                sb.append(new String(new char[count]).replace("\0", symbols[i])); // use .repeat(count) or after
                // Java 11
                num = num % values[i];
            }
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3));  // "III"
    }
}
