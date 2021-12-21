package com.coding.patterns.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftMostNode {
    public static int leftModeNode(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            node = queue.poll();

            if (node.right != null) queue.offer(node.right);
            if (node.left != null) queue.offer(node.left);
        }

        return node.val;
    }
}
