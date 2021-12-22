package com.datastructures.heap;

// Node will hold the data.
// We will implement Heap as an Array of nodes.
public class Node {
    private int key;

    public Node(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
