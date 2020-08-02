package medium;

import java.util.*;

public class Solution210 {
    /*
    210. 课程表 II
    现在你总共有 n 门课需要选，记为 0 到 n-1。

    在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]

    给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。

    可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。

    示例 1:

    输入: 2, [[1,0]]
    输出: [0,1]
    解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
    示例 2:

    输入: 4, [[1,0],[2,0],[3,1],[3,2]]
    输出: [0,1,2,3] or [0,2,1,3]
    解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
         因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
    说明:

    输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
    你可以假定输入的先决条件中没有重复的边。
    提示:

    这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
    通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
    拓扑排序也可以通过 BFS 完成。
     */

    List<List<Integer>> graph = new ArrayList<List<Integer>>(); //存储图
    int[] visited; //存储图节点的搜索状态，0=未搜索，1=搜索汇中，2=已完成搜索
    boolean invalid = false;
    int[] res;; //存储栈
    int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //构图
        for (int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int[] course : prerequisites) {
            int src = course[1];
            int dest = course[0];
            graph.get(src).add(dest);
        }
        visited = new int[numCourses];
        res = new int[numCourses];
        index = numCourses-1;
        for (int i=0; i<numCourses; i++) {
            if (invalid) {
                return new int[0];
            }
            if (visited[i] == 0) {
                dfs(i);
            }
        }

        if (invalid) {
            return new int[0];
        }
        return res;
    }


    public void dfs(int i) {
        visited[i] = 1;
        for (int ep : graph.get(i)) {
            if (visited[ep] == 0) {
                dfs(ep);
                if (invalid) {
                    return;
                }
            }
            //搜索中找到了环
            if (visited[ep] == 1) {
                invalid = true;
                return;
            }
        }
        visited[i] = 2;
        res[index] = i;
        index--;
    }


    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        //bfs
        List<List<Integer>> graph = new ArrayList<List<Integer>>(); //存储图
        int[] indeg = new int[numCourses]; //存储图节点的入度

        for (int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int[] course : prerequisites) {
            int src = course[1];
            int dest = course[0];
            graph.get(src).add(dest);
            indeg[dest]++;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        int[] res = new int[numCourses];
        int index = 0;
        //初始入度为0的节点
        for (int i = 0; i<numCourses; i++) {
            if (indeg[i] == 0) {
                queue.add(i);
            }
        }

        while (queue.size() > 0) {
            int curr = queue.poll();
            for (int ed : graph.get(curr)) {
                if (indeg[ed] == 1) {
                    queue.add(ed);
                }
                indeg[ed]--;
            }

            res[index] = curr;
            index++;
        }

        if (index != numCourses) {
            return new int[0];
        }
        return res;

    }
    public static void main(String[] args) {
        Solution210 s = new Solution210();
//        int[][] cour1 = {{1,0}};
//        int[] res1 = s.findOrder(2, cour1);
//        for (int i : res1) {
//            System.out.print(i + " ");
//        }
//        System.out.println();

        int[][] cour2 = {{1,0}, {2,0}, {3,1}, {3,2}};
        int[] res2 = s.findOrder2(4, cour2);
        for (int i : res2) {
            System.out.print(i + " ");
        }
        System.out.println();


    }
}
