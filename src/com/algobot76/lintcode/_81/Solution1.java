package com.algobot76.lintcode._81;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Priority Queue
 */
public class Solution1 {
    /**
     * @param nums: A list of integers
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        int n = nums.length;
        int[] ans = new int[n];
        int count = 0;
        Queue<Integer> maxHeap = new PriorityQueue<>(n, Collections.reverseOrder());
        Queue<Integer> minHeap = new PriorityQueue<>(n);

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            maxHeap.offer(num);
            if (count % 2 == 0) {
                if (minHeap.isEmpty()) {
                    count++;
                    ans[i] = maxHeap.peek();
                    continue;
                } else if (maxHeap.peek() > minHeap.peek()) {
                    int maxHeapRoot = maxHeap.poll();
                    int minHeapRoot = minHeap.poll();
                    maxHeap.offer(minHeapRoot);
                    minHeap.offer(maxHeapRoot);
                }
            } else {
                minHeap.offer(maxHeap.poll());
            }
            count++;
            ans[i] = maxHeap.peek();
        }

        return ans;
    }
}
