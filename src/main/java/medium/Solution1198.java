package medium;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1198 {
    /*
    1198. 找出所有行中最小公共元素
    给你一个矩阵 mat，其中每一行的元素都已经按 递增 顺序排好了。请你帮忙找出在所有这些行中 最小的公共元素。
    如果矩阵中没有这样的公共元素，就请返回 -1。

    示例：
    输入：mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
    输出：5

    提示：
    1 <= mat.length, mat[i].length <= 500
    1 <= mat[i][j] <= 10^4
    mat[i] 已按递增顺序排列。
     */

    public int smallestCommonElement(int[][] mat) {
        int m = mat.length;
        if (m == 1) {
            return mat[0][0];
        }
        int n = mat[0].length;

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i=0; i<n; i++) {
            queue.add(mat[0][i]);
        }
        for (int i=1; i<m; i++) {
            int size = queue.size();
            while (size > 0 && !queue.isEmpty()) {
                int tmp = queue.poll();

                size--;
            }


        }

        return 0;
    }

    public static void main(String[] args) {
        Solution1198 s = new Solution1198();
        System.out.println(s.smallestCommonElement(new int[][] {{1,2,3,4,5}, {2,4,5,8,10}, {3,5,7,9,11}, {1,3,5,7,9}}));
    }
}
