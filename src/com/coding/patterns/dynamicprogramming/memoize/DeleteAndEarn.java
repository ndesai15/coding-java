package com.coding.patterns.dynamicprogramming.memoize;

import java.util.*;

public class DeleteAndEarn {
    public static int deleteAndEarn(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        HashMap<Integer, Integer> count = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        Arrays.sort(nums);

        for (int i : nums) {
            set.add(i);
        }

        List<Integer> mainList = new ArrayList<Integer>();
        mainList.addAll(set);

        for (int i:nums) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        int earn1 = 0, earn2 = 0;
        for (int i = 0; i < mainList.size(); i++) {
            int currentEarn = mainList.get(i) * count.get(mainList.get(i));

            if (i > 0 && mainList.get(i) == mainList.get(i-1) + 1) {
                int temp = earn2;
                earn2 = Math.max(earn1 + currentEarn, earn2);
                earn1 = temp;
            }
            else {
                int temp = earn2;
                earn2 = currentEarn + earn2;
                earn1 = temp;
            }
        }
        return earn2;
    }
}
