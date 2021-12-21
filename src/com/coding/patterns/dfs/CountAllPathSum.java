package com.coding.patterns.dfs;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class CountAllPathSum {
    /*
             1
           /   \
          7      9
        /  \    /  \
       6    5   2   3
       S:12
       cpr(1, 12, [])
       = cpr(7, 12, [1])  && cpr(9, 12, [1])

       cpr(7, 12, [1])
       = cpr(6, 12, [1,7])  && cpr(5, 12, [1,7,5])

       cpr(6, 12, [1,7])
     */
    public static int countPaths(TreeNode root, int S) {
        List<Integer> currentPath = new LinkedList<>();
        return countPathsRecursive(root, S, currentPath);
    }

    private static int countPathsRecursive(TreeNode root, int S, List<Integer> currentPath) {
        if (root == null) {
            return 0;
        }
        // add the current node to path
        currentPath.add(root.val);
        int pathSum = 0, pathCount = 0;
        ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
        while (pathIterator.hasPrevious()) {
            pathSum += pathIterator.previous();
            if (pathSum == S)
            {
                pathCount++;
            }
        }
        // traverse the left subtree
        pathCount += countPathsRecursive(root.left, S, currentPath);

        // traverse the right subtree
        pathCount += countPathsRecursive(root.right, S, currentPath);

        // remove the current Node from current path to backtrack
        currentPath.remove(currentPath.size() - 1);
        return pathCount;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + countPaths(root, 11));
    }
}
