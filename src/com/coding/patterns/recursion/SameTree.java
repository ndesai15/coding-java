package com.coding.patterns.recursion;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // p & q are both null
        if (p == null && q == null) {
            return true;
        }
        // if one of p & q is null
        if (q == null || p == null) return false;

        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
