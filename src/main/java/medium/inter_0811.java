package medium;

public class inter_0811 {
    /*
    面试题 08.11. 硬币
    硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
     */

    int count = 0;
    public int waysToChange(int n) {
        int[] coins = {1,5,10,25};
        dfs(coins, 0, n, 0);
        return count;
    }


    public void dfs(int[] coins, int sum, int n, int start) {
        if (sum == n) {
            count++;
            return;
        }
        if (sum > n) {
            return;
        }
        for (int i=start; i<coins.length; i++) {
            sum += coins[i];
            dfs(coins, sum, n, i);
            sum -= coins[i];
        }
    }


    public int waysToChange2(int n) {
        int[] coins = {1,5,10,25};
        int[][] dp = new int[5][n+1];
        for (int i=1; i<5; i++) {
            dp[i][0] = 1;
        }

        for (int i=1; i<=4; i++) {
            for (int j=1; j<=n; j++) {
                if (j - coins[i-1] < 0) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[4][n];

    }

    public int waysToChange3(int n) {
        int[] coins = {1,5,10,25};
        int[] dp = new int[n+1];
        dp[0] = 1;


        for (int i=1; i<=4; i++) {
            for (int j=1; j<=n; j++) {
                if (j - coins[i-1] >= 0) {
                    dp[j] = dp[j] + dp[j-coins[i-1]];
                }
            }
        }
        return dp[n];

    }
    public static void main(String[] args) {
        inter_0811 s = new inter_0811();
        //System.out.println(s.waysToChange(5)); //2
        System.out.println(s.waysToChange3(10)); //4
    }
}
