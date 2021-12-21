package com.coding.patterns.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

/** Driver class, do not change **/
class Node {
    int val;
    Node[] children;

    public Node(int val, Node[] children) {
        this.val = val;
        this.children = children;
    }
}

public class TernaryTree { // A Tree that has a node with at most 3 children
    public static String[] ternaryTreePaths(Node root) {
        ArrayList<String> result = new ArrayList<>();
        if (root == null) {
            return result.toArray(new String[result.size()]);
        }
        ArrayList<String> path = new ArrayList<>();
        dfs(root, path, result);
        return result.toArray(new String[result.size()]);
    }

    private static void dfs(Node root, ArrayList<String> path, ArrayList<String> result) {
        // check for base case when we reach to leaf
        if (root.children[0] == null && root.children[1] == null && root.children[2] == null) {
            // We reached to leaf
            path.add(Integer.toString(root.val));
            result.add(String.join("->", path));
            // Remove the added node for backtracking
            path.remove(path.size() - 1);
            return;
        }

        // run dfs on non-null child
        for (Node child: root.children) {
            if (child != null) {
                path.add(Integer.toString(child.val));
                dfs(child, path, result);
                // remove the added node again for backtracking as we add it twice
                path.remove(path.size() - 1);
            }
        }
    }
}
