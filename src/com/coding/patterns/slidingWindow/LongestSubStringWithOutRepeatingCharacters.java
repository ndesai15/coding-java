package com.coding.patterns.slidingWindow;

import java.util.HashSet;

public class LongestSubStringWithOutRepeatingCharacters {
    public static int findLengthOfLongestRepeatingCharacters(String s) {
        if (s.length() == 0) return s.length();

        int left = 0, right = 0;
        int longest = 0;
        int n = s.length();
        HashSet<Character> window = new HashSet<>();
        while (right < n) {
            if (!window.contains(s.charAt(right))) {
                window.add(s.charAt(right));
                right++;
            } else {
                window.remove(s.charAt(left));
                left++;
            }
            longest = Math.max(longest, right - left);
        }

        return longest;
    }

    public static void main(String[] args) {
        System.out.println(findLengthOfLongestRepeatingCharacters("ABCDBEA"));
    }
}
