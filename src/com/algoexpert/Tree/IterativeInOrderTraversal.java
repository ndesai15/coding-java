package com.algoexpert.Tree;

import java.util.function.Function;

/**
 * AlgoExpert Problem: https://www.algoexpert.io/questions/Iterative%20In-order%20Traversal
 *
 */

// Time Complexity: O(N)
// Space Complexity: O(1)
class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;
    public BinaryTree parent;

    public BinaryTree(int value) {
        this.value = value;
    }

    public BinaryTree(int value, BinaryTree parent) {
        this.value = value;
        this.parent = parent;
    }
}
public class IterativeInOrderTraversal {
    public static void iterativeInOrderTraversal(
            BinaryTree tree, Function<BinaryTree, Void> callback
    ) {
        BinaryTree previousNode = null;
        BinaryTree currentNode = tree;
        while (currentNode != null) {
            BinaryTree nextNode;

            if (previousNode == null || currentNode.parent == previousNode) {
                if (currentNode.left != null) {
                    nextNode = currentNode.left;
                }
                else {
                    callback.apply(currentNode);
                    nextNode = currentNode.right != null ? currentNode.right : previousNode;
                }
            }
            else if (currentNode.left == previousNode) {
                callback.apply(currentNode);
                nextNode = currentNode.right != null ? currentNode.right : previousNode;
            }
            else {
                nextNode = currentNode.parent;
            }
            previousNode = currentNode;
            currentNode = nextNode;
        }
    }
}
