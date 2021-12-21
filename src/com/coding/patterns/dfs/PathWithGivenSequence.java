package com.coding.patterns.dfs;

public class PathWithGivenSequence {

    public static boolean checkPathSequence(TreeNode root, int[] sequence) {
        return checkPathSequenceRecursive(root, sequence, 0);
    }

    private static boolean checkPathSequenceRecursive(TreeNode root, int[] sequence, int sequenceIndex) {
        if (root == null)
            return false;
        if(sequenceIndex >= sequence.length || root.val != sequence[sequenceIndex])
            return false;
        if (root.left == null && root.right == null && sequenceIndex == sequence.length - 1)
            return root.val == sequence[sequenceIndex];
        return checkPathSequenceRecursive(root.left, sequence, sequenceIndex + 1) ||
                checkPathSequenceRecursive(root.right, sequence, sequenceIndex + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + checkPathSequence(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + checkPathSequence(root, new int[] { 1, 1, 6 }));
    }
}
