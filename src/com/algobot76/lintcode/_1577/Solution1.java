package com.algobot76.lintcode._1577;

import com.algobot76.lintcode.util.TreeNode;

public class Solution1 {
    /**
     * @param root:
     * @return: the sum of leafnode
     */
    public int sumLeafNode(TreeNode root) {
        int sum = 0;

        if (root == null) {
            return sum;
        }

        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null && curr.right == null) {
                sum += curr.val;
            }
            if (curr.left == null) {
                curr = curr.right;
            } else {
                TreeNode temp = curr.left;
                while (temp.right != null && temp.right != curr) {
                    temp = temp.right;
                }
                if (temp.left == null && temp.right == null) {
                    sum += temp.val;
                }
                if (temp.right == null) {
                    temp.right = curr;
                    curr = curr.left;
                } else {
                    temp.right = null;
                    curr = curr.right;
                }
            }
        }

        return sum;
    }
}
