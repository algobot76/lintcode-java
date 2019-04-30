package com.algobot76.lintcode._590;

/**
 * Union Find
 */
public class ConnectingGraph2 {
    private int[] parents;
    private int[] count;

    /*
     * @param n: An integer
     */
    public ConnectingGraph2(int n) {
        // do intialization if necessary
        parents = new int[n];
        count = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            count[i] = 1;
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        // write your code here
        int parentA = find(a);
        int parentB = find(b);
        if (parentA != parentB) {
            parents[parentA] = parentB;
            count[parentB] += count[parentA];
        }
    }

    /*
     * @param a: An integer
     * @return: An integer
     */
    public int query(int a) {
        // write your code here
        int parent = find(a);
        return count[parent];
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