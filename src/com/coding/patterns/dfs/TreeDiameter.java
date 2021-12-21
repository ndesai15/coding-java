package com.coding.patterns.dfs;

public class TreeDiameter {
    private static int maxDiameter = 0;

    public static int findDiameter(TreeNode root) {
        calculateHeight(root);
        return maxDiameter;
    }

    private static int calculateHeight(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);
        if(leftHeight != 0 && rightHeight != 0) {
            int diameter = leftHeight + rightHeight + 1;
            maxDiameter = Math.max(diameter, maxDiameter);
        }
        // height of the current node will be equal to the maximum of the heights of
        // left or right subtree plus '1' for the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + findDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + findDiameter(root));
    }
}
