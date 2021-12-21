package com.coding.patterns.datastructures.hashmap;

import java.util.*;

public class BrickWall {
    public static int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> countGap = new HashMap<>();
        countGap.put(0, 0);

        // wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
        for (List<Integer> row: wall) {
            int total = 0;
            for (int b = 0; b < row.size() - 1; b++) {
                total += row.get(b);
                if (countGap.containsKey(total)) {
                    countGap.put(total, countGap.get(total) + 1);
                }
                else {
                    countGap.put(total, 1);
                }
            }
        }

        return wall.size() -
                Collections.max(countGap.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey();
    }

    public static void main(String[] args) {
        List<List<Integer>> wall = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(2);
        row1.add(2);
        row1.add(1);

        List<Integer> row2 = new ArrayList<>();
        row2.add(3);
        row2.add(1);
        row2.add(2);

        List<Integer> row3 = new ArrayList<>();
        row3.add(1);
        row3.add(3);
        row3.add(2);

        List<Integer> row4 = new ArrayList<>();
        row4.add(2);
        row4.add(4);

        List<Integer> row5 = new ArrayList<>();
        row5.add(3);
        row5.add(1);
        row5.add(2);

        List<Integer> row6 = new ArrayList<>();
        row1.add(1);
        row1.add(3);
        row1.add(1);
        row1.add(1);

        wall.add(row1);
        wall.add(row2);
        wall.add(row3);
        wall.add(row4);
        wall.add(row5);
        wall.add(row6);

        System.out.println(leastBricks(wall));
    }
}
