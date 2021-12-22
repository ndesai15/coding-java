package com.datastructures.hashmap;

import java.util.LinkedList;

public class MyHashMap {

    private int BUCKET_SIZE = 769;
    /** Initialize data structure here **/
    LinkedList<Entry>[] mylist;
    public MyHashMap() {
        mylist = new LinkedList[BUCKET_SIZE];
    }

    private int hashcode(int key) {
        return key % BUCKET_SIZE;
    }

    /** Value will be always be non-negative **/
    public void put(int key, int value) {
        int bucketLocation = hashcode(key);
        LinkedList<Entry> entries = mylist[bucketLocation];
        if(entries == null) {
            Entry e = new Entry(key, value);
            mylist[bucketLocation] = new LinkedList<Entry>();
            mylist[bucketLocation].add(e);
        }
        else {
            for (Entry e: entries){
                if (e.key == key) {
                    e.value = value;
                    return;
                }
            }
            Entry e1 = new Entry(key, value);
            entries.add(e1);
        }
    }

    /** Return the value to which the specified key is mapped, or -1 if there is no key found **/
    public int get(int key) {
        int bucketLocation = hashcode(key);
        LinkedList<Entry> entries = mylist[bucketLocation];
        if (entries == null) {
            return -1;
        }
        for (Entry entry: entries){
            if (entry.key == key) {
                return entry.value;
            }
        }
        return -1;
    }

    /** Remove the key from hashmap **/
    public void remove(int key) {
        int bucketLocation = hashcode(key);
        LinkedList<Entry> entries = mylist[bucketLocation];
        if (entries == null) return;
        else {
            for (Entry entry: entries){
                if (entry.key == key) {  // key found
                   entries.remove(entry);
                   return;
                }
            }
            return;
        }
    }
}

class Entry {
    public int key;
    public int value;

    Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class App {
    public static void main(String[] args) {
        MyHashMap myMap = new MyHashMap();
        myMap.put(1,10);
        myMap.put(2,20);
        myMap.put(3,30);
        myMap.put(1,100);
        myMap.put(2,200);
        myMap.put(4,10);
        System.out.println(myMap.get(1));
        System.out.println(myMap.get(2));
        System.out.println(myMap.get(3));
        System.out.println(myMap.get(4));
        myMap.remove(2);
        System.out.println(myMap.get(2));
    }
}
