package com.coding.patterns.dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode Problem: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
public class SerializeDeserializeTree {
    public String serialize(TreeNode root) {
        if (root == null) return "X,";
        String leftSubTreeSerialize = serialize(root.left);
        String rightSubTreeSerialize = serialize(root.right);
        return root.val + "," +leftSubTreeSerialize + rightSubTreeSerialize;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodesLeft = new LinkedList<String>();
        nodesLeft.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(nodesLeft);
    }

    private TreeNode deserializeHelper(Queue<String> nodesRemaining) {
        String current = nodesRemaining.poll();
        if (current.equals("X")) return null;
        TreeNode newNode = new TreeNode(Integer.valueOf(current));
        newNode.left = deserializeHelper(nodesRemaining);
        newNode.right = deserializeHelper(nodesRemaining);
        return newNode;
    }
}
