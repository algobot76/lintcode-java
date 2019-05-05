package com.algobot76.lintcode._629;

import com.algobot76.lintcode.util.Connection;

import java.util.*;

/**
 * Union Find
 */
public class Solution1 {
    /**
     * @param connections given a list of connections include two cities and cost
     * @return a list of connections from results
     */
    public List<Connection> lowestCost(List<Connection> connections) {
        connections.sort((a, b) -> {
            if (a.cost != b.cost) {
                return a.cost - b.cost;
            }
            if (a.city1.equals(b.city1)) {
                return a.city2.compareTo(b.city2);
            }
            return a.city1.compareTo(b.city1);
        });
        Map<String, Integer> map = new HashMap<>();
        int n = 0;
        for (Connection conn : connections) {
            if (!map.containsKey(conn.city1)) {
                map.put(conn.city1, ++n);
            }
            if (!map.containsKey(conn.city2)) {
                map.put(conn.city2, ++n);
            }
        }
        int[] parents = new int[n + 1];
        List<Connection> ans = new ArrayList<>();
        for (Connection conn : connections) {
            int n1 = map.get(conn.city1);
            int n2 = map.get(conn.city2);
            int p1 = find(n1, parents);
            int p2 = find(n2, parents);
            if (p1 != p2) {
                parents[p1] = p2;
                ans.add(conn);
            }
        }
        if (ans.size() != n - 1) {
            return new ArrayList<>();
        }
        return ans;
    }

    private int find(int n, int[] parents) {
        if (parents[n] == 0) {
            return n;
        }
        return parents[n] = find(parents[n], parents);
    }
}
