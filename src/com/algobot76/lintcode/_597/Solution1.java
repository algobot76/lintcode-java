package com.algobot76.lintcode._597;

import com.algobot76.lintcode.util.TreeNode;

public class Solution1 {
    private TreeNode res = null;
    private double maxAvg = (double) Integer.MIN_VALUE;

    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    public TreeNode findSubtree2(TreeNode root) {
        helper(root, 0, 0);
        return res;
    }

    private int[] helper(TreeNode node, int sum, int size) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] resL = helper(node.left, sum, size);
        int[] resR = helper(node.right, sum, size);
        int currSum = resL[0] + resR[0] + node.val;
        int currSize = resL[1] + resR[1] + 1;
        double avg = ((double) currSum) / currSize;
        if (avg > maxAvg) {
            maxAvg = avg;
            res = node;
        }
        return new int[]{currSum, currSize};
    }
}
