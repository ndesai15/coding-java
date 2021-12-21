package com.coding.patterns.twoPointers;

import java.util.Locale;

public class ValidPalindrome {
    public static boolean isValidPalindrome(String s) {
        if (s.isEmpty()) return true;
        String charactersRemovedString = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();

        /*
            ABA ABA
         */

        int start = 0, end = charactersRemovedString.length() - 1;
        while (start <= end) {
            if (charactersRemovedString.charAt(start) != charactersRemovedString.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidPalindrome("A man, a plan, a canal: Panama"));
    }
}
