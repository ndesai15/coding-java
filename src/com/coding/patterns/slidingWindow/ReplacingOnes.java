package com.coding.patterns.slidingWindow;

import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.enumeration;
import static java.util.Collections.max;

public class ReplacingOnes {

    public static int findLongestArrayOfOnes(int[] arr, int k) {
        int length = 0;
        int windowStart = 0;
        int zeroCount = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if(arr[windowEnd] == 0) zeroCount++;
            while (zeroCount > k) {
                if (arr[windowStart] == 0) zeroCount--;
                windowStart++;
            }
            length = Math.max(length, windowEnd - windowStart + 1);
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(findLongestArrayOfOnes(new int[] {0,1,1,0,0,0,1,1,0,1,1}, 2));
        System.out.println(findLongestArrayOfOnes(new int[] {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3));
    }
}
