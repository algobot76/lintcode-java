package com.algobot76.lintcode._1797;

public class Solution1 {
    /**
     * @param A: a integer sorted array
     * @param B: a integer sorted array
     * @param K: a integer
     * @return: return a pair of index
     */
    public int[] optimalUtilization(int[] A, int[] B, int K) {
        if (A.length == 0 || B.length == 0) {
            return new int[0];
        }

        int ansL = 0;
        int ansR = B.length - 1;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            for (int j = B.length - 1; j >= 0; j--) {
                int sum = A[i] + B[j];
                if (sum <= K) {
                    if (sum > maxSum) {
                        ansL = i;
                        ansR = j;
                        maxSum = sum;
                    } else if (sum == maxSum) {
                        if (i < ansL) {
                            ansL = i;
                            ansR = j;
                        } else if (i == ansL) {
                            ansR = j;
                        }
                    }
                }
            }
        }

        return new int[]{ansL, ansR};
    }
}
