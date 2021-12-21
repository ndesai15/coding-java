package com.coding.patterns.binarysearch;

public class FindSmallestLetter {
    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        int boundary_index = Integer.MAX_VALUE;

        while(left <= right) {
            int mid = (left + right) / 2;
            if (letters[mid] < target) {
                left = mid + 1;
            }
            else if (letters[mid] == target) {
                left = mid + 1;
            }
            else {
                boundary_index = Math.min(boundary_index, mid);
                right = mid - 1;
            }
        }
        return boundary_index == Integer.MAX_VALUE ? letters[0] : letters[boundary_index];
    }

    public static void main(String[] args) {
        char[] letters = {'c','f', 'j'};
        System.out.println(nextGreatestLetter(letters, 'a')); // c
        System.out.println(nextGreatestLetter(letters, 'c')); // f
        System.out.println(nextGreatestLetter(letters, 'f')); // j
        System.out.println(nextGreatestLetter(letters, 'j')); // c
    }
}
