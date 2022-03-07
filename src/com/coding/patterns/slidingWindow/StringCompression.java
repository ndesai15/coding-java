package com.coding.patterns.slidingWindow;

/**
 * LeetCode Problem: https://leetcode.com/problems/string-compression/
 */

// Time Complexity: O(N)
// Space Complexity: O(1)
public class StringCompression {
    public static int stringCompressionLength(int[] chars) {
        int count = 0, windowStart = 0;

        for (int windowEnd = 0; windowEnd < chars.length; windowEnd++) {
            count++;

            if (windowEnd == chars.length - 1 || chars[windowEnd] != chars[windowEnd + 1]) {
                chars[windowStart] = chars[windowEnd];
                windowStart++;

                if (count != 1) {
                    char[] arr = String.valueOf(count).toCharArray();

                    for (int i = 0; i < arr.length; i++) {
                        chars[windowStart++] = arr[i];
                    }
                }
                count = 0;
            }
        }
        return windowStart;
    }
}
