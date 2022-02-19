package com.coding.patterns.stacks;

import java.util.Arrays;
import java.util.Stack;

/**
 * LeetCode problem: https://leetcode.com/problems/next-greater-element-ii/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < 2 * n; i++) {
            int currentIdx = i % n;
            while(stack.size() > 0 && nums[stack.peek()] < nums[currentIdx]) {
                int top = stack.pop();
                result[top] = nums[currentIdx];
            }
            stack.push(currentIdx);
        }
        return result;
    }
}
