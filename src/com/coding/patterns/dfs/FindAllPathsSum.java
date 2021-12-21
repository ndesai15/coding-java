package com.coding.patterns.dfs;

import java.util.ArrayList;
import java.util.List;

public class FindAllPathsSum {
    /*
             5
          /    \
         4      8
        /     /  \
       11    13    4
     /   \        /  \
    7     2      5    1


    pathSum(5, 22)
    = findPaths(5, 22, [],[[]])
    = findPaths(4, 17, [5], [[]]);
      findPaths(8, 17, [5], [[]])

      findPaths(4, 17, [5], [[]])
      = findPaths(11, 13, [4,5],[[]])
      = findPaths(7, 2, [4,5,7],[[]]) = return;
        findPaths(2, 2, [2,4,5,7], [[]])
        = [[2,4,5,7]]

      findPaths(8, 17, [5], [[]])
       = findPaths(13, 9, [5,8], [[]]);
       findPaths(4, 9, [5,8], [[]])

       findPaths(4, 9, [5,8], [[]])
       = findPaths(5, 5, [5,8,4], [[]] = [[5,8,4,5]]
     */
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        findPaths(root, sum, new ArrayList<Integer>(), paths);
        return paths;
    }

    private static void findPaths(TreeNode root, int sum, List<Integer> current, List<List<Integer>> paths) {
        if (root == null){
            return;
        }
        // we should have at least one node
        current.add(root.val);
        if(root.val == sum && root.left == null && root.right == null) {
            paths.add(current);
            return;
        }
        findPaths(root.left, sum - root.val, new ArrayList<>(current), paths);
        findPaths(root.right, sum - root.val, new ArrayList<>(current), paths);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = pathSum(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
