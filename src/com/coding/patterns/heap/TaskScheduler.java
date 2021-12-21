package com.coding.patterns.heap;

import java.util.*;


public class TaskScheduler {
    // Time Complexity:  O(N * log N)
    // Space Complexity: O (N)
    public static int taskScheduler(char[] tasks, int k) {  // k is cooling period
        if (k < 1) {
            return tasks.length;
        }
        // interval count
        int interval = 0;

        // Add task to HashMap
        HashMap<Character, Integer> map = new HashMap<>();
        // TimeComplexity: O(N)
        for(char t: tasks) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        // MaxHeap
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        maxHeap.addAll(map.entrySet());

        // Time Complexity:  O(N * log N)
        while(!maxHeap.isEmpty()) {
            List<Map.Entry<Character, Integer>> waitList = new ArrayList<>();
            int n = k + 1;
            while (n > 0 && !maxHeap.isEmpty()) {
                interval++;
                Map.Entry<Character, Integer> entry = maxHeap.poll();
                if (entry.getValue() > 1) {
                    entry.setValue(entry.getValue() - 1);
                    waitList.add(entry);
                }
                n--;
            }
            maxHeap.addAll(waitList);
            if(!maxHeap.isEmpty()) {
                // CPU has to stay idle during this time
                interval += n;
            }
        }
        return interval;
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'C', 'C'};
        System.out.println("Minimum intervals needed to execute all tasks: " + taskScheduler(tasks, 2));
        tasks = new char[] { 'a', 'b', 'a' };
        System.out.println("Minimum intervals needed to execute all tasks: " + taskScheduler(tasks, 3));

        tasks = new char[] { 'a', 'a', 'a' };
        System.out.println("Minimum intervals needed to execute all tasks: " + taskScheduler(tasks, 3));

    }
}
