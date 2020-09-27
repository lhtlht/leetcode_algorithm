package medium;

public class Solution1254 {
    /*
    1254. 统计封闭岛屿的数目
    有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。

    我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。

    如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。

    请返回封闭岛屿的数目。
     */

    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m <= 1 || n <= 1) return 0;
        int count = 0;
        for (int i=1; i<m-1; i++) {
            for (int j=1; j<n-1; j++) {
                if (grid[i][j] == 0) {
                    if (isSurround(grid, m, n, i, j)) count++;
                }

            }
        }
        return count;
    }

    public boolean isSurround(int[][] grid, int m, int n, int i, int j) {
        if (i<0 || i>m-1 || j<0 || j>n-1) {
            return false;
        }
        if (grid[i][j] == 1 || grid[i][j] == 2) {
            return true;
        }
        grid[i][j] = 2;
        boolean a1 = isSurround(grid, m, n, i-1, j);
        boolean a2 = isSurround(grid, m, n, i+1, j);
        boolean a3 = isSurround(grid, m, n, i, j-1);
        boolean a4 = isSurround(grid, m, n, i, j+1);


        return a1 && a2 && a3 && a4;
    }


    public static void main(String[] args) {
        Solution1254 s = new Solution1254();
        System.out.println(s.closedIsland(new int[][] {{1,1,1,1,1,1,1,0}, {1,0,0,0,0,1,1,0}, {1,0,1,0,1,1,1,0}, {1,0,0,0,0,1,0,1}, {1,1,1,1,1,1,1,0}}));
        System.out.println(s.closedIsland(new int[][] {{0,0,1,0,0}, {0,1,0,1,0}, {0,1,1,1,0}}));
    }
}
