package com.coding.patterns.basicprogramming;

/**
 * LeetCode Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */

// Time Complexity: O(N)
// Space Complexity: O(1)
public class BestTimeToBuySellStocksII {
    public int maxProfit(int[] prices) {
        int sell = 0;
        int buy = Integer.MAX_VALUE;
        for (int price: prices) {
            if (price < buy) {
                buy = price;
            }
            else {
                sell += price - buy;
                buy = price;
            }
        }
        return sell;
    }
}
