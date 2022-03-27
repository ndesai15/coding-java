package com.coding.patterns.greedy;

import java.util.Arrays;

/**
 * LeetCode Problem: https://leetcode.com/problems/boats-to-save-people/
 */

// Time Complexity: O(N * logN)
public class BoatsToSavePeople {
    public static int numberOfBoatsToSavePeople(int[] people, int limit) {
        Arrays.sort(people);
        int result = 0, left = 0, right = people.length - 1;
        while (left <= right) {
            int remaining = limit - people[right];
            right -= 1;
            result += 1;

            if ((left <= right) && (remaining >= people[left])) {
                left += 1;
            }
        }
        return result;
    }
}
