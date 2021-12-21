package com.coding.patterns.arrays;

import java.util.ArrayList;

/**
 * LeetCode Problem: https://leetcode.com/problems/buildings-with-an-ocean-view/
 * AlgoExpert Problem: https://www.algoexpert.io/questions/Sunset%20Views
 */

// Time Complexity: O(N), Space Complexity: O(N)
public class OceanView {
    private static void moveFromEast(ArrayList<Integer> result, int start, int end, int max, int[] heights) {
        for (int i = start; i >= end; i--) {
            if (heights[i] > max) {
                result.add(0,i);
                max = heights[i];
            }
        }
    }

    public static int[] findBuildings(int[] heights) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (heights == null || heights.length == 0) return heights;
        result.add(heights.length - 1);
        moveFromEast(result, heights.length - 2, 0, heights[heights.length-1], heights);
        int[] ret = new int[result.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = result.get(i).intValue();
        }
        return ret;
    }
}
