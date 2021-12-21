package com.coding.patterns.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Pattern: Sliding Window
 * LeetCode Problem: https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubString {
    public static String findSubString(String s, String t) {

        // Sliding Window Pattern
        Map<Character, Integer> characterCount = new HashMap<>();
        for (char c: t.toCharArray()) {
            characterCount.put(c, characterCount.getOrDefault(c, 0) + 1);
        }
        int windowStart = 0, matched = 0, subStrAt = 0, minLength = s.length() + 1;
        int totalMatch = t.length();
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);

            if (characterCount.containsKey(rightChar)) {
                characterCount.put(rightChar, characterCount.get(rightChar) - 1);
                if (characterCount.get(rightChar) >= 0) {
                    // count of matching characters
                    matched++;
                }
            }

            // shrink the window
            while (matched == totalMatch) {
                if (minLength > windowEnd - windowStart + 1) {
                    minLength = windowEnd - windowStart + 1;
                    subStrAt = windowStart;
                }
                char leftChar = s.charAt(windowStart);
                windowStart = windowStart + 1;
                if (characterCount.containsKey(leftChar)) {
                    // note that we could have redundant matching characters, therefore we'll decrement the
                    // matched count only when a useful occurrence of a matched character is going out of the window
                    if (characterCount.get(leftChar) == 0) {
                        matched--;
                    }
                    characterCount.put(leftChar, characterCount.get(leftChar) + 1);
                }
            }
        }
        return minLength > s.length() ? "" : s.substring(subStrAt, subStrAt + minLength);
    }
    public static void main(String[] args) {
        System.out.println(findSubString("aabdec", "abc"));
        System.out.println(findSubString("abdbca", "abc"));
        System.out.println(findSubString("adcad", "abc"));
    }
}
