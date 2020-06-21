package hard;

public class Solution10 {
    /**
     * 10. 正则表达式匹配
     给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     '.' 匹配任意单个字符
     '*' 匹配零个或多个前面的那一个元素
     所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

     说明:
     s 可能为空，且只包含从 a-z 的小写字母。
     p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
     */

    public static boolean isMatch(String s, String p) {
        //异常情况判断
        if (s==null || p==null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1]; //初始化全部为false
        dp[0][0] = true;
        for (int i=0; i<p.length(); i++) {  //第一个for循环是初始化二维表格的第一行，以第一行为基础再将第2到n行表格填满，最后一个格子内的数据就是答案
            if (p.charAt(i)=='*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }

        for (int i=0; i<s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {  //如果是任意元素或者是对应元素匹配
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {//如果前一个元素不匹配 且不为任意元素
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }


                }
            }


        }

        return dp[s.length()][p.length()];
    }


    public static void main(String[] args) {
        String s1 = "aa", p1 = "a";
        String s2 = "aa", p2 = "a*";
        String s3 = "ab", p3 = ".*";
        String s4 = "aab", p4 = "c*a*b";
        String s5 = "mississippi", p5 = "mis*is*p*.";

        System.out.println(Solution10.isMatch(s1,p1)); //false
        System.out.println(Solution10.isMatch(s2,p2));//true
        System.out.println(Solution10.isMatch(s3,p3));//true
        System.out.println(Solution10.isMatch(s4,p4));//true
        System.out.println(Solution10.isMatch(s5,p5));//false


    }
}
