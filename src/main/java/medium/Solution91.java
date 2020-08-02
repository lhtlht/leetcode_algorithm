package medium;

public class Solution91 {
    /*
    91. 解码方法
    一条包含字母 A-Z 的消息通过以下方式进行了编码：

    'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26
    给定一个只包含数字的非空字符串，请计算解码方法的总数。

    示例 1:

    输入: "12"
    输出: 2
    解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
    示例 2:

    输入: "226"
    输出: 3
    解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
     */

    public int numDecodings(String s) {
        //动态规划
        if (s.length() >= 1 && s.charAt(0) == '0') {
            return 0;
        }
        //1-26合法
        int len = s.length();
        int[] dp = new int[len+1];

        //base case
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<len+1; i++) {
            int curr = s.charAt(i-1)-'0';
            int pre = s.charAt(i-2)-'0';
            int p = pre*10+curr;
            if (p%10 == 0 && p != 10 && p != 20) {
                return 0;
            } else if (p == 10 || p == 20){
                dp[i] = dp[i-2];
            } else if (p > 26 || p <= 10) {
                dp[i] = dp[i-1];
            } else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        Solution91 s = new Solution91();
        System.out.println(s.numDecodings("12")); //2
        System.out.println(s.numDecodings("226")); //3
        System.out.println(s.numDecodings("10")); //1
        System.out.println(s.numDecodings("00")); //0
        System.out.println(s.numDecodings("100")); //0
        System.out.println(s.numDecodings("101")); //1
        System.out.println(s.numDecodings("230")); //0
    }
}
