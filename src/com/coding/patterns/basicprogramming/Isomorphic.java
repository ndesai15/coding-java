package com.coding.patterns.basicprogramming;

import java.util.HashMap;
import java.util.HashSet;

/**
 * LeetCode Problem: https://leetcode.com/problems/isomorphic-strings/
 */
public class Isomorphic {
    public static boolean isIsomorphic(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        // Step - 1 Define dataStructures
        HashMap<Character, Character> match = new HashMap<>();
        HashSet<Character> visited = new HashSet<>();
        int n = str1.length();

        for (int i = 0 ; i < n; i++) {
            char s1Char = str1.charAt(i);
            char s2Char = str2.charAt(i);

            if (match.containsKey(s1Char)) {
                if (match.get(s1Char) != s2Char) {
                    return false;
                }
            }
            else {
                if (visited.contains(s2Char)) {
                    return false;
                }
                match.put(s1Char, s2Char);
                visited.add(s2Char);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("wow", "aaa"));
    }

}
