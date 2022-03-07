package com.coding.patterns.dfs;


/**
 * LeetCode Problem: https://leetcode.com/problems/smallest-string-starting-from-leaf/
 */
// Time Complexity: O(N * logN)
// Space Complexity: O(N)
public class SmallestStringStartingFromLeaf {
    private static String answer = "~";
    public static String smallestStringStartingFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return answer;
    }
    private static void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) return;

        sb.append((char)('a' + node.val));

        if (node.left == null && node.right == null) {
            // leaf node
            sb.reverse();
            String temp = sb.toString();
            sb.reverse(); // convert back to original that we reverted on 16

            // Time Complexity: O(L), L is length of str but in tree it will be height of tree
            // Height of tree will be O(logN)
            if (answer.compareTo(temp) < 0) {
                answer = temp;
            }
        }
        dfs(node.left, sb);
        dfs(node.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
