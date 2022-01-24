package com.coding.patterns.basicprogramming;

/**
 * Leetcode problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 */

// Time Complexity: O(N)
// Space Complexity: O(1)
public class BestTimeToBuySellStock {
    public int maxProfit(int[] prices) {
        int sell = 0;
        int buy = Integer.MAX_VALUE;
        for (int price: prices) {
            if (price < buy) {
                buy = price;
            }
            else {
                sell = Math.max(sell, price - buy);
            }
        }
        return sell;
    }
}
