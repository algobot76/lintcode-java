package com.algobot76.lintcode._589;

/**
 * Union Find
 */
public class ConnectingGraph {
    private int[] parents;

    /*
     * @param n: An integer
     */
    public ConnectingGraph(int n) {
        // do intialization if necessary
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA != parentB) {
            parents[parentA] = parentB;
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: A boolean
     */
    public boolean query(int a, int b) {
        // write your code here
        return find(a) == find(b);
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
