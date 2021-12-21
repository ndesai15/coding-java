package com.coding.patterns.dfs;

import javafx.beans.property.ReadOnlyObjectProperty;

import java.util.ArrayList;
import java.util.List;

public class SumOfPathNumbers {
    public static int findSumOfPathNumbers(TreeNode root) {
        List<Integer> allPaths = new ArrayList<>();
        getAllPaths(root, allPaths, "");
        int sum = 0;

        for(Integer i: allPaths) {
            sum += i;
        }
        return sum;
    }

    private static void getAllPaths(TreeNode root, List<Integer> allPaths, String result) {
        if(root == null){
            return;
        }
        result = result + String.valueOf(root.val);
        if(root.left == null && root.right == null) {
            allPaths.add(Integer.parseInt(result));
            return;
        }
        getAllPaths(root.left, allPaths, result );
        getAllPaths(root.right, allPaths, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
    }
}
