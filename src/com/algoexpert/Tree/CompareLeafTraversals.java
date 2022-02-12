package com.algoexpert.Tree;


import java.util.ArrayList;

/**
 * AlgoExpert Problem: https://www.algoexpert.io/questions/Compare%20Leaf%20Traversal
 */

// Time Complexity: O(N + M), Where N is the # of nodes in first binary tree
// & M is the # of nodes in the second binary tree.
// Space Complexity: O(H1 + H2) - Where H1 is the height of 1st binary tree,
// H2 is the height of the 2nd binary tree

public class CompareLeafTraversals {
    private boolean compareTwoTreeLeafTraversals(ArrayList<NodeDepth.BinaryTree> tree1,
                                                 ArrayList<NodeDepth.BinaryTree> tree2, int idx1, int idx2) {
        if (idx1 == tree1.size() && idx2 == tree2.size()) {
            return true;
        }
        if (idx1 == tree1.size() || idx2 == tree2.size()) {
            return false;
        }
        if (tree1.get(idx1).value != tree2.get(idx2).value) return false;
        return compareTwoTreeLeafTraversals(tree1, tree2, idx1 + 1, idx2 + 1);
    }

    private void leafTraversal(NodeDepth.BinaryTree tree, ArrayList<NodeDepth.BinaryTree> result) {
        if (tree == null) {
            return;
        }
        if (tree.left == null && tree.right == null) {
            result.add(tree);
        }
        leafTraversal(tree.left, result);
        leafTraversal(tree.right, result);
    }

    public boolean compareLeafTraversal(NodeDepth.BinaryTree tree1, NodeDepth.BinaryTree tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 == null || tree2 == null) {
            return false;
        }
        ArrayList<NodeDepth.BinaryTree> firstTreeLeftTraversal = new ArrayList<NodeDepth.BinaryTree>();
        ArrayList<NodeDepth.BinaryTree> secondTreeLeftTraversal = new ArrayList<NodeDepth.BinaryTree>();

        leafTraversal(tree1, firstTreeLeftTraversal);
        leafTraversal(tree2, secondTreeLeftTraversal);

        if (firstTreeLeftTraversal.size() != secondTreeLeftTraversal.size()) {
            return false;
        }
        return compareTwoTreeLeafTraversals(firstTreeLeftTraversal, secondTreeLeftTraversal, 0, 0);
    }
}
