package com.algoexpert.Array;

public class SingleCycleCheck {
    private static int getNextIdx(int idx, int[] array) {
        int jump = array[idx];
		/*
		 # Explanation of % operation
		 	   Let's take an example [26, 1, 2, 3, 4]
				 - let's we start at 0th index then what will be the next idx?
				 - jump = 26 which is out of bound.
				 - To bound this value divide it by valid range in between we want this value
				 - nextIdx = (0 + 26) % array.length;
				 - % Will bring value within range;
		*/
        int nextIdx = (idx + jump) % array.length;
		/*
		 # Explanation of % operation
		 	   Let's take an example [-26, 1, 2, 3, 4]
				 - let's we start at 0th index then what will be the next idx?
				 - jump = -26 which is out of bound.
				 - To bound this value divide it by valid range in between we want this value
				 - nextIdx = (0 - 26) % array.length;
				 - % Will bring value within range;
				 - nextIdx = -1 which is still out of bound.
				 - Add length of array which will bring back -ve value within range of array.
		*/
        return nextIdx >=0 ? nextIdx : (nextIdx + array.length);
    }
    public static boolean hasSingleCycle(int[] array) {
        int numElementsVisited = 0;
        int currentIdx = 0;
        while (numElementsVisited < array.length) {
            if (numElementsVisited > 0 && currentIdx == 0) return false;
            numElementsVisited++;
            currentIdx = getNextIdx(currentIdx, array);
        }
        return currentIdx == 0;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 1, -4, -4, 2};
        int[] b = {2, 3, 1, -3, -4, 2};
        int[] c = {2, 3, 1, -4, 2};
        int[] d = {26, 1, 2, 3, 4};
        System.out.println(hasSingleCycle(a)); // true
        System.out.println(hasSingleCycle(b)); // false
        System.out.println(hasSingleCycle(c)); // false
        System.out.println(hasSingleCycle(d)); // false
    }
}
