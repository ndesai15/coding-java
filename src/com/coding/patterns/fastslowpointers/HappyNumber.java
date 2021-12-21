package com.coding.patterns.fastslowpointers;

public class HappyNumber {
    public static boolean isHappy(int num) {
        int slow = num;
        int fast = num;
        do {
            slow = findSquareSum(slow);  // move one step
            fast = findSquareSum(findSquareSum(fast));
        } while (slow != fast);
        return slow == 1;
    }

    private static int findSquareSum(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
        //System.out.println(isHappy(23));
        //System.out.println(isHappy(12));
    }
}
