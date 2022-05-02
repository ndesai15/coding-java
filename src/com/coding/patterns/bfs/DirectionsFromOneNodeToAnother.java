package com.coding.patterns.bfs;

import java.util.*;


/**
 * TODO: In Progress. Please don't consider following as a solution.
 */
class NodeInfo {
    int value;
    String direction;

    public NodeInfo(int value, String direction) {
        this.value = value;
        this.direction = direction;
    }
}

class PairOfNode {
    int key;
    StringBuilder sb;

    public PairOfNode(int key, StringBuilder sb) {
        this.key = key;
        this.sb = sb;
    }
}

public class DirectionsFromOneNodeToAnother {
    private static void convertToGraph(TreeNode node, HashMap<Integer, List<NodeInfo>> map) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();

            if (current.left != null) {
                if (!map.containsKey(current.val)) {
                    map.put(current.val, new ArrayList<NodeInfo>());
                }
                map.get(current.val).add(new NodeInfo(current.left.val, "L"));
                if (!map.containsKey(current.left.val)) {
                    map.put(current.left.val, new ArrayList<NodeInfo>());
                }
                map.get(current.left.val).add(new NodeInfo(current.val, "U"));
                queue.add(current.left);
            }

            if (current.right != null) {
                if (!map.containsKey(current.val)) {
                    map.put(current.val, new ArrayList<NodeInfo>());
                }
                map.get(current.val).add(new NodeInfo(current.right.val, "R"));
                if (!map.containsKey(current.right.val)) {
                    map.put(current.right.val, new ArrayList<NodeInfo>());
                }
                map.get(current.right.val).add(new NodeInfo(current.val, "U"));
                queue.add(current.right);
            }
        }
    }
    public static String getDirections(TreeNode root, int startValue, int destValue) {
        // 1. Convert tree -> Graph
        HashMap<Integer, List<NodeInfo>> map = new HashMap<>();
        convertToGraph(root, map);

        // 2. Run BFS to Find Shortest Path
        Queue<PairOfNode> queue = new LinkedList<>();
        queue.add(new PairOfNode(startValue, new StringBuilder()));
        HashSet<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            PairOfNode current = queue.remove();

            if (visited.contains(current.key)) {
                continue;
            }

            visited.add(current.key);
            if (current.key == destValue) {
                return current.sb.toString();
            }

            for (NodeInfo node: map.get(current.key)) {
                if (!visited.contains(node.value)) {
                    queue.add(new PairOfNode(node.value, current.sb.append(node.direction)));
                }
            }
        }
        return "";
    }
}
