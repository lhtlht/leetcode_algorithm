package easy;

public class PRO72 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for (int i=1; i<=n; i++) {
            dp[i][0] = i;
        }
        for (int j=1; j<=m; j++) {
            dp[0][j] = j;
        }
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        PRO72 p = new PRO72();
        System.out.println(p.minDistance("horse","ros")); //3
    }
}
