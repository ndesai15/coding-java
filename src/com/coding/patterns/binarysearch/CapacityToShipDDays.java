package com.coding.patterns.binarysearch;

public class CapacityToShipDDays {
    private static boolean feasible(int[] weights, int maxWeight, int d) {
        int capacity = maxWeight, i = 0, req_days = 1, n = weights.length;
        while(i < n) {
            if (weights[i] <= capacity) {
                capacity -= weights[i];
                i++;
            }
            else {
                req_days++;
                capacity = maxWeight;
            }
        }

        return req_days <= d;
    }
    public static int minMaxWeight(int[] weights, int d) {
        // Minimum capacity for 1 day, will be our left boundary for binary search
        int left = Integer.MIN_VALUE;
        for (int weight: weights) {
            if(weight > left) {
                left = weight;
            }
        }

        // Maximum Capacity will be to ship all packages in 1 day,
        int right = 0;
        for (int weight: weights) {
            right += weight;
        }
        int boundaryIndex = 0;
        // Apply Binary Search
        while (left <= right) {
            int mid = (left + right) / 2;
            if(feasible(weights, mid, d)) {
                boundaryIndex = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return boundaryIndex;
    }

    public static void main(String[] args) {
        System.out.println(minMaxWeight(new int[]{1, 2, 3, 1, 1}, 4));
    }
}
