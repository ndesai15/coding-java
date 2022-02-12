package com.algoexpert.Tree;

import java.util.HashMap;

/**
 * AlgoExpert Problem: https://www.algoexpert.io/questions/All%20Kinds%20Of%20Node%20Depths
 */
// Time Complexity: O(N) - N is the # of nodes
// Space Complexity: O(N) - N is the # of nodes
public class AllDepths {
    private static void allNodeCounts(NodeDepth.BinaryTree node, HashMap<NodeDepth.BinaryTree, Integer> nodeCounts) {
        nodeCounts.put(node, 1);
        if (node.left != null) {
            allNodeCounts(node.left, nodeCounts);
            nodeCounts.put(node, nodeCounts.get(node) + nodeCounts.get(node.left));
        }
        if (node.right != null) {
            allNodeCounts(node.right, nodeCounts);
            nodeCounts.put(node, nodeCounts.get(node) + nodeCounts.get(node.right));
        }
    }

    private static void allNodeDepths(NodeDepth.BinaryTree node, HashMap<NodeDepth.BinaryTree, Integer> nodeDepths,
                                      HashMap<NodeDepth.BinaryTree, Integer> nodeCounts) {
        nodeDepths.put(node, 0);
        if (node.left != null) {
            allNodeDepths(node.left, nodeDepths, nodeCounts);
            nodeDepths.put(node, nodeDepths.get(node.left) + nodeCounts.get(node.left)+ nodeCounts.get(node));
        }
        if (node.right != null) {
            allNodeDepths(node.right, nodeDepths, nodeCounts);
            nodeCounts.put(node, nodeDepths.get(node.right) + nodeCounts.get(node.right)+ nodeCounts.get(node));
        }
    }

    private static int sumAllDepths(NodeDepth.BinaryTree node, HashMap<NodeDepth.BinaryTree, Integer> nodeDepths) {
        if (node == null) {
            return 0;
        }
        return sumAllDepths(node.left, nodeDepths) + sumAllDepths(node.right, nodeDepths) + nodeDepths.get(node);
    }
    public static int allKindsOfNodeDepths(NodeDepth.BinaryTree root) {
        HashMap<NodeDepth.BinaryTree, Integer> nodeCounts = new HashMap<>();
        HashMap<NodeDepth.BinaryTree, Integer> nodeDepths = new HashMap<>();
        allNodeCounts(root, nodeCounts);
        allNodeDepths(root, nodeDepths, nodeCounts);
        return sumAllDepths(root, nodeDepths);
    }
}
