package com.algobot76.lintcode._465;

/**
 * Binary Search
 */
public class Solution2 {
    /**
     * @param A: an integer arrays sorted in ascending order
     * @param B: an integer arrays sorted in ascending order
     * @param k: An integer
     * @return: An integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        int m = A.length;
        int n = B.length;
        int low = A[0] + B[0];
        int high = A[m - 1] + B[n - 1];

        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (countLessOrEqual(A, B, mid) >= k) {
                high = mid;
            } else {
                low = mid;
            }
        }

        if (countLessOrEqual(A, B, low) >= k) {
            return low;
        }

        return high;
    }

    private int countLessOrEqual(int[] A, int[] B, int value) {
        int m = A.length;
        int n = B.length;
        int count = 0;

        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            if (A[i] + B[j] <= value) {
                count += j + 1;
                i++;
            } else {
                j--;
            }
        }

        return count;
    }
}