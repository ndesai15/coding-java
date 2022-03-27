package com.coding.patterns.hashmap;

import java.util.HashMap;

/**
 * LeetCode Problem: https://leetcode.com/problems/first-unique-character-in-a-string/
 */

// Time Complexity: O(N)
// Space Complexity: O(N)
public class FirstUniqueChar {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for(char ch: s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }
        for(int i = 0; i < s.length(); i++) {
            if (frequencyMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
