package medium;

import java.util.Arrays;

public class Solution62 {
    /*
    62. 不同路径
    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

    问总共有多少条不同的路径？
     */

    public int uniquePaths(int m, int n) {
        //动态规划
        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        for (int i=1; i<m; i++) {
            dp[i][0] = 1;
        }
        for (int j=1; j<n; j++) {
            dp[0][j] = 1;
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];

    }


    public int uniquePaths2(int m, int n) {
        //动态规划
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];

    }


    public static void main(String[] args) {
        Solution62 s = new Solution62();
        System.out.println(s.uniquePaths2(3,2)); //3
        System.out.println(s.uniquePaths2(7,3)); //28
    }
}
