package easy;

public class Solution463 {
    /*
    463. 岛屿的周长
    给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。

    网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。

    岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。



    示例 :

    输入:
    [[0,1,0,0],
     [1,1,1,0],
     [0,1,0,0],
     [1,1,0,0]]

    输出: 16
     */

    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    sum += sideLength(grid, m, n, i, j);
                }
            }
        }
        return sum;
    }

    public int sideLength(int[][] grid, int m, int n, int i, int j) {
        if (i < 0 || i > m-1 || j < 0 || j > n-1) {
            return 1;
        }
        if (grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] == 2) {
            return 0;
        }
        grid[i][j] = 2;
        int length = sideLength(grid, m, n, i-1, j) + sideLength(grid, m, n, i+1, j) + sideLength(grid, m, n, i, j-1) + sideLength(grid, m, n, i, j+1);
        return length;
    }
    public static void main(String[] args) {
        Solution463 s = new Solution463();
        System.out.println(s.islandPerimeter(new int[][] {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}})); //16
    }
}
