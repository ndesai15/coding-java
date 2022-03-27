package com.coding.patterns.stacks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;


// LeetCode Problem: https://leetcode.com/problems/next-greater-element-i/
// Time Complexity: O(N + M), N is a length of nums1 & M is a length of nums2.
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        Stack<Integer> stack = new Stack<Integer>();
        int[] result = new int[nums1.length];

        Arrays.fill(result, -1);
        for (int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i], i);
        }

        for (int i = 0; i < nums2.length; i++) {
            int current = nums2[i];
            while(!stack.isEmpty() && stack.peek() < current) {
                int val = stack.pop();
                int idx = map1.get(val);
                result[idx] = current;
            }
            if (map1.containsKey(current)) {
                stack.push(current);
            }
        }

        return result;
    }
}
