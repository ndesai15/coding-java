package com.algoexpert.BST;

import java.util.List;

class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
        this.value = value;
        left = null;
        right = null;
    }

    public void insert(int value) {
        if (value < this.value) {
            if (left == null) {
                left = new BST(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new BST(value);
            } else {
                right.insert(value);
            }
        }
    }
}
// Time Complexity: O(N) | Space Complexity: O(N)
public class MinHeightBST {
    public static BST minHeightBST(List<Integer> array) {
        return constructBST(array, 0, array.size() - 1);
    }

    private static BST constructBST(List<Integer> array, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        BST node = new BST(array.get(mid));
        node.left = constructBST(array, left, mid - 1);
        node.right = constructBST(array, mid + 1, right);
        return node;
    }
}
