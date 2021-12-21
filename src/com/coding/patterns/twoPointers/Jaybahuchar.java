package com.coding.patterns.twoPointers;

import java.util.ArrayList;
import java.util.List;

public class Jaybahuchar {
    public static long kSub(int k, List<Integer> nums) {
        if ( k < 0 || nums.size() == 0 || nums == null ) {
            return 0;
        }

        long totalSubArrays = 0;

        for (int windowStart = 0; windowStart < nums.size(); windowStart++) {
            int windowEnd = windowStart;
            int windowSum = 0;
            while (windowEnd < nums.size()) {
                windowSum += nums.get(windowEnd);
                if (windowSum % k == 0) {
                    totalSubArrays++;
                }
                windowEnd++;
            }
        }
        return totalSubArrays;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        list.add(11);
        list.add(9);
        list.add(5);
        System.out.println(kSub(5, list));
    }
}
