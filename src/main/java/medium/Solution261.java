package medium;

import java.util.LinkedList;
import java.util.Queue;

public class Solution261 {
    public boolean validTree(int n, int[][] edges) {
        int[][] graph = new int[n][n];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }

        boolean[] visted = new boolean[n];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            visted[curr] = true;
            for (int i=0; i<n; i++) {
                if (graph[curr][i] == 1) {
                    if (visted[i]) {
                        return false;
                    }
                    visted[i] = true;
                    queue.add(i);
                    graph[curr][i] = 0;
                    graph[i][curr] = 0;
                }
            }
        }

        //单连通分量
        for (int i=0; i<n; i++) {
            if (!visted[i]) {
                return false;
            }
        }
        return true;
    }


}
