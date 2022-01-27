package easy;

public class PRO122 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i=1; i<n; i++) {
            dp[i][0] = Math.max(dp[i-1][1]+prices[i], dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][0]-prices[i], dp[i-1][1]);
        }
        return dp[n-1][0];

    }

    public static void main(String[] args) {
        PRO122 p = new PRO122();
        System.out.println(p.maxProfit(new int[] {7,1,5,3,6,4})); //7
        System.out.println(p.maxProfit(new int[] {1,2,3,4,5})); //4
    }
}
