package com.algobot76.lintcode._64;

/**
 * Two Pointers
 */
public class Solution1 {
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int[] aCopy = new int[A.length];
        System.arraycopy(A, 0, aCopy, 0, A.length);

        int p = 0;
        int p1 = 0;
        int p2 = 0;
        while (p1 < m && p2 < n) {
            A[p++] = (aCopy[p1] < B[p2]) ? aCopy[p1++] : B[p2++];
        }
        if (p1 < m) {
            System.arraycopy(aCopy, p1, A, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(B, p2, A, p1 + p2, m + n - p1 - p2);
        }
    }
}
