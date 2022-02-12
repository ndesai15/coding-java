package com.algoexpert.BST;

public class ValidateBST {
    public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
        BST searchOne = nodeOne;
        BST searchTwo = nodeThree;

        while (true) {
            boolean foundThreeFromOne = searchOne == nodeThree;
            boolean foundOneFromThree = searchTwo == nodeOne;
            boolean foundNodeTwo = (searchOne == nodeTwo) || (searchTwo == nodeTwo);
            boolean finishedSearching = (searchOne == null) && (searchTwo == null);
            if (foundThreeFromOne || foundOneFromThree || foundNodeTwo || finishedSearching) {
                break;
            }
            if (searchOne != null) {
                searchOne = (searchOne.value > nodeTwo.value) ? searchOne.left : searchOne.right;
            }
            if (searchTwo != null) {
                searchTwo = (searchTwo.value > nodeTwo.value) ? searchTwo.left : searchTwo.right;
            }
        }

        boolean foundFromOther = (searchOne == nodeThree) || (searchTwo == nodeOne);
        boolean foundNodeTwo = (searchOne == nodeTwo) || (searchTwo == nodeTwo);

        if (foundFromOther && !foundNodeTwo) return false;
        return searchForTarget(nodeTwo, (searchOne == nodeTwo) ? nodeThree : nodeOne);
    }

    private boolean searchForTarget(BST node, BST target) {
        while (node != null && node != target) {
            node = node.value > target.value ? node.left : node.right;
        }
        return node == target;
    }
}
