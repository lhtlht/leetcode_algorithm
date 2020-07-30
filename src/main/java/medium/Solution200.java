package medium;

import java.util.LinkedList;
import java.util.Queue;

public class Solution200 {
    /*
    200. 岛屿数量
    给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

    岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。

    此外，你可以假设该网格的四条边均被水包围。



    示例 1:

    输入:
    [
    ['1','1','1','1','0'],
    ['1','1','0','1','0'],
    ['1','1','0','0','0'],
    ['0','0','0','0','0']
    ]
    输出: 1
    示例 2:

    输入:
    [
    ['1','1','0','0','0'],
    ['1','1','0','0','0'],
    ['0','0','1','0','0'],
    ['0','0','0','1','1']
    ]
    输出: 3
    解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
     */

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == '1') {
                    //dfs(grid, i, j);
                    bfs(grid, i, j);
                    count++;
                }

            }
        }

        return count;
    }

    public void dfs(char[][] grid, int x, int y) {
        if (!inArea(grid, x, y)) {
            return;
        }
        if (grid[x][y] == '0' || grid[x][y] == '2') {
            return;
        }
        grid[x][y] = '2';

        dfs(grid, x, y-1);
        dfs(grid, x, y+1);
        dfs(grid, x-1, y);
        dfs(grid, x+1, y);
    }

    public void bfs(char[][] grid, int x, int y) {
        Queue<int[]> list = new LinkedList<int[]>();
        list.add(new int[] {x,y});
        while (!list.isEmpty()) {
            int[] curr = list.remove();
            int i = curr[0];
            int j = curr[1];
            if (inArea(grid, i, j) && grid[i][j] == '1') {
                grid[i][j] = '2';
                list.add(new int[] {i-1,j});
                list.add(new int[] {i+1,j});
                list.add(new int[] {i,j-1});
                list.add(new int[] {i,j+1});
            }
        }

    }



    public boolean inArea(char[][] grid, int x, int y) {
        return x >=0 && x < grid.length && y >= 0 && y <grid[0].length;
    }

    public static void main(String[] args) {
        char[][] grid1 = {
                         {'1','1','1','1','0'},
                         {'1','1','0','1','0'},
                         {'1','1','0','0','0'},
                         {'0','0','0','0','0'}};
        char[][] grid2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};


        Solution200 s = new Solution200();
        System.out.println(s.numIslands(grid1)); // 1
        System.out.println(s.numIslands(grid2)); //3
    }
}
