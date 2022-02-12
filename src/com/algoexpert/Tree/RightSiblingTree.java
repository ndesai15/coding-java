package com.algoexpert.Tree;

/**
 * AlgoExpert Problem: https://www.algoexpert.io/questions/Right%20Sibling%20Tree
 */
// Time Complexity: O(N) - N is the # of nodes in tree
// Space Complexity: O(d) - d is the depth of a tree
public class RightSiblingTree {
    private static void mutate(NodeDepth.BinaryTree node, NodeDepth.BinaryTree parent, boolean isLeft) {
        if (node == null) {
            return;
        }
        NodeDepth.BinaryTree left = node.left;
        NodeDepth.BinaryTree right = node.right;
        mutate(left, node, true);
        if (parent == null) {
            node.right = null;
        }
        else if(isLeft) {
            node.right = parent.right;
        }
        else {
            if (parent.right == null) {
                node.right = null;
            }
            else {
                node.right = parent.right.left;
            }
        }
        mutate(right, node, false);
    }
    public static NodeDepth.BinaryTree rightSiblingTree(NodeDepth.BinaryTree root) {
        mutate(root, null, false);
        return root;
    }
}
