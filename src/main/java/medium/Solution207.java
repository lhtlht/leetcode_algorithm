package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution207 {
    /*
    207. 课程表
你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。

在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]

给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
     */

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //bfs
        //存储图
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        //存储图的入度
        int[] inDegree = new int[numCourses];
        for (int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int[] course : prerequisites) {
            int src = course[1];
            int dest = course[0];
            graph.get(src).add(dest);
            inDegree[dest]++;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        int index = 0;
        //初始化入度为0的点
        for (int i=0; i<numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }


        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int ne : graph.get(curr)) {
                if (inDegree[ne] == 1) {
                    queue.add(ne);
                }
                inDegree[ne]--;
            }
            index++;
        }

        if (index != numCourses) {
            return false;
        } else {
            return true;
        }



    }
}
