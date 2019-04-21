package com.algobot76.lintcode._401;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Priority Queue
 */
public class Solution1 {
    /**
     * @param matrix: List[List[int]]
     * @param k:      a integer
     * @return: return a integer
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(o -> matrix[o.i][o.j]));

        for (int i = 0; i < m; i++) {
            pq.offer(new Pair(i, 0));
        }
        for (int i = 0; i < k - 1; i++) {
            Pair top = pq.poll();
            if (top.j + 1 < n) {
                top.j++;
                pq.offer(top);
            }
        }

        Pair ans = pq.poll();
        return matrix[ans.i][ans.j];
    }

    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
