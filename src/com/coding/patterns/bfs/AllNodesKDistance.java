package com.coding.patterns.bfs;

/**
 * Leetcode problem: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 */

import java.util.*;

public class AllNodesKDistance {
    private void mapNodeToParent(Map<TreeNode, TreeNode> map, TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }
        map.put(root, parent);

        mapNodeToParent(map, root.left, root);
        mapNodeToParent(map, root.right, root);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();

        // Populate Node -> Node's Parent Relationship
        Map<TreeNode, TreeNode> nodeToParent = new HashMap<>();
        mapNodeToParent(nodeToParent, root, null);

        // Run BFS Algo Starting from target
        int currentLevel = 0;
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        while (!queue.isEmpty()) {
            if (currentLevel == k) {
                return extractLayerFromQueue(queue, result);
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                if (!visited.contains(current)) {
                    visited.add(current);
                    if (current.left != null && !visited.contains(current.left)) {
                        queue.offer(current.left);
                    }
                    if (current.right != null && !visited.contains(current.right)) {
                        queue.offer(current.right);
                    }
                    TreeNode parent = nodeToParent.get(current);
                    if (parent != null && !visited.contains(parent)) {
                        queue.offer(parent);
                    }
                }
            }
            currentLevel++;
        }
        return result;
    }

    private List<Integer> extractLayerFromQueue(Queue<TreeNode> queue, List<Integer> result) {

        for (TreeNode node: queue) {
            result.add(node.val);
        }
        return result;
    }
}
