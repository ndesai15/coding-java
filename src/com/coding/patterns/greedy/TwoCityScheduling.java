package com.coding.patterns.greedy;

import java.util.Arrays;

/**
 * LeetCode Problem: https://leetcode.com/problems/two-city-scheduling/
 *
 * Pattern: Greedy Algorithm
 */
// Time Complexity: O(N * logN)
class CostDiff implements Comparable<CostDiff>{
    public int diff;
    public int costOfCityA;
    public int costOfCityB;

    public CostDiff(int diff, int costOfCityA, int costOfCityB) {
        this.diff = diff;
        this.costOfCityA = costOfCityA;
        this.costOfCityB = costOfCityB;
    }

    @Override
    public int compareTo(CostDiff o) {
        return this.diff - o.diff;
    }
}
public class TwoCityScheduling {
    public static int twoScheduledCosts(int[][] costs) {
        /*
            This problem follows Greedy Pattern.
            To understand this let's take this example [[10, 100], [10, 1000]]. Now you have to equally
            send people to two cities A & B. so in this case we can send in 2 ways & we will get total
            cost of 1010 (First go to A & second go to B) or cost of 110 (First go to B & second go to A).

            We will use above explained example.
            e.g, [[10, 100], [10, 1000], [50, 500], [1, 100]]
            Find which city would be beneficial to send a person by 2 elements for e.g., [10, 100], [10, 1000]
            Let's take a diff between two elements of ith place. That's shows how much it will cost you
            for sending a person to B instead of A.
            diff = [90, 990, 450, 99]
            Sort the array
            diff = [90, 99, 450, 990]

            Find out an equal # of elements to send to B first and then remanining to A
            B = [90, 99] A = [450, 990]

            Calculate respected cost
            cost = 0
            (
               90 -> Came from [10, 100] & for this we are taking city B so cost += 100 (cost = 100)
               99 -> Came from [1, 100] & for this we are taking city B so cost += 100 (cost = 200)
               450 -> Came from [50, 500] & for this we are taking city A so cost += 50 (cost = 250)
               990 -> Came from [10, 1000] & for this we are taking city A so cost += 10 (cost = 260)
            )
            return 260
         */
        int n = costs.length, result = 0;
        CostDiff[] diffArray = new CostDiff[n];
        for (int i = 0; i < costs.length; i++) {
            int diff = costs[i][1] - costs[i][0];
            diffArray[i] = new CostDiff(diff, costs[i][0], costs[i][1]);
        }
        Arrays.sort(diffArray);

        for (int i = 0; i < diffArray.length; i++) {
            if (i < diffArray.length / 2) result += diffArray[i].costOfCityB;
            else result += diffArray[i].costOfCityA;
        }
        return result;
    }
}
