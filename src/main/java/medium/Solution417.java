package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution417 {
    /*
    417. 太平洋大西洋水流问题
    给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
    规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
    请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。

    提示：
    输出坐标的顺序不重要
    m 和 n 都小于150
    示例：
    给定下面的 5x5 矩阵:
      太平洋 ~   ~   ~   ~   ~
           ~  1   2   2   3  (5) *
           ~  3   2   3  (4) (4) *
           ~  2   4  (5)  3   1  *
           ~ (6) (7)  1   4   5  *
           ~ (5)  1   1   2   4  *
              *   *   *   *   * 大西洋
    返回:
    [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
     */
    private int m,n;
    private int[][] direction = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    private boolean in_area(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (matrix == null || matrix.length == 0) {
            return ans;
        }

        m = matrix.length;
        n = matrix[0].length;
        int[][] po = new int[m][n]; //太平洋
        int[][] ao = new int[m][n]; //

        for (int i=0; i<n; i++) {
            dfs(matrix, 0, i, po);
            dfs(matrix, m-1, i, ao);
        }
        for (int i=0; i<m; i++) {
            dfs(matrix, i, 0, po);
            dfs(matrix, i, n-1, ao);
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (po[i][j] == 1 && ao[i][j] == 1) {
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }

    public void dfs(int[][] matrix, int x, int y, int[][] oc) {
        oc[x][y] = 1;
        for (int[] d : direction) {
            int xx = x + d[0];
            int yy = y + d[1];
            if (!in_area(xx,yy) || matrix[x][y] > matrix[xx][yy] || oc[xx][yy] == 1) {
                continue;
            }
            dfs(matrix, xx, yy, oc);
        }
    }

    public static void main(String[] args) {
        Solution417 s = new Solution417();
        System.out.println(s.pacificAtlantic(new int[][] {{1,2,2,3,5}, {3,2,3,4,4}, {2,4,5,3,1}, {6,7,1,4,5}, {5,1,1,2,4}}));
    }
}
