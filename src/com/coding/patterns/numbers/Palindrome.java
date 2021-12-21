package com.coding.patterns.numbers;

public class Palindrome {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }

        int newNumber = 0;
        while(x > 0) {
            int newDigit = x % 10;
            newNumber = newNumber * 10 + newDigit;
            x = x / 10;
        }
        System.out.println(newNumber);
        System.out.println(newNumber == x);
        return newNumber == x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
