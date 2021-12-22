package com.datastructures.adt;

public class Counter {
    private String name;
    private int counter;

    public Counter(String name) {
        this.name = name;
        this.counter = 0;
    }
    public void increment() {
        counter++;
    }
    public int getCounter(){
        return counter;
    }

    public String toString() {
        return name + ": " + counter;
    }
}


