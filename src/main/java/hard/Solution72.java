package hard;

public class Solution72 {
    /**
     * 72. 编辑距离
     * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
     *
     * 你可以对一个单词进行如下三种操作：
     *
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     *
     *
     * 示例 1：
     *
     * 输入：word1 = "horse", word2 = "ros"
     * 输出：3
     * 解释：
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     * 示例 2：
     *
     * 输入：word1 = "intention", word2 = "execution"
     * 输出：5
     * 解释：
     * intention -> inention (删除 't')
     * inention -> enention (将 'i' 替换为 'e')
     * enention -> exention (将 'n' 替换为 'x')
     * exention -> exection (将 'n' 替换为 'c')
     * exection -> execution (插入 'u')
     *
     */

    public int minDistance(String word1, String word2) {
        return dp(word1, word2, word1.length()-1, word2.length()-1);
    }

    public int dp(String word1, String word2, int i, int j) {
        //base case 是 i ⾛完 s1 或 j ⾛完 s2 ，可以直接返回另⼀个字符串剩下的⻓度
        if (i == -1) return j + 1;
        if (j == -1) return i + 1;
        if (word1.charAt(i) == word2.charAt(j)) {
            return dp(word1, word2, i-1, j-1);
        } else {
            int deleteO = dp(word1, word2, i-1, j) + 1; //删除操作
            int insertO = dp(word1, word2, i, j-1); //插入操作
            int replaceP = dp(word1, word2, i-1, j-1) + 1; //替换操作
            return Math.min(Math.min(deleteO,insertO), replaceP);
        }

    }

    public int minDistance2(String word1, String word2) {
        //动态规划解法
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        //base case
        for (int i=1; i<=m; i++) {
            dp[i][0] = i;
        }
        for (int i=1; i<=n; i++) {
            dp[0][i] = i;
        }

        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1]+1, dp[i-1][j]+1),dp[i][j-1]+1);
                }
            }
        }
        return dp[m][n];
    }

    public int minDistance3(String word1, String word2) {
        //动态规划解法 压缩空间
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        //base case
        for (int i=1; i<=m; i++) {
            dp[i][0] = i;
        }
        for (int i=1; i<=n; i++) {
            dp[0][i] = i;
        }

        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1]+1, dp[i-1][j]+1),dp[i][j-1]+1);
                }
            }
        }
        return dp[m][n];
    }


    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";

        Solution72 s = new Solution72();
        System.out.println(s.minDistance(word1, word2)); //3
        System.out.println(s.minDistance2(word1, word2)); //3
        System.out.println(s.minDistance3(word1, word2)); //3

    }
}
