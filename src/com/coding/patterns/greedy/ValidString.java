package com.coding.patterns.greedy;

/**
 * LeetCode Problem: https://leetcode.com/problems/valid-parenthesis-string/
 */
// Time Complexity: O(N), Space Complexity: O(1)
public class ValidString {
    public static boolean isValid(String str) {
        int leftMin = 0, leftMax = 0;
        for (char ch: str.toCharArray()) {
            if (ch == '(') {
                leftMin++;
                leftMax++;
            }
            else if (ch == ')') {
                leftMin--;
                leftMax--;
            }
            else {
                leftMin--;
                leftMax++;
            }
            if (leftMax < 0) { // Means we encounter ) as a starting character or # of occurrences of ) is > (
                return false;
            }
            if (leftMin < 0) {
                leftMin = 0;
            }
        }
        return leftMin == 0;
    }
}
