package com.algobot76.lintcode._613;

import com.algobot76.lintcode.util.Record;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution1 {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        Map<Integer, Double> ans = new HashMap<>();
        if (results == null || results.length == 0) {
            return ans;
        }

        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (Record record : results) {
            Queue<Integer> pq = map.getOrDefault(record.id, new PriorityQueue<>());
            pq.offer(record.score);
            if (pq.size() > 5) {
                pq.poll();
            }
            map.put(record.id, pq);
        }
        map.forEach((id, pq) -> {
            double avg = 0;
            while (!pq.isEmpty()) {
                avg += pq.poll();
            }
            avg /= 5;
            ans.put(id, avg);
        });

        return ans;
    }
}
