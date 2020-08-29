package medium;

import java.util.LinkedList;
import java.util.Queue;

public class Solution323 {
    /*
    323. 无向图中连通分量的数目
    给定编号从 0 到 n-1 的 n 个节点和一个无向边列表（每条边都是一对节点），请编写一个函数来计算无向图中连通分量的数目。

    示例 1:

    输入: n = 5 和 edges = [[0, 1], [1, 2], [3, 4]]

         0          3
         |          |
         1 --- 2    4

    输出: 2
    示例 2:

    输入: n = 5 和 edges = [[0, 1], [1, 2], [2, 3], [3, 4]]

         0           4
         |           |
         1 --- 2 --- 3

    输出:  1
     */
    public int countComponents(int n, int[][] edges) {
        int[][] graph = new int[n][n];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }

        int count = 0;
        boolean[] visted = new boolean[n];
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int j=0; j<n; j++) {
            if (!visted[j]) {
                count++;
                queue.add(j);
            }
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                for (int i=0; i<n; i++) {
                    if (graph[curr][i] == 1) {
                        queue.add(i);
                        visted[i] = true;
                        graph[curr][i] = 0;
                        graph[i][curr] = 0;
                    }
                }
            }
        }



        return count;
    }

    public static void main(String[] args) {
        Solution323 s = new Solution323();
        System.out.println(s.countComponents(5, new int[][] {{0,1}, {1,2}, {3,4}})); //2
        System.out.println(s.countComponents(5, new int[][] {{0,1}, {1,2}, {2,3}, {3,4}})); //1
    }
}
