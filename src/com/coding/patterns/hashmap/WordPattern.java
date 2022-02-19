package com.coding.patterns.hashmap;

import java.util.HashMap;

/**
 * LeetCode Problem: https://leetcode.com/problems/word-pattern/
 */

// Time Complexity: O(N + M) ,N is a length of Pattern & M is a length of S
// Space Complexity: O(N + M) ,N is a length of Pattern & M is a length of S
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> charMap = new HashMap<>();
        HashMap<String, Character> wordMap = new HashMap<>();
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char ch = pattern.charAt(i);
            if (charMap.containsKey(ch) && !charMap.get(ch).equals(word)) return false;
            if (wordMap.containsKey(word) && !wordMap.get(word).equals(ch)) return false;
            charMap.put(ch, word);
            wordMap.put(word, ch);
        }
        return true;
    }
}
