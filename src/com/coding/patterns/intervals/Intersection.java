package com.coding.patterns.intervals;
import java.util.ArrayList;
import java.util.List;


public class Intersection {

    public static Interval[] intersect(Interval[] arr1, Interval[] arr2) {
        List<Interval> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            // Check if both the interval intersect with each other or not
            if(((arr2[j].start <= arr1[i].end) && (arr2[j].start >= arr1[i].start)) ||
                    ((arr1[i].start <= arr2[j].end) && (arr1[i].start >= arr2[j].start))) {
                result.add(new Interval(Math.max(arr1[i].start, arr2[j].start),
                        Math.min(arr1[i].end, arr2[j].end)));
            }

            // move pointers whichever is finishing first
            if (arr1[i].end < arr2[j].end) {
                i++;
            }
            else {
                j++;
            }
        }
        System.out.println(result.getClass().getName());
        return result.toArray(new Interval[result.size()]);
    }

    public static void main(String[] args) {
        Interval[] input1 = new Interval[]{new Interval(1, 3), new Interval(5, 6), new Interval(7, 9)};
        Interval[] input2 = new Interval[]{new Interval(2, 3), new Interval(5, 7)};

        Interval[] result = intersect(input1, input2);
        System.out.println("Intervals interesections:");
        for (Interval interval : result) {
            System.out.println("[ " + interval.start + ", " + interval.end + "]");
        }

        input1 = new Interval[]{new Interval(1, 3), new Interval(5, 7), new Interval(9, 12)};
        input2 = new Interval[]{new Interval(5, 10)};
        result = intersect(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
    }
}
