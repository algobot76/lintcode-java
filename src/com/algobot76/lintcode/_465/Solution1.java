package com.algobot76.lintcode._465;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Priority Queue
 */
public class Solution1 {
    /**
     * @param A: an integer arrays sorted in ascending order
     * @param B: an integer arrays sorted in ascending order
     * @param k: An integer
     * @return: An integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // write your code here
        int[] l1 = A.length <= B.length ? A : B;
        int[] l2 = A.length <= B.length ? B : A;
        int n = l1.length;
        int m = l2.length;

        Queue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(o -> (l1[o.i] + l2[o.j])));

        for (int i = 0; i < n; i++) {
            pq.offer(new Pair(i, 0));
        }
        for (int i = 0; i < k - 1; i++) {
            Pair top = pq.poll();
            if (top.j < m - 1) {
                top.j++;
                pq.offer(top);
            }
        }

        Pair ans = pq.poll();
        return l1[ans.i] + l2[ans.j];
    }

    class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}