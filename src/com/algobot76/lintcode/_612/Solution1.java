package com.algobot76.lintcode._612;

import com.algobot76.lintcode.util.Point;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Definition for a point.
 * class Point {
 * int x;
 * int y;
 * Point() { x = 0; y = 0; }
 * Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution1 {
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k:      An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        Queue<Point> pq = new PriorityQueue<>((a, b) -> {
            int diff = getDistance(b, origin) - getDistance(a, origin);
            if (diff == 0) {
                diff = b.x - a.x;
            }
            if (diff == 0) {
                diff = b.y - a.y;
            }
            return diff;
        });
        for (Point point : points) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int size = pq.size();
        Point[] ans = new Point[size];
        while (!pq.isEmpty()) {
            ans[--size] = pq.poll();
        }

        return ans;
    }

    private int getDistance(Point point, Point origin) {
        return (point.x - origin.x) * (point.x - origin.x) + (point.y - origin.y) * (point.y - origin.y);
    }
}