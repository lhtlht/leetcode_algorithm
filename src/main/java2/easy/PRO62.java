package easy;

public class PRO62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i=1; i<m; i++) {
            dp[i][0] = 1;
        }
        for(int i=1; i<n; i++) {
            dp[0][i] = 1;
        }
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                dp[i][j] = dp[i][j-1]+dp[i-1][j];
            }
        }
        return dp[m-1][n-1];

    }

    public static void main(String[] args) {
        PRO62 p = new PRO62();
        System.out.println(p.uniquePaths(3,7)); //28
        System.out.println(p.uniquePaths(3,2)); //3
    }
}
