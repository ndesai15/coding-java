package com.coding.patterns.recursion;

public class Fibonacci {
    public static int fibonacci(int n) {
        if (n< 2) return n;
        else return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(8));
    }
}
