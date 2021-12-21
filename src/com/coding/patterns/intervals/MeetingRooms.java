package com.coding.patterns.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingRooms {
    public static int findMinimumMeetingRooms(List<Interval> meetings) {
        if(meetings.size() == 0 || meetings == null) {
            return 0;
        }
        int[] start = new int[meetings.size()];
        int[] end = new int[meetings.size()];
        for(int i = 0; i < meetings.size(); i ++) {
            start[i] = meetings.get(i).start;
        }
        for(int i = 0; i < meetings.size(); i ++) {
            end[i] = meetings.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int count = 0;
        int result = 0;
        int i = 0;
        int j = 0;
        while(i < meetings.size()) {
            if (start[i] < end[j]) {
                i++;
                count++;
            }
            else {
                j++;
                count--;
            }
            result = Math.max(result, count);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>() {
            {
                add(new Interval(4, 5));
                add(new Interval(2, 3));
                add(new Interval(2, 4));
                add(new Interval(3, 5));
            }
        };
        int result = findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Interval>() {
            {
                add(new Interval(1, 4));
                add(new Interval(2, 5));
                add(new Interval(7, 9));
            }
        };
        result = findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Interval>() {
            {
                add(new Interval(6, 7));
                add(new Interval(2, 4));
                add(new Interval(8, 12));
            }
        };
        result = findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Interval>() {
            {
                add(new Interval(1, 4));
                add(new Interval(2, 3));
                add(new Interval(3, 6));
            }
        };
        result = findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Interval>() {
            {
                add(new Interval(4, 5));
                add(new Interval(2, 3));
                add(new Interval(2, 4));
                add(new Interval(3, 5));
            }
        };
        result = findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);
    }
}
