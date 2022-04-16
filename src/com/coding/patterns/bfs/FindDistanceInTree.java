package com.coding.patterns.bfs;

import java.util.*;

/**
 * LeetCode Problem: https://leetcode.com/problems/find-distance-in-a-binary-tree/
 */
// Time Complexity: O(N)
// Space Complexity: O(N)
public class FindDistanceInTree {
    private void mapNodeToParent(Map<TreeNode, TreeNode> map, TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }
        map.put(root, parent);
        mapNodeToParent(map, root.left, root);
        mapNodeToParent(map, root.right, root);
    }
    private TreeNode searchForANode(TreeNode root, int p) {
        if (root == null) {
            return null;
        }
        if (root.val == p) {
            return root;
        }
        TreeNode searchOnLeft = searchForANode(root.left, p);
        if (searchOnLeft != null) {
            return searchOnLeft;
        }
        else {
            return searchForANode(root.right, p);
        }
    }
    public int findDistance(TreeNode root, int p, int q) {
        // Populate Node -> Node's parent relationship
        Map<TreeNode, TreeNode> nodeToParent = new HashMap<>();
        mapNodeToParent(nodeToParent, root, null);

        // Run BFS Algo starting from either p or q node
        int distance = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Set<TreeNode> visited = new HashSet<TreeNode>();
        TreeNode source = searchForANode(root, p);
        queue.add(source);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.remove();
                if (current.val == q) {
                    return distance;
                }

                if (!visited.contains(current)) {
                    visited.add(current);
                    if (current.left != null && !visited.contains(current.left)) {
                        queue.add(current.left);
                    }
                    if (current.right != null && !visited.contains(current.right)) {
                        queue.add(current.right);
                    }
                    TreeNode parent = nodeToParent.get(current);
                    if (parent != null && !visited.contains(parent)) {
                        queue.add(parent);
                    }
                }
            }
            distance++;
        }

        return distance;
    }
}
