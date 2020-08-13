package jianzhi_offer;

import com.sun.scenario.effect.impl.state.LinearConvolveKernel;

import java.util.LinkedList;
import java.util.Queue;

public class Solution13 {
    /*
    剑指 Offer 13. 机器人的运动范围
    地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

    示例 1：
    输入：m = 2, n = 3, k = 1
    输出：3

    示例 2：
    输入：m = 3, n = 1, k = 0
    输出：1
    提示：

    1 <= n,m <= 100
    0 <= k <= 20
     */
    //int res = 0;
    public int movingCount(int m, int n, int k) {
        int[][] grid = new int[m][n];
        return dfs(grid, m, n, 0, 0, 0, 0, k);
    }

    public int dfs(int[][] grid, int m, int n, int i, int j, int si, int sj, int k) {
        //si sj 表示i和j的数位和
        if (i<0 || i>m-1 || j<0 || j>n-1 || grid[i][j] == 1) {
            return 0;
        }
        grid[i][j] = 1;
        if (si+sj <= k) {
            //dfs(grid, m, n, i-1, j, k); //忽略两个方向

            //dfs(grid, m, n, i, j-1, k);

            //计算新的数位和
            int newSi = (i+1)%10 == 0? si-8 : si+1;
            int newSj = (j+1)%10 == 0? sj-8 : sj+1;
            return dfs(grid, m, n, i, j+1, si, newSj, k) + dfs(grid, m, n, i+1, j, newSi, sj, k) + 1;
        } else {
            return 0;
        }

        //return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }

    public boolean gridSum(int i, int j, int k) {  //这个省掉时间
        int sum = 0;
        while (i > 0) {
            sum += (i%10);
            i /= 10;
        }
        while (j > 0) {
            sum += (j%10);
            j /= 10;
        }
        if (sum <= k) {
            return true;
        }
        return false;
    }


    public int movingCount2(int m, int n, int k) {
        //bfs
        int[][] grid = new int[m][n];
        int res = 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[] {0,0,0,0});
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int i = point[0];
            int j = point[1];
            int si = point[2];
            int sj = point[3];

            if (i<0 || i>m-1 || j<0 || j>n-1 || si+sj > k || grid[i][j] == 1) {
                continue;
            }
            grid[i][j] = 1;
            res++;
            //计算新的数位和
            int newSi = (i+1)%10 == 0? si-8 : si+1;
            int newSj = (j+1)%10 == 0? sj-8 : sj+1;
            queue.add(new int[] {i+1,j,newSi, sj});
            queue.add(new int[] {i, j+1,si, newSj });
            //queue.add(new int[] { i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj });
            //queue.add(new int[] { i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8 });


        }

        return res;
    }



    public static void main(String[] args) {
        Solution13 s = new Solution13();
        //System.out.println(s.movingCount(2,3,1)); //3
        //System.out.println(s.movingCount(3,1,0)); //1
        System.out.println(s.movingCount2(16,8,4)); //15
    }
}
