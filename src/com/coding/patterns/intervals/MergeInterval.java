package com.coding.patterns.intervals;

import java.util.*;

public class MergeInterval {
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new LinkedList<>();
        if (intervals.size() < 2) {
            return intervals;
        }

        // Step - 1 -> Sort the Intervals
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
                                  // ^^ lambda expression

        // Step - 2 -> Create iterator over intervals
        Iterator<Interval> iterator = intervals.iterator();
        Interval currentInterval = iterator.next();
        int start = currentInterval.start;
        int end = currentInterval.end;

        // Step - 3 Merge intervals
        while (iterator.hasNext()) {
            Interval nextInterval = iterator.next();
            int nextStart = nextInterval.start;
            int nextEnd = nextInterval.end;

            // overlap case
            if (nextStart <= end) {
                end = Math.max(nextInterval.end, end);
            }
            else {
                // Non-overlapping intervals
                mergedIntervals.add(new Interval(start, end));
                start = nextStart;
                end = nextEnd;
            }
        }
        // Add the last interval
        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1,4));
        input.add(new Interval(2,5));
        input.add(new Interval(7,9));
        System.out.print("Merged intervals: ");
        for (Interval interval : merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
