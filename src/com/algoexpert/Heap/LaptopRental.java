package com.algoexpert.Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

// Time Complexity: O(N * log(N))
// Space Complexity: O(N)
public class LaptopRental {
    public static int minLaptopRentals(ArrayList<ArrayList<Integer>> times) {
        times.sort((a ,b) -> a.get(0) - b.get(0));
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> a - b);
        minHeap.add(times.get(0).get(1));
        int minLaptop = 1;
        for (int i = 1; i < times.size(); i++) {
            if (minHeap.peek() > times.get(i).get(0)) {
                minLaptop++;
            }
            else {
                minHeap.poll();
            }
            minHeap.add(times.get(i).get(1));
        }
        return minLaptop;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> times = new ArrayList<>();
        ArrayList<Integer> time1 = new ArrayList<>();
        time1.add(0);
        time1.add(2);

        ArrayList<Integer> time2 = new ArrayList<>();
        time2.add(1);
        time2.add(4);

        ArrayList<Integer> time3 = new ArrayList<>();
        time3.add(4);
        time3.add(6);

        ArrayList<Integer> time4 = new ArrayList<>();
        time4.add(0);
        time4.add(4);

        ArrayList<Integer> time5 = new ArrayList<>();
        time5.add(7);
        time5.add(8);

        ArrayList<Integer> time6 = new ArrayList<>();
        time6.add(9);
        time6.add(11);

        ArrayList<Integer> time7 = new ArrayList<>();
        time7.add(3);
        time7.add(10);

        times.add(time1);
        times.add(time2);
        times.add(time3);
        times.add(time4);
        times.add(time5);
        times.add(time6);
        times.add(time7);

        System.out.println(minLaptopRentals(times));
    }
}
