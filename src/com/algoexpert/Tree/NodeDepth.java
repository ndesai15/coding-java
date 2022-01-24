package com.algoexpert.Tree;

import java.util.Stack;

public class NodeDepth {
    static class Pair {
        BinaryTree node;
        int depth;

        public Pair(BinaryTree node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
    private static int totalNodeDepth(BinaryTree current, int depthOfParentNode) {
       if (current == null) return 0;
       return depthOfParentNode + totalNodeDepth(current.left, depthOfParentNode + 1) +
               totalNodeDepth(current.right, depthOfParentNode + 1);
    }

    // Time Complexity: O(N)
    // Space Complexity: O(H), H is the height of the tree
    public static int totalNodeDepthRecursive(BinaryTree root) {
        return totalNodeDepth(root, 0);
    }

    // Time Complexity: O(N)
    // Space Complexity: O(H), H is the height of the tree
    public static int totalDepthIterative(BinaryTree root) {
        int runningSum = 0;
        Stack<Pair> stack = new Stack<Pair>();
        // Push initial known depth
        stack.push(new Pair(root, 0));
        while (!stack.isEmpty()) {
            Pair current = stack.pop();
            if (current.node == null) continue;
            runningSum = runningSum + current.depth;
            stack.push(new Pair(current.node.right, current.depth + 1));
            stack.push(new Pair(current.node.left, current.depth + 1));
        }
        return runningSum;
    }

}
