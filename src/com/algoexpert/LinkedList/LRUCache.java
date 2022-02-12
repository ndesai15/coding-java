package com.algoexpert.LinkedList;

import java.util.HashMap;

public class LRUCache {
    int maxSize;
    HashMap<String, DoublyLinkedListNode> cache = new HashMap<>();
    int currentSize = 0;
    DoublyLinkedList listOfMostRecent = new DoublyLinkedList();

    public LRUCache(int maxSize) {
        this.maxSize = maxSize > 1 ? maxSize : 1;
    }

    public void insertKeyValuePair(String key, int value) {
        if(!cache.containsKey(key)) {
            if (currentSize == maxSize) {
                evictLeastRecent();
            }
            else {
                currentSize +=1;
            }
            cache.put(key, new DoublyLinkedListNode(key, value));
        }
        else {
            replaceKey(key, value);
        }
        updateMostRecent(cache.get(key));
    }

    public void updateMostRecent(DoublyLinkedListNode node) {
        listOfMostRecent.setHeadTo(node);
    }
    public void evictLeastRecent() {
        String keyToRemove = listOfMostRecent.tail.key;
        listOfMostRecent.removeTail();
        cache.remove(keyToRemove);
    }

    public void replaceKey(String key, int value) {
        if (!this.cache.containsKey(key)) return;
        cache.get(key).value = value;
    }

    public LRUResult getValueFromKey(String key) {
        if(!cache.containsKey(key)) {
            return new LRUResult(false, -1);
        }
        updateMostRecent(cache.get(key));
        return new LRUResult(true, cache.get(key).value);
    }

    public String getMostRecentKey() {
        if(listOfMostRecent.head == null) return "";
        return listOfMostRecent.head.key;
    }
}
class DoublyLinkedList {
    DoublyLinkedListNode head = null;
    DoublyLinkedListNode tail = null;

    public void setHeadTo(DoublyLinkedListNode node) {
        if (node == head) {
            return;
        }
        else if(head == null) {
            // 1st element
            head = node;
            tail = node;
        }
        else if(head == tail) {
            tail.prev = node;
            head = node;
            head.next = tail;
        }
        else {
            if(tail == node) {
                removeTail();
            }
            node.removeBindings();
            head.prev = node;
            node.next = head;
            head = node;
        }
    }

    public void removeTail(){
        if (tail == null) {
            return;
        }
        else if(head == tail) {
            head = null;
            tail = null;
            return;
        }
        else {
            tail = tail.prev;
            tail.next = null;
        }
    }
}
class DoublyLinkedListNode {
    String key;
    int value;
    DoublyLinkedListNode prev = null;
    DoublyLinkedListNode next = null;

    public DoublyLinkedListNode(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public void removeBindings() {
        if(prev != null) {
            prev.next = next;
        }
        if(next != null) {
            next.prev = prev;
        }
        prev = null;
        next = null;
    }
}
class LRUResult {
    boolean found;
    int value;

    public LRUResult(boolean found, int value) {
        this.found = found;
        this.value = value;
    }
}