package com.coding.patterns.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {

    static List<String> result = new ArrayList<>();
    public static List<String> combinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backTrack(0, map, "", digits);
        return result;
    }

    private static void backTrack(int i, HashMap<Character, String> map, String current, String digits) {
        if (current.length() == digits.length()) {
            result.add(current);
            return;
        }

        for (char c: map.get(digits.charAt(i)).toCharArray()) {
            backTrack(i + 1, map, c + current, digits);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinations("23"));
    }
}
