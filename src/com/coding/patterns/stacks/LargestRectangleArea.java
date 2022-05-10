package com.coding.patterns.stacks;

import java.util.Stack;

/**
 * LeetCode problem: https://leetcode.com/problems/largest-rectangle-in-histogram/
 */

// Time Complexity: O(N)
// Space Complexity: O(N)
public class LargestRectangleArea {
    public static int largestArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] >= heights[i]) {
                int[] current = stack.pop();
                int index = current[0];
                int height = current[1];
                maxArea = Math.max(maxArea, height * (i - index));
                start = index;
            }
            stack.push(new int[]{start, heights[i]});
        }

        int size = stack.size();
        for (int i = 0 ; i < size; i++) {
            int[] current = stack.pop();
            int index = current[0];
            int height = current[1];
            maxArea = Math.max(maxArea, height * (heights.length - index));
        }
        return maxArea;
    }
}
