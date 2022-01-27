package easy;

public class PRO200 {
    public int numIslands(char[][] grid) {
        int res = 0;
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == '1') {
                    IsLands(grid, n, m, i, j);
                    res++;
                }
            }
        }
        return res;

    }

    public void IsLands(char[][] grid, int n, int m, int i, int j) {
        if (i<0 || i>=n || j<0 || j>=m || grid[i][j]!='1') {
            return;
        }
        grid[i][j] = '0';
        IsLands(grid, n, m, i-1, j);
        IsLands(grid, n, m, i, j-1);
        IsLands(grid, n, m, i+1, j);
        IsLands(grid, n, m, i, j+1);
    }

    public static void main(String[] args) {
        PRO200 p = new PRO200();
        System.out.println(p.numIslands(new char[][] {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        }));
        System.out.println(p.numIslands(new char[][] {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        }));
    }
}
