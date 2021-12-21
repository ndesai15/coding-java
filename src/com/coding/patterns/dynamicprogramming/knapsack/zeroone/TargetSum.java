package com.coding.patterns.dynamicprogramming.knapsack.zeroone;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode : https://leetcode.com/problems/target-sum/
 */
public class TargetSum {
    public static int findTargetSubsets(int[] num, int s) {
        int totalSum = 0;
        for (int n : num) {
            totalSum += n;
        }
        if (totalSum < s || (s + totalSum) % 2 != 0) {
            return 0;
        }
        System.out.println(totalSum < s);
        int newS = ( s + totalSum ) / 2;
        int dp[]=new int[newS+1];
        // for sum ==0 we have 1 way dont take any element
        dp[0]=1;
        // rest all 0 prefilled
        // top down dp
        for(int i=0;i<num.length;i++){
            // j represents target sum
            for(int j=newS;j>=num[i];j--){
                // adding already present ways to the ways if we take that nums[i]
                dp[j]=dp[j]+dp[j-num[i]];
            }
        }
        return dp[newS];
    }

    /**
     * Based on this post: https://leetcode.com/problems/target-sum/discuss/455024/DP-IS-EASY!-5-Steps-to-Think-Through-DP-Questions.
     * */
    static class Entry {
        int index;
        int sum;

        public Entry(int index, int sum) {
            this.index = index;
            this.sum = sum;
        }
    }
    static Map<Entry,Integer> map;
    public static int findTargetSubsets2(int[] nums, int s) {
        int index = nums.length - 1;
        map = new HashMap<>();
        int currentSum = 0;
        return dp(nums, index, currentSum, s);
    }

    private static int dp(int[] nums, int currentIndex, int sum, int target) {
        Entry p = new Entry(currentIndex, sum);

        if (map.containsKey(p)) {
            return map.get(p);
        }

        if (currentIndex < 0 && sum == target) {
            return 1;
        }

        if (currentIndex < 0) {
            return 0;
        }

        int positives = dp(nums, currentIndex - 1, sum + nums[currentIndex], target);
        int negatives = dp(nums, currentIndex - 1, sum - nums[currentIndex], target);

        map.put(p, positives + negatives);

        return positives + negatives;
    }

    public static void main(String[] args) {
        TargetSum ts = new TargetSum();
        int[] num = {1, 1, 2, 3};
        System.out.println(ts.findTargetSubsets2(num, 1));
        num = new int[]{1, 2, 7, 1};
        System.out.println(ts.findTargetSubsets2(num, 9));
        num = new int[]{100};
        System.out.println(ts.findTargetSubsets2(num, -200));
        num = new int[]{1,1,1,1,1};
        System.out.println(ts.findTargetSubsets2(num, 3));
        num = new int[]{1};
        System.out.println(ts.findTargetSubsets2(num, 1));
    }
}
