package com.coding.patterns.backtracking;

import java.util.HashMap;
import java.util.HashSet;

public class WordPatternII {
    public static boolean wordPatternMatch(String pattern, String s) {
        if (pattern.length() == 0 && s.length() == 0) return true;
        if (pattern.length() == 0) return false;
        HashMap<Character, String> map = new HashMap<Character, String>();

        return dfs(pattern, s, 0, 0, map);
    }

    private static boolean dfs(String pattern, String s, int i, int j, HashMap<Character, String> map) {
        if (i == pattern.length() && j == s.length()) return true;
        if (i >= pattern.length() || j >= s.length()) return false;

        char c = pattern.charAt(i);

        for (int k = j + 1; k <= s.length(); k ++) {
            String sub = s.substring(j, k);
            if (!map.containsKey(c)) {
                map.put(c, sub);
                //set.add(sub);

                if (dfs(pattern, s,i + 1, k, map)) {
                    return true;
                }

                // backtrack
                map.remove(c);
                //set.remove(sub);
            } else if (map.containsKey(c) && map.get(c).equals(sub)) {
                if (dfs(pattern, s, i + 1, k, map)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(wordPatternMatch("abab", "redblueredblue"));
        System.out.println(wordPatternMatch("aaaa", "redredredred"));
        System.out.println(wordPatternMatch("aabb", "redredblveblue"));
    }
}
