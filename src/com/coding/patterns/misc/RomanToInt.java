package com.coding.patterns.misc;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    /*
        Roman   ->  Int
          I          1
          V          5
          X         10
          L         50
          C        100
          D        500
          M       1000
     */

    // CMXCVIII = 998
    public int romanToInt(String str) {
        Map<Character, Integer> romanToIntMap = new HashMap<>();

        // Add all roman to int mapping
        romanToIntMap.put('I', 1);
        romanToIntMap.put('V', 5);
        romanToIntMap.put('X', 10);
        romanToIntMap.put('L', 50);
        romanToIntMap.put('C', 100);
        romanToIntMap.put('D', 500);
        romanToIntMap.put('M', 1000);

        // Iterate over String and check 2 adj characters
        // Largest -> smallest then positive value
        // Smallest -> largest then negative value

        int result = 0;
        char nextChar = '\0';
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (i < str.length() - 1) {
                nextChar = str.charAt(i + 1);
                if (romanToIntMap.get(nextChar) > romanToIntMap.get(currentChar)) {
                    result = result - romanToIntMap.get(currentChar);
                }
                else {
                    result = result + romanToIntMap.get(currentChar);
                }
            }
            else {
                result = result + romanToIntMap.get(currentChar);
            }
        }
        return result;
    }
}
