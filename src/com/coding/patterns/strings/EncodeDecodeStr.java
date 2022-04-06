package com.coding.patterns.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode Problem: https://leetcode.com/problems/encode-and-decode-strings/
 */


// Time Complexity: O(N)
// Space Complexity: O(N)
public class EncodeDecodeStr {

    // Encodes a list of strs to a str
    public String encode(List<String> strs) {
        /*
            ["neet", "co#de"]

            result: 4#neet5#co#de
         */
        String result = "";
        for (String str: strs) {
            result += String.valueOf(str.length()) + "#" + str;
        }
        return result;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        /*
            s: 4#neet5#co#de
         */
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (s.charAt(j) != '#') {
                j += 1;
            }
            /*
                s: 4#neet5#co#de
                   ^ ^
                   i j
             */
            int length = Integer.parseInt(s.substring(i, j)); // return 4
            result.add(s.substring(j, j + length + 1));
            i = j + 1 + length;
        }
        return result;
    }
}
