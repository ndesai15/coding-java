package com.coding.patterns.tree;

import java.util.Arrays;

public class BuildTree {
    /*
        PreOrder -> Root Left Right
        InOrder -> Left Root Right
     */
    public static TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null || preOrder.length == 0 || inOrder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[0]);
        int mid = findIndex(inOrder, preOrder[0]);
        root.left = buildTree(Arrays.copyOfRange(preOrder, 1, mid + 1), Arrays.copyOfRange(inOrder,0, mid));
        root.right = buildTree(Arrays.copyOfRange(preOrder, mid + 1, preOrder.length), Arrays.copyOfRange(inOrder, mid + 1, inOrder.length));
        return root;
    }

    private static int findIndex(int[] temp, int element) {
        if (temp == null) {
            return -1;
        }
        int i = 0;
        while (i < temp.length) {
            if (temp[i] == element) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private static int[] convertToInt(Object[] obj) {
        int[] intArray = new int[obj.length];
        for(int i=0; i< obj.length; i++){
            intArray[i] = (int) obj[i];
        }
        return intArray;
    }

    public static void main(String[] args) {
        System.out.println(buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }
}
