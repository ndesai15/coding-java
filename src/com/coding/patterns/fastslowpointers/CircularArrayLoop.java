package com.coding.patterns.fastslowpointers;

public class CircularArrayLoop {

    // Time Complexity : O(N^2)
    public static boolean loopExists(int[] arr) {
        if (arr.length == 0 || arr == null) return false;

        for (int i = 0; i < arr.length; i++) {

            // Move Forward if current num is positive, orElse backward
            boolean isForward = arr[i] >= 0;
            int slow = i, fast = i;

            // if slow or fast becomes `-1` this means we can't find cycle

            do {
                slow = findNextIndex(arr, isForward, slow); // move one step for slow pointer
                fast = findNextIndex(arr, isForward, fast); // move one step for fast pointer
                if (fast != -1) {
                    fast = findNextIndex(arr, isForward, fast); // move another step for fast pointer
                }
            } while (slow != -1 && fast != -1 && slow != fast);

            if (slow != -1 && slow == fast) {
                return true;
            }
        }
        return false;
    }

    private static int findNextIndex(int[] arr, boolean isForward, int currentIndex) {
        boolean direction = arr[currentIndex] >= 0;
        if (isForward != direction)
            return -1; // change in direction, return - 1;
        int nextIndex = (currentIndex + arr[currentIndex]) % arr.length;

        if (nextIndex < 0) {
            nextIndex += arr.length; // wrap around for negative numbers
        }

        if (nextIndex == currentIndex) {
            nextIndex = -1; // one element cycle
        }

        return nextIndex;
    }

    public static void main(String[] args) {
        System.out.println(loopExists(new int[] { 1, 2, -1, 2, 2 }));
        System.out.println(loopExists(new int[] { 2, 2, -1, 2 }));
        System.out.println(loopExists(new int[] { 2, 1, -1, -2 }));
    }
}
