package com.algobot76.lintcode._401;

/**
 * Two Pointers
 */
public class Solution2 {
    /**
     * @param matrix: a matrix of integers
     * @param k:      An integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        int m = matrix.length;
        int n = matrix[0].length;

        int left = matrix[0][0];
        int right = matrix[m - 1][n - 1];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (countLessOrEqual(matrix, mid) >= k) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (countLessOrEqual(matrix, left) >= k) {
            return left;
        }

        return right;
    }

    private int countLessOrEqual(int[][] matrix, int target) {
        int count = 0;

        for (int[] row : matrix) {
            int start = 0;
            int end = row.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (row[mid] > target) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
            if (row[start] > target) {
                count += start;
            } else if (row[end] > target) {
                count += end;
            } else {
                count += row.length;
            }
        }

        return count;
    }
}
