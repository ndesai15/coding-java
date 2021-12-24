package com.coding.patterns.slidingWindow;


// Time Complexity : O(N), Space Complexity: O(1)
public class MinNumberOfFlips {
    private static int minFromThree(int a, int b, int c) {
        if (a < b && a < c) return a;
        else if (b < a && b < c) return b;
        else return c;
    }
    public static int minFlips(String s) {
        int n = s.length();
        s = s + s;
        String alt1 = "", alt2 = "";
        for (int i = 0; i < s.length(); i++) {
            alt1 += i % 2 == 0 ? "0" : "1";
            alt2 += i % 2 == 0 ? "1" : "0";
        }
        int result = s.length();
        int diff1 = 0, diff2 = 0;

        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            if(s.charAt(windowEnd) != alt1.charAt(windowEnd)) {
                diff1++;
            }
            if(s.charAt(windowEnd) != alt2.charAt(windowEnd)) {
                diff2++;
            }
            if (windowEnd - windowStart + 1 > n) {
                // Start shrinking window
                if (s.charAt(windowStart) != alt1.charAt(windowStart)) {
                    diff1--;
                }
                if (s.charAt(windowStart) != alt2.charAt(windowStart)) {
                    diff2--;
                }
                windowStart++;
            }
            if (windowEnd - windowStart + 1 == n) {
                result = minFromThree(result, diff1, diff2);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(minFlips("111000"));
    }
}
