package com.coding.patterns.bitwiseXOR;

public class TwoSingleNumbers {
    public static int[] findSingleNumbers(int[] nums) {
        // XOR of all the numbers
        int xy = 0;
        for (int num: nums) {
            xy = xy ^ num;
        }
        // Get the rightmost 1 in xy XOR
        xy = xy & -xy;
        int num1 = 0;
        int num2 = 0;
        for (int num: nums) {
            if ((num & xy) == 0) { // the bit is set
                num1 ^= num;
            }
            else {
                // the bit is not set
                num2 ^= num;
            }
        }
        return new int[] {num1, num2};
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 4, 2, 1, 3, 5, 6, 2, 3, 5 };
        int[] result = findSingleNumbers(arr);
        System.out.println("Single numbers are: " + result[0] + ", " + result[1]);

        arr = new int[] { 2, 1, 3, 2 };
        result = findSingleNumbers(arr);
        System.out.println("Single numbers are: " + result[0] + ", " + result[1]);
    }
}
