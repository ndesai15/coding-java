package com.coding.patterns.slidingWindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode Problem: https://leetcode.com/problems/repeated-dna-sequences/
 */


// Time Complexity: O(N)
// Space Complexity: O(N)
public class RepeatedString {
    public static List<String> repeatedDNASequence(String str) {
        Set<String> seen = new HashSet<>();
        Set<String> result = new HashSet<>();

        for (int l = 0; l < str.length(); l++) {
            String current = str.substring(l, l + 10);

            if (seen.contains(current)) {
                result.add(current);
            }
            seen.add(current);
        }

        return new ArrayList<>(result);
    }
}
