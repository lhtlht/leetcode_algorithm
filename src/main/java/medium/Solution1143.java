package medium;

public class Solution1143 {
    /**
     * 1143. 最长公共子序列
     * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
     *
     * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
     * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
     *
     * 若这两个字符串没有公共子序列，则返回 0。
     *
     *
     *
     * 示例 1:
     *
     * 输入：text1 = "abcde", text2 = "ace"
     * 输出：3
     * 解释：最长公共子序列是 "ace"，它的长度为 3。
     * 示例 2:
     *
     * 输入：text1 = "abc", text2 = "abc"
     * 输出：3
     * 解释：最长公共子序列是 "abc"，它的长度为 3。
     * 示例 3:
     *
     * 输入：text1 = "abc", text2 = "def"
     * 输出：0
     * 解释：两个字符串没有公共子序列，返回 0。
     */

    public int longestCommonSubsequence(String text1, String text2) {
        //递归解法
        return dp(text1, text2, text1.length()-1, text2.length()-1);
    }

    public int dp(String text1, String text2, int i, int j) {
        if (i == -1 || j == -1) {
            return 0;
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return dp(text1, text2, i-1, j-1) + 1;
        } else {
            return Math.max(dp(text1, text2, i-1, j),dp(text1, text2, i, j-1));
        }

    }


    public int longestCommonSubsequence2(String text1, String text2) {
        //动态规划解法
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for (int i=1; i<=text1.length(); i++) {
            for (int j=1; j<=text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }


    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        String text11 = "abc";
        String text22 = "abc";

        String text111 = "abc";
        String text222 = "def";


        Solution1143 s = new Solution1143();
        System.out.println(s.longestCommonSubsequence(text1, text2)); //3
        System.out.println(s.longestCommonSubsequence(text11, text22)); //3
        System.out.println(s.longestCommonSubsequence(text111, text222)); //0

        System.out.println(s.longestCommonSubsequence2(text1, text2)); //3
        System.out.println(s.longestCommonSubsequence2(text11, text22)); //3
        System.out.println(s.longestCommonSubsequence2(text111, text222)); //0
    }
}
