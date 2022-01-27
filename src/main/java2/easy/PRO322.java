package easy;

import java.util.Arrays;

public class PRO322 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i=1; i<=amount; i++) {
            for (int coin : coins) {
                if(coin - i > 0) continue;
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        return dp[amount] == amount+1? -1:dp[amount];

    }

    public static void main(String[] args) {
        PRO322 p = new PRO322();
        System.out.println(p.coinChange(new int[] {1,2,5}, 11)); //3
        System.out.println(p.coinChange(new int[] {2}, 3));
    }
}
