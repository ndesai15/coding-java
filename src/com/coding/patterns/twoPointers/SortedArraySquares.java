package com.coding.patterns.twoPointers;

/**
 * Coding Pattern: Two Pointers Pattern
 * LeetCode - Problem: https://leetcode.com/problems/squares-of-a-sorted-array/
 */
public class SortedArraySquares {

    /*
        Take 2 pointers. left = 0 & right = array.length - 1
        square(left) & square(right) whichever is bigger, add it to new Array.

        makeSquares([-3, -1, 0, 1, 2]), result = [] = {
          left = 0, right = 4, highestIndex = 4
          result = [9], left = 1, right = 4 , highestIndex = 3
        }

        makeSquares([-3, -1, 0, 1, 2]), result = [9] = {
          left = 1, right = 4, highestIndex = 3
          result = [4,9], left = 1, right = 3 , highestIndex = 2
        }

        makeSquares([-3, -1, 0, 1, 2]), result = [4,9] = {
          left = 1, right = 3, highestIndex = 2
          result = [1,4,9], left = 1, right = 2 , highestIndex = 1
        }

        makeSquares([-3, -1, 0, 1, 2]), result = [4,9] = {
          left = 1, right = 2, highestIndex = 1
          result = [1,1,4,9], left = 2, right = 2 , highestIndex = 0
        }

        makeSquares([-3, -1, 0, 1, 2]), result: [4,9] = {
          left = 2, right = 2, highestIndex = 0
          result = [0,1,1,4,9]
        } =  [0,1,1,4,9]

     */
    public static int[] makeSquares(int[] array) {
        int inputArrayLength = array.length;
        if(inputArrayLength == 0) return array;
        else {
            int[] squareArray = new int[inputArrayLength];
            int highestIndex = inputArrayLength - 1;
            int left = 0, right = inputArrayLength - 1;
            while (left <= right) {
                int leftSquare = array[left] * array[left];
                int rightSquare = array[right] * array[right];
                if (leftSquare > rightSquare) {
                    squareArray[highestIndex] = leftSquare;
                    left++;
                }
                else {
                    squareArray[highestIndex] = rightSquare;
                    right--;
                }
                highestIndex--;
            }
            return squareArray;
        }
    }
    public static void main(String[] args) {
        int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }
}
