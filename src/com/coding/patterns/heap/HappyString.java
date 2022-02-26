package com.coding.patterns.heap;

import java.util.PriorityQueue;

class Pair {
    char ch;
    int count;

    public Pair(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}

/**
 * LeetCode Problem: https://leetcode.com/problems/longest-happy-string/
 */
public class HappyString {
    private static void addToHeap (PriorityQueue<Pair> maxHeap, char ch, int n) {
        if (n != 0) {
            maxHeap.add(new Pair(ch, n));
        }
    }
    public static String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        String result = "";
        PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>((x, y) -> y.count - x.count);
        addToHeap(maxHeap,'a', a);
        addToHeap(maxHeap,'b', b);
        addToHeap(maxHeap,'c', c);

        while (!maxHeap.isEmpty()) {
            Pair current = maxHeap.poll();
            if ((sb.length() > 1) && ((sb.charAt(sb.length() - 1) == current.ch)
                    && (sb.charAt(sb.length() - 2) == current.ch))) {
                if (maxHeap.isEmpty()) {
                    break;
                }
                Pair second = maxHeap.poll();
                sb.append(second.ch);
                second.count -= 1;
                if (second.count != 0) {
                    maxHeap.add(second);
                }
            }
            else {
                sb.append(current.ch);
                current.count -= 1;
            }
            if (current.count != 0) {
                maxHeap.add(current);
            }
        }
        return sb.toString();
    }
}
