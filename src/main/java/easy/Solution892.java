package easy;

public class Solution892 {
    public static int surfaceArea(int[][] grid) {
        int N = grid.length;
        int surface = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                //前
                surface += i-1>=0? Math.max(grid[i][j]-grid[i-1][j], 0):grid[i][j];
                //后
                surface += i+1<N? Math.max(grid[i][j]-grid[i+1][j], 0):grid[i][j];
                //左边
                surface += j-1>=0? Math.max(grid[i][j]-grid[i][j-1], 0):grid[i][j];
                //右边
                surface += j+1<N? Math.max(grid[i][j]-grid[i][j+1], 0):grid[i][j];

                //上下
                surface += grid[i][j]>0? 2:0;
            }
        }
        return surface;
    }

    public static void main(String[] args) {
        int[][] grid1 = {{2}};
        int[][] grid2 = {{1,2},{3,4}};
        int[][] grid3 = {{1,0},{0,2}};
        int[][] grid4 = {{1,1,1}, {1,0,1}, {1,1,1}};
        int[][] grid5 = {{2,2,2}, {2,1,2}, {2,2,2}};

        System.out.println(Solution892.surfaceArea(grid1)); //10
        System.out.println(Solution892.surfaceArea(grid2)); //34
        System.out.println(Solution892.surfaceArea(grid3)); //16
        System.out.println(Solution892.surfaceArea(grid4)); //32
        System.out.println(Solution892.surfaceArea(grid5)); //46


    }
}
