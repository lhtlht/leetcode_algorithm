package jianzhi_offer;

public class Solution49 {
    /*
    剑指 Offer 49. 丑数
    我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。



    示例:

    输入: n = 10
    输出: 12
    解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
    说明:

    1 是丑数。
    n 不超过1690。
     */

    public int nthUglyNumber(int n) {
        //动态规划
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0; //2
        int b = 0; //3
        int c = 0; //5
        for (int i=1; i<n; i++) {
            dp[i] = Math.min(Math.min(dp[a]*2, dp[b]*3), dp[c]*5);
            if (dp[i] == dp[a]*2) a++;
            if (dp[i] == dp[b]*3) b++;
            if (dp[i] == dp[c]*5) c++;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        Solution49 s = new Solution49();
        System.out.println(s.nthUglyNumber(10)); //12
    }
}
