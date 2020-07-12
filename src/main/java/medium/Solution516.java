package medium;

public class Solution516 {
    /**
     * 516. 最长回文子序列
     * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
     *
     *
     *
     * 示例 1:
     * 输入:
     *
     * "bbbab"
     * 输出:
     *
     * 4
     * 一个可能的最长回文子序列为 "bbbb"。
     *
     * 示例 2:
     * 输入:
     *
     * "cbbd"
     * 输出:
     *
     * 2
     * 一个可能的最长回文子序列为 "bb"。
     *
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 1000
     * s 只包含小写英文字母
     */

    public int longestPalindromeSubseq(String s) {
        int m = s.length();
        int[][] dp = new int[m][m];
        for (int i=0; i<m; i++) {
            dp[i][i] = 1;
        }
        for (int i=m-1; i>=0; i--) {
            for (int j=i+1; j<m; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][m-1];

    }

    public static void main(String[] args) {
        String s1 = "bbbab";
        String s2 = "cbbd";

        Solution516 s = new Solution516();
        System.out.println(s.longestPalindromeSubseq(s1)); //4
        System.out.println(s.longestPalindromeSubseq(s2)); //2
    }
}
