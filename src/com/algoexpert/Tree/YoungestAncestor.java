package com.algoexpert.Tree;


/**
 * AlgoExpert Problem:https://www.algoexpert.io/questions/Youngest%20Common%20Ancestor
 */
public class YoungestAncestor {
    private static int getDescendantDepth(AncestralTree descendant, AncestralTree topAncestor) {
        int depth = 0;
        while (descendant != topAncestor) {
            descendant = descendant.ancestor;
            depth++;
        }
        return depth;
    }
    private static AncestralTree backTrackAncestralTree(AncestralTree lowerDescendant, AncestralTree higherDescendant, int diff) {
        while(diff > 0) {
            lowerDescendant = lowerDescendant.ancestor;
            diff--;
        }
        while(lowerDescendant != higherDescendant) {
            lowerDescendant = lowerDescendant.ancestor;
            higherDescendant = higherDescendant.ancestor;
        }
        return lowerDescendant;
    }
    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        int depthOne = getDescendantDepth(descendantOne, topAncestor);
        int depthTwo = getDescendantDepth(descendantTwo, topAncestor);
        if (depthOne > depthTwo) {
            return backTrackAncestralTree(descendantOne, descendantTwo, depthOne - depthTwo);
        }
        else {
            return backTrackAncestralTree(descendantTwo, descendantOne,depthTwo - depthOne);
        }
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }
}
