package com.coding.patterns.greedy;

import java.util.Arrays;

/**
 * LeetCode Problem: https://leetcode.com/problems/boats-to-save-people/
 */

// Time Complexity: O(N * logN)
public class BoatsToSavePeople {
    public static int numberOfBoatsToSavePeople(int[] people, int limit) {
        /*
           [3, 2, 2, 1], limit = 3

           In one boat only 2 persons are allowed. Weight of 2 has to be < limit.
           Now if weight is less than we just need 1 boat if more than we will need to adjust one person
           to next boat.

           Let's be greedy. let's try to make a combination of heaviest and lightest persons.
           Then use 2 pointers technique to see if we have a right combinations(< limit).

           Sort the array: [1, 2, 2, 3], limit = 3
           Use two pointers:[1, 2, 2, 3]
                             ^        ^
                             L        R
         */
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
