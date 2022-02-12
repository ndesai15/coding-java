package com.algoexpert.Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * AlgoExpert Problem: https://www.algoexpert.io/questions/Lowest%20Common%20Manager
 */

// Time Complexity: O(N)
// Space Complexity: O(d), d is the depth of the recursion
class OrgChart {
    public char name;
    public List<OrgChart> directReports;

    public OrgChart(char name) {
        this.name = name;
        this.directReports = new ArrayList<OrgChart>();
    }
    // This method is for testing only.
    public void addDirectReports(OrgChart[] directReports) {
        for (OrgChart directReport : directReports) {
            this.directReports.add(directReport);
        }
    }
}
class OrgInfo {
    public OrgChart lowestCommonManager;
    int numImportantReports;

    public OrgInfo(OrgChart lowestCommonManager, int numImportantReports) {
        this.lowestCommonManager = lowestCommonManager;
        this.numImportantReports = numImportantReports;
    }
}
public class LowestCommonManager {
    private static OrgInfo getOrgInfo(OrgChart manager, OrgChart reportOne, OrgChart reportTwo) {
        int numImportantReports = 0;
        for (OrgChart report: manager.directReports) {
            OrgInfo orgInfo = getOrgInfo(report, reportOne, reportTwo);
            if (orgInfo.lowestCommonManager != null) {
                return orgInfo;
            }
            numImportantReports += orgInfo.numImportantReports;
        }

        if (manager == reportOne || manager == reportTwo) {
            numImportantReports++;
        }

        OrgChart lowestCommonManager = numImportantReports == 2 ? manager : null;
        return new OrgInfo(lowestCommonManager, numImportantReports);
    }
    public static OrgChart getLowestCommonManager(OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        return getOrgInfo(topManager, reportOne, reportOne).lowestCommonManager;
    }
}
