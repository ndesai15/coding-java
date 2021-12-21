package com.coding.patterns.dynamicprogramming;

/**
 * Pattern: Top-Down Dynamic Programming
 * LeetCode:https://leetcode.com/problems/house-robber/
 */
public class HouseRobberOne {
    public static int rob(int[] nums) {
        int robWithOutIncludingLastHouse = 0, robWithIncludingLastHouse = 0;

        for (int n : nums) {
            int temp = Math.max(robWithOutIncludingLastHouse + n, robWithIncludingLastHouse);
            robWithOutIncludingLastHouse = robWithIncludingLastHouse;
            robWithIncludingLastHouse = temp;
        }
        return robWithIncludingLastHouse;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[] {1,2,3,1}));
        System.out.println(rob(new int[] {2,7,9,3,1}));
    }
}
