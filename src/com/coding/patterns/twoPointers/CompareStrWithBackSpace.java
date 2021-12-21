package com.coding.patterns.twoPointers;

public class CompareStrWithBackSpace {
    public static boolean compare(String str1, String str2) {
        int index1 = str1.length() - 1;
        int index2 = str2.length() - 1;

        while (index1 >= 0 || index2 >= 0) {
            int validIndex1 = getValidCharIndex(str1, index1);
            int validIndex2 = getValidCharIndex(str2, index2);

            if (validIndex1 < 0 && validIndex2 < 0) {
                return true;
            }
            if (validIndex1 < 0 || validIndex2 < 0) {
                return false;
            }
            if (str1.charAt(validIndex1) != str2.charAt(validIndex2)) {
                return false;
            }
            index1 = validIndex1 - 1;
            index2 = validIndex2 - 1;
        }
        return true;
    }

    private static int getValidCharIndex(String str, int index) {
        int backSpaceCount = 0;
        while (index >= 0) {
            if(str.charAt(index) == '#') {
                backSpaceCount++;
            }
            else if (backSpaceCount > 0) {
                backSpaceCount--;
            }
            // when it is a valid character
            else {
                break;
            }
            index--;
        }
        return index;
    }
}
