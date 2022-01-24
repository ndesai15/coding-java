package com.algoexpert.Tree;

/**
 * AlgoExpert Problem: https://www.algoexpert.io/questions/Flatten%20Binary%20Tree
 */

/*
  Time Complexity: O(N)
  Space Complexity: O(d), d is the depth of the tree
 */
public class FlattenBinaryTree {
    private static void connectNode(NodeDepth.BinaryTree left, NodeDepth.BinaryTree right) {
        left.right = right;
        right.left = left;
    }
    private static NodeDepth.BinaryTree[] flattenTree(NodeDepth.BinaryTree node) {
        NodeDepth.BinaryTree leftMost = null;
        NodeDepth.BinaryTree rightMost = null;
        if (node.left == null) {
            leftMost = node;
        }
        else {
            NodeDepth.BinaryTree[] leftTreeInfo = flattenTree(node.left);
            NodeDepth.BinaryTree leftSubTreeLeftMost = leftTreeInfo[0];
            NodeDepth.BinaryTree leftSubTreeRightMost = leftTreeInfo[0];
            connectNode(leftSubTreeRightMost, node);
            leftMost = leftSubTreeLeftMost;
        }
        if (node.right == null) {
            rightMost = node;
        }
        else {
            NodeDepth.BinaryTree[] rightTreeInfo = flattenTree(node.right);
            NodeDepth.BinaryTree rightSubTreeLeftMost = rightTreeInfo[0];
            NodeDepth.BinaryTree rightSubTreeRightMost = rightTreeInfo[0];
            connectNode(node, rightSubTreeLeftMost);
            rightMost = rightSubTreeRightMost;
        }
        return new NodeDepth.BinaryTree[]{leftMost, rightMost};
    }
    public static NodeDepth.BinaryTree flattenBinaryTree(NodeDepth.BinaryTree root) {
        return flattenTree(root)[0];
    }
}
