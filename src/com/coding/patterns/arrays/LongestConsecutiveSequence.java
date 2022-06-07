package com.coding.patterns.arrays;

import java.util.HashMap;

/**
 * LeetCode problem: https://leetcode.com/problems/longest-consecutive-sequence/
 */
// Time Complexity: O(N)
// Space Complexity: O(N)
public int longestConsecutive(int[] nums) {
        
        // Initialize a variable to keep track of
        // the maximum length of the subsequence.
        //
        // We are initializing it as 0 so that it
        // will be returned in case of an empty array.
        int maxSequenceLength = 0;
        
        // Create a HashSet and copy all the elements 
        // from the array to that HashSet.
        //
        // This is done so that we can fetch any elment
        // in the HashSet in O(1) time.
        //
        // Also, this HashSet occupies O(N) space, which
        // is the only contributing factor to the size
        // complexity of this problem.
        Set<Integer> numsSet = new HashSet();
        for(int num: nums) {
            numsSet.add(num);
        }
        
        // The upcoming iteration takes O(n) time,
        // which is the only contributing factor
        // to the time complexity of this problem
        for(int num: numsSet) {
            
            // First check if there is a left element.
            //
            // A left element is simply 1 less than the
            // current number.
            if(numsSet.contains(num - 1)) {
                
                // If the left element is present in the array,
                // it means that this element is not the
                // start of the sequence.
                //
                // So we ignore the current element and
                // continue with the next item in the Set.
                continue;
            }
            
            // If we reach this point, it means that we have
            // found the start of a sequence. We are going to
            // calculate the length of this sequence below.
            
            // Initialize a temporary variable to compute
            // the length of the current sequence.
            int tempSequenceLength = 1;
            
            // Until the sequence exists, keep incrementing the
            // temp counter.
            //
            // We detect if the sequence exists by simply checking
            // whether the next number is present in our HashSet.
            //
            // We are using a pre-increment operator because we need the
            // first iteration itself to check if the next item is present
            // in the Set.
            while(numsSet.contains(++num)) {
                tempSequenceLength++;
            }
            
            // Now check if the tempMaxLength is greater
            // than the actual maxLength and update it
            // accordingly.
            if(tempSequenceLength > maxSequenceLength) {
                maxSequenceLength = tempSequenceLength;
            }
        }
        return maxSequenceLength;
    }
}
