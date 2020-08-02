package medium;

public class Solution322 {
    /*
    322. 零钱兑换
    给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。



    示例 1:

    输入: coins = [1, 2, 5], amount = 11
    输出: 3
    解释: 11 = 5 + 5 + 1
    示例 2:

    输入: coins = [2], amount = 3
    输出: -1
     */
    public int coinChange(int[] coins, int amount) {
        if (amount < 0 || coins.length == 0) {
            return -1;
        }
        //dp数组定义：当目标金额为 i 时，至少需要 dp[i] 枚凑出*。
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i=1; i<amount+1; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i-coin] < min) {
                    min = dp[i-coin] + 1;
                }
            }
            dp[i] = min;
        }
        return dp[amount] == Integer.MAX_VALUE? -1 :dp[amount];

    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
    }
}
