package com.datastructures.queue;


/**
 * LeetCode Problem: https://leetcode.com/problems/design-circular-queue/
 */
class DoublyLL {
    int val;
    DoublyLL next;
    DoublyLL prev;

    public DoublyLL(int val, DoublyLL next, DoublyLL prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
public class CircularQueue {
    int space;
    DoublyLL left;
    DoublyLL right;

    public CircularQueue(int k) {
        this.space = k;
        this.left = new DoublyLL(0, null, null);
        this.right = new DoublyLL(0, null, left);
    }

    public boolean enQueue(int value) {
        if(this.isFull()) {
            return false;
        }
        DoublyLL current = new DoublyLL(value, this.right, this.right.prev);
        this.right.prev.next = current;
        this.right.prev = current;
        this.space--;
        return true;
    }

    public boolean deQueue() {
        if(this.isEmpty()) {
            return false;
        }
        this.left.next = this.left.next.next;
        this.left.prev = this.left;
        this.space += 1;
        return true;
    }

    public int front() {
        return this.isEmpty() ? -1 : this.left.next.val;
    }

    public int rear() {
        return this.isEmpty() ? -1 : this.right.prev.val;
    }

    public boolean isEmpty() {
        return this.left.next == right;
    }

    public boolean isFull() {
        return this.space == 0;
    }
}
