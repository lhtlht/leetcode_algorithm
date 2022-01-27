package medium;

import java.util.Arrays;

public class Solution547 {
    /*
    547. 朋友圈
    班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。

    给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
     */
    public int findCircleNum(int[][] M) {
        int n = M.length;
        if (n == 1) {
            return 1;
        }
        int[] friends = new int[n];
        int count = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (M[i][j] == 1) {
                    dfs(i, j, M, n);
                    count++;
                }

            }
        }
        return count;
    }

    public void dfs(int i, int j, int[][] M, int n) {
        /*
        i为行，j为列
         */
        M[i][j] = 2;
        for (int k=0; k<n; k++) {
            if (M[i][k] == 1) {
                M[i][k] = 2;
                dfs(k, i, M, n);
            }
        }
    }

    public int findCircleNum2(int[][] M) {
        //并查集
        int n = M.length;
        int[] parents = new int[n];
        Arrays.fill(parents, -1);

        //构造并查集
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(parents, i, j);
                }
            }
        }

        //从并查集查找
        int count = 0;
        for (int i=0; i<n; i++) {
            if (parents[i] == -1) {
                count++;
            }
        }
        return count;

    }

    public void union(int[] parents, int i, int j) {
        int x = find(parents, i);
        int y = find(parents, j);
        if (x != y) {
            parents[x] = y; //x的根节点是y
        }
    }

    public int find(int[] parents, int i) {
        if (parents[i] == -1) {
            return -1;
        }
        return find(parents, parents[i]);
    }
    public static void main(String[] args) {
        Solution547 s = new Solution547();
        System.out.println(s.findCircleNum(new int[][] {{1,1,0}, {1,1,0}, {0,0,1}})); //2
        System.out.println(s.findCircleNum(new int[][] {{1,1,0}, {1,1,1}, {0,1,1}})); //1
    }
}
