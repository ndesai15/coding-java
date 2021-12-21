package com.coding.patterns.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagrams {
    public static List<Integer> findAnagrams(String str, String pattern) {
        List<Integer> result = new ArrayList<>();
        /*Map<Character, Integer> characterMap = new HashMap<Character, Integer>();
        // Create a frequency map of characters in pattern
        for(char c: pattern.toCharArray()) {
            characterMap.put(c, characterMap.getOrDefault(c, 0) + 1);
        }
        int windowStart = 0, matched = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (characterMap.containsKey(rightChar)) {
                // decrease frequency to find ultimate match
                characterMap.put(rightChar, characterMap.get(rightChar) - 1);
                if (characterMap.get(rightChar) == 0) {
                    matched++;
                }
            }
            if (matched == characterMap.size()) {
                result.add(windowStart);
            }
            // Check for shrinking window
            if (windowEnd >= pattern.length() - 1) {
                char leftChar = str.charAt(windowStart++);
                if (characterMap.containsKey(leftChar)) {
                    if(characterMap.get(leftChar) == 0) {
                        matched--;
                    }
                    characterMap.put(leftChar, characterMap.get(leftChar) + 1);
                }
            }
        }*/

        if (pattern.length() > str.length()) {
            return result;
        }
        HashMap<Character, Integer> strCount = new HashMap<>();
        HashMap<Character, Integer> pCount = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            pCount.put(pattern.charAt(i), pCount.getOrDefault(pattern.charAt(i), 0) + 1);
            strCount.put(str.charAt(i), strCount.getOrDefault(str.charAt(i), 0) + 1);
        }

        if (pCount.equals(strCount)) {
            result.add(0);
        }
        int windowStart = 0;
        for (int windowEnd = pattern.length(); windowEnd < str.length(); windowEnd++) {
            strCount.put(str.charAt(windowEnd), strCount.getOrDefault(str.charAt(windowEnd), 0) + 1);
            strCount.put(str.charAt(windowStart), strCount.getOrDefault(str.charAt(windowStart), 0) - 1);

            if (strCount.get(str.charAt(windowStart)) == 0) {
                strCount.remove(str.charAt(windowStart));
            }
            windowStart++;

            if(pCount.equals(strCount)) {
                result.add(windowStart);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("ppqp", "pq"));
        //System.out.println(findAnagrams("abbcabc", "abc"));
    }
}
