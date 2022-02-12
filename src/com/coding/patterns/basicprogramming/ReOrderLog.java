package com.coding.patterns.basicprogramming;

import java.util.Arrays;
import java.util.Comparator;

// Time Complexity: O(M * N log N), N is # of logs & M is the max length of a String
// Space Complexity: O(M + M logN) = O(M), M is the space to hold parsed log, logN is space require for sort for one string
// so for M string, it holds M * logN space
public class ReOrderLog {
    public String[] reorderLogFiles(String[] logs) {
        // Time Complexity: O(M * N logN), M is the max length of a single log, N is the number of logs in list
        //
        Comparator<String> myComp = new Comparator<String>() {
            public int compare(String log1, String log2) {
                // Split each log into two parts: <identifier, content>
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));

                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

                // case 1 - Both logs are letter logs
                if (!isDigit1 && !isDigit2) {
                    // let's compare content
                    int cmp = split1[1].compareTo(split2[1]);

                    if (cmp != 0) {
                        return cmp;
                    }

                    // logs of same content, compare the identifiers
                    return split1[0].compareTo(split2[0]);
                }

                // case 2 - one of log is digit-log
                if (!isDigit1 && isDigit2) {
                    return -1;
                }
                else if (isDigit1 && !isDigit2) {
                    return 1;
                }
                else {
                    return 0;
                }

            }
        };
        Arrays.sort(logs, myComp);
        return logs;
    }
}
