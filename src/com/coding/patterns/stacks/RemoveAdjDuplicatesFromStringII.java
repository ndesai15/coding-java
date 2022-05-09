package com.coding.patterns.stacks;

import java.util.Stack;

/**
 * LeetCode Problem: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 */

// Time Complexity: O(N)
// Space Complexity: O(N)
public class RemoveAdjDuplicatesFromStringII {
    public static String removeDuplicates(String str, int k) {
        Stack<Character> characterStack = new Stack<>();
        Stack<Integer> counterStack = new Stack<>();

        for (char ch: str.toCharArray()) {
            if (!characterStack.isEmpty() && characterStack.peek().equals(ch)) {
                int currentCount = counterStack.pop();
                currentCount += 1;
                counterStack.push(currentCount);
            }
            else {
                characterStack.push(ch);
                counterStack.push(1);
            }

            if (counterStack.peek() == k) {
                characterStack.pop();
                counterStack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!characterStack.isEmpty()) {
            char ch = characterStack.pop();
            int n = counterStack.pop();

            for (int i = 0; i < n; i++) {
                sb.append(ch);
            }
        }
        return sb.reverse().toString();
    }
}
