package com.algorithms;

import java.util.HashMap;
import java.util.Map;

// DLL
class ListNode {
    int key;
    int value;

    ListNode prev;
    ListNode next;
}

public class LRUCache {
    Map<Integer, ListNode> map = new HashMap<>();

    ListNode head;
    ListNode tail;

    int totalItems;
    int maxCapacity;

    public LRUCache(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        totalItems = 0;

        // Dummy head & dummy tails to avoid empty states
        head = new ListNode();
        tail = new ListNode();

        // wire the head and tail together
        head.next = tail;
        tail.prev = head;
    }

    public Integer get(int key) {
        ListNode node = map.get(key);

        if (node == null) {
            return null;
        }
        // Item has been access, moved to the front of the cache
        moveToHead(node);
        return node.value;
    }

    private void addToFront(ListNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    private void removeFromList(ListNode node) {
        ListNode savedPrev = node.prev;
        ListNode savedNext = node.next;

        savedPrev.next = savedNext;
        savedNext.prev = savedPrev;
    }

    private void moveToHead(ListNode node) {
        removeFromList(node);
        addToFront(node);
    }

    public void put(int key, int value) {
        ListNode node = map.get(key);

        if (node == null) {
            // Item not found
            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.value = value;

            // add to the hashtable & the actual list that represents the cache
            map.put(key, newNode);
            addToFront(newNode);
            totalItems++;

            // check if we are over capacity
            if (totalItems > maxCapacity) {
                removeLRUEntry();
            }
        }
        else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void removeLRUEntry() {
        ListNode tail = popTail();
        map.remove(tail.key);
        --totalItems;
    }

    private ListNode popTail() {
        ListNode tailItem = tail.prev;
        removeFromList(tailItem);

        return tailItem;
    }
}
