package com.coding.patterns.recursion;

public class Factorial {
    public static int factorial(int n) {
        // base case return
        if (n <= 2) return 2;
        // recursive case return
        else return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(factorial(4));
    }


}
