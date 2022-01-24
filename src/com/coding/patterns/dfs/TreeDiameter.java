package com.coding.patterns.dfs;


// Time Complexity: O(N)
// Space Complexity: O(h)
public class TreeDiameter {

    public static int findDiameter(TreeNode root) {
        int[] result = calculateHeight(root);
        return result[0];
    }

    private static int[] calculateHeight(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] leftTreeInfo = calculateHeight(root.left);
        int[] rightTreeInfo = calculateHeight(root.right);
        int leftHeight = leftTreeInfo[1];
        int rightHeight = rightTreeInfo[1];
        int currentHeight = Math.max(leftHeight, rightHeight) + 1;

        int leftDiameter = leftTreeInfo[0];
        int rightDiameter = rightTreeInfo[0];

        int currentPathSoFar = leftHeight + rightHeight;
        int maxSoFar = Math.max(leftDiameter, rightDiameter);
        int currentDiameter = Math.max(maxSoFar, currentPathSoFar);
        return new int[] {currentDiameter, currentHeight};
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
