package com.algobot76.lintcode._591;

/**
 * Union Find
 */
public class ConnectingGraph3 {
    private int[] parents;
    private int count;

    /*
     * @param n: An integer
     */
    public ConnectingGraph3(int n) {
        parents = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    /**
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA != parentB) {
            parents[parentA] = parentB;
            count--;
        }
    }

    /**
     * @return: An integer
     */
    public int query() {
        return count;
    }

    private int find(int x) {
        x--;
        int p = x;

        while (parents[p] != p) {
            p = parents[p];
        }
        while (x != p) {
            int temp = parents[x];
            parents[x] = p;
            x = temp;
        }

        return p;
    }
}