package com.coding.patterns.dfs;

public class VisibleNodes {
    private static int recursiveCountVisibleNodes(TreeNode current, TreeNode previousVisible) {
        if (current == null) {
            return 0;
        }
        if (current.val >= previousVisible.val) {
            return 1 + recursiveCountVisibleNodes(current.left, current) +
                    recursiveCountVisibleNodes(current.right, current);
        }
        else {
            return recursiveCountVisibleNodes(current.left, previousVisible) +
                    recursiveCountVisibleNodes(current.right, previousVisible);
        }
    }
    public static int countVisibleNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + recursiveCountVisibleNodes(root.left, root) +
                recursiveCountVisibleNodes(root.right, root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.left.left = new TreeNode(3);

        root.right = new TreeNode(6);

        System.out.println(countVisibleNodes(root));
    }
}
