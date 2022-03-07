package com.coding.patterns.binarysearch;

// Time Complexity: O(logN)
// Space Complexity: O(1)
public class NextLetter {
    public static char searchNextLetter(char[] letters, char key) {
        int left = 0, right = letters.length - 1;
        int n = letters.length;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (key < letters[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return letters[left % n];
    }
}
