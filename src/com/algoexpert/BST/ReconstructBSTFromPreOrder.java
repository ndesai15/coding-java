package com.algoexpert.BST;

import com.algoexpert.BST.BST;

import java.util.ArrayList;

// Time Complexity: O(N)
// Space Complexity: O(H), H is height of tree
public class ReconstructBSTFromPreOrder {
    static class TreeInfo {
        int rootIdx = 0;

        public TreeInfo(int rootIdx) {
            this.rootIdx = rootIdx;
        }
    }
    private static BST reconstructBSTHelper(ArrayList<Integer> list, int lower, int higher, TreeInfo treeInfo) {
        if (list.size() == treeInfo.rootIdx) return null;
        int rootVal = list.get(treeInfo.rootIdx);
        if(rootVal < lower || rootVal >= higher) return null;
        treeInfo.rootIdx += 1;
        BST node = new BST(rootVal);
        node.left = reconstructBSTHelper(list, lower, rootVal, treeInfo);
        node.right = reconstructBSTHelper(list, rootVal, higher, treeInfo);
        return node;
    }
    public static BST reconstructBST(ArrayList<Integer> preOrderTraversalVal) {
        TreeInfo currentTreeInfo = new TreeInfo(preOrderTraversalVal.get(0));
        return reconstructBSTHelper(preOrderTraversalVal, Integer.MIN_VALUE, Integer.MAX_VALUE, currentTreeInfo);
    }
}
