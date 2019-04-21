package com.algobot76.lintcode._461;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Priority Queue
 */
public class Solution2 {
    /**
     * @param k:    An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            if (queue.size() >= k) {
                if (nums[i] < queue.peek()) {
                    queue.poll();
                    queue.offer(nums[i]);
                }
            } else {
                queue.offer(nums[i]);
            }
        }

        return queue.poll();
    }
}
