package com.coding.patterns.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Job {
    int start;
    int end;
    int cpuLoad;

    public Job(int start, int end, int cpuLoad) {
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }
}

public class MaximumCPULoad {
    public static int findMaxCPULoad(List<Job> jobs) {
       int maxCPU = 0;
       Collections.sort(jobs, (a,b) -> Integer.compare(a.start, b.start));
       int i = 1;
       boolean secondOverlap = false;
       while (i < jobs.size()) {
           if (jobs.get(i - 1).end > jobs.get(i).start) {
               // overlap
               if (!secondOverlap) {
                   maxCPU = Math.max(maxCPU, jobs.get(i).cpuLoad + jobs.get(i - 1).cpuLoad);
                   secondOverlap = !secondOverlap;
               } else {
                   maxCPU = Math.max(maxCPU, jobs.get(i).cpuLoad + maxCPU);
               }
           }
           else {
               maxCPU = Math.max(maxCPU, jobs.get(i).cpuLoad);
           }
           i++;
       }
       return maxCPU;
    }

    public static void main(String[] args) {
        List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
    }
}
