package com.algobot76.lintcode._543;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Priority Queue
 */
public class Solution1 {
    /**
     * @param arrays: a list of array
     * @param k:      An integer
     * @return: an integer, K-th largest element in N arrays
     */
    public int KthInArrays(int[][] arrays, int k) {
        int n = arrays.length;

        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                pq.offer(arrays[i][j]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        return pq.poll();
    }
}
