package com.coding.patterns.slidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode Problem: https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
 */

// Time Complexity: O(N * K), N is the size of String
// Space Complexity: O(N * K), N is the size of String
public class StringContainsBinaryCodesOfSizeK {
    public static boolean hasAllCodes(String s, int k) {
        Set<String> uniqueCode = new HashSet<String>();
        for (int i = 0; i < s.length() - k + 1; i++) {
            uniqueCode.add(s.substring(i, i + k));
        }
        return uniqueCode.size() == Math.pow(2, k);
    }
}
