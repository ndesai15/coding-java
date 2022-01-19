package com.coding.patterns.bfs;

import java.util.*;

class PositionTracker {
    String position;
    int moves;

    public PositionTracker(String position, int moves) {
        this.position = position;
        this.moves = moves;
    }
}

/**
 * LeetCode problem: https://leetcode.com/problems/open-the-lock/
 *
 * Time Complexity: O(1000)
 * Space Complexity: O(1000)
 */
public class OpenLock {
    private List<String> getChildren(String parent) {
        List<String> result = new ArrayList<String>();
        for(int i = 0; i < parent.length(); i++) {
            char ch = parent.charAt(i);
            result.add(parent.substring(0, i) + String.valueOf((Integer.parseInt(String.valueOf(ch)) + 1 ) % 10) +
                    parent.substring(i + 1, parent.length()));
            result.add(parent.substring(0, i) + String.valueOf(((Integer.parseInt(String.valueOf(ch)) - 1 ) + 10 ) % 10 ) + parent.substring(i + 1, parent.length()));
        }
        return result;
    }
    public int openLock(String[] deadends, String target) {
        for (String deadend: deadends) {
            if (deadend.equals("0000")) return -1;
        }
        Queue<PositionTracker> queue = new LinkedList<PositionTracker>();
        queue.add(new PositionTracker("0000", 0));
        HashSet<String> visited = new HashSet<>();
        for (String deadend: deadends) {
            visited.add(deadend);
        }
        while(!queue.isEmpty()) {
            PositionTracker pt = queue.poll();
            if (pt.position.equals(target)) {
                return pt.moves;
            }
            for(String child: getChildren(pt.position)) {
                if (!visited.contains(child)) {
                    visited.add(child);
                    queue.add(new PositionTracker(child, pt.moves + 1));
                }
            }
        }
        return -1;
    }
}