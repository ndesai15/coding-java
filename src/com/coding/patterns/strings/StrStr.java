package com.coding.patterns.strings;


/**
 * Leetcode problem: https://leetcode.com/problems/implement-strstr/
 */
public class StrStr {

    // Time Complexity: O(N * M)
    public int getStrStr(String haystack, String needle) {
        if (needle.isEmpty() || needle == null) return 0;
        // O(N*M)
        if(!haystack.contains(needle)) {
            return -1;
        }
        else {
            // O(N*M)
            return haystack.indexOf(needle);
        }
    }
}
