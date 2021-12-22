package com.algoexpert.TwoPointers;

import java.util.*;

/**
 * AlgoExpert: https://www.algoexpert.io/questions/Four%20Number%20Sum
 * Note: This problem is different from LeetCode's foursum problem. This solution won't work for leetcode problem.
    Time Complexity:
        Average : O(N^2)
        Worst : O(N^3)

    Space Complexity: O(N^2)
 **/

public class FourSum {
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        List<Integer[]> result = new ArrayList<Integer[]>();
        HashMap<Integer, List<Integer[]>> map = new HashMap<>();
        // Main Loop
        for (int i = 0; i < array.length; i++) {
            // forward loop
            for (int j = i + 1; j < array.length; j++) {
                int currentSum = array[i] + array[j];
                int diff = targetSum - currentSum;
                if (map.containsKey(diff)) {
                    // found the pair
                    for (Integer[] pair: map.get(diff)) {
                        Integer[] newQuadruplet = {pair[0], pair[1], array[i], array[j]};
                        result.add(newQuadruplet);
                    }
                }
            }

            // backward loop
            for (int k = 0 ; k < i; k++) {
                int currentSum = array[i] + array[k];
                Integer[] pair = {array[k], array[i]};
                if (!map.containsKey(currentSum)) {
                    List<Integer[]> pairGroup = new ArrayList<Integer[]>();
                    pairGroup.add(pair);
                    map.put(currentSum, pairGroup);
                }
                else {
                    map.get(currentSum).add(pair);
                }
            }
        }
        return result;
    }
}
