package com.coding.patterns.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Element {
    // For every Number, We will store 3 things : Number, FrequencyMap, SequenceIndex
    int number;
    int frequency;
    int sequenceIndex;

    public Element(int number, int frequency, int sequenceIndex) {
        this.number = number;
        this.frequency = frequency;
        this.sequenceIndex = sequenceIndex;
    }
}
class ElementComparator implements Comparator<Element> {
    public int compare(Element e1, Element e2) {
        if (e1.frequency != e2.frequency) {
            return e2.frequency - e1.frequency;
        }
        return e2.sequenceIndex - e1.sequenceIndex;
    }
}
class FrequencyStack {
    int sequenceIndex = 0;
    PriorityQueue<Element> maxHeap = new PriorityQueue<Element>(new ElementComparator());
    Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

    public void push(int num) {
        frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        maxHeap.add(new Element(num, frequencyMap.get(num), sequenceIndex++));
    }

    public int pop() {
        int num = maxHeap.poll().number;

        // decrement the frequency or remove if this is the last number
        if (frequencyMap.get(num) > 1) {
            frequencyMap.put(num, frequencyMap.get(num) - 1);
        }
        else frequencyMap.remove(num);

        return num;
    }

    public static void main(String[] args) {
        FrequencyStack frequencyStack = new FrequencyStack();
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(3);
        frequencyStack.push(2);
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(5);
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
    }
}

