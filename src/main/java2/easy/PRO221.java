package easy;

public class PRO221 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        int[][] dp = new int[m][n];
        for (int i=0; i<n; i++) { //遍历列
            if (matrix[0][i] == '0') {
                dp[0][i] = 0;
            } else {
                dp[0][i] = 1;
                res = Math.max(res, 1);
            }
        }

        for (int i=0; i<m; i++) { //遍历行
            if (matrix[i][0] == '0') {
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
                res = Math.max(res, 1);
            }
        }

        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    res = Math.max(res, dp[i][j]);
                }

            }
        }
        return res*res;



    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        PRO221 p = new PRO221();
        System.out.println(p.maximalSquare(matrix));
    }

}
