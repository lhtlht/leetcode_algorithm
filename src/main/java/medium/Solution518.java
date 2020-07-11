package medium;

public class Solution518 {
    /**
     * 518. 零钱兑换 II
     * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
     *
     *
     *
     * 示例 1:
     *
     * 输入: amount = 5, coins = [1, 2, 5]
     * 输出: 4
     * 解释: 有四种方式可以凑成总金额:
     * 5=5
     * 5=2+2+1
     * 5=2+1+1+1
     * 5=1+1+1+1+1
     * 示例 2:
     *
     * 输入: amount = 3, coins = [2]
     * 输出: 0
     * 解释: 只用面额2的硬币不能凑成总金额3。
     * 示例 3:
     *
     * 输入: amount = 10, coins = [10]
     * 输出: 1
     */

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1]; // dp[i][j] 表示 使用前i个coins，凑j面额，一共有多少种凑法
        //base case : dp[0][..] = 0 和 dp[..][0] = 1
        for (int i=0; i<coins.length+1; i++) {
            dp[i][0] = 1;
        }

        for (int i=1; i<coins.length+1; i++) {
            for (int j=1; j<amount+1; j++) {
                //转移状态
                if (j - coins[i-1] >= 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[coins.length][amount];
    }


    public int change2(int amount, int[] coins) { //通过一维数组压缩空间
        int[] dp = new int[amount+1];
        dp[0] = 1;


        for (int i=1; i<coins.length+1; i++) {
            for (int j=1; j<amount+1; j++) {
                //转移状态
                if (j - coins[i-1] >= 0) {
                    dp[j] = dp[j] + dp[j-coins[i-1]];
                }
            }
        }

        return dp[amount];
    }


    public static void main(String[] args) {
        int amount1 = 5;
        int[] coins1 = {1,2,5};

        int amount2 = 3;
        int[] coins2 = {2};

        int amount3 = 10;
        int[] coins3 = {10};

        Solution518 s = new Solution518();
        System.out.println(s.change(amount1, coins1)); //4
        System.out.println(s.change(amount2, coins2)); //0
        System.out.println(s.change(amount3, coins3)); //1

        System.out.println(s.change2(amount1, coins1)); //4
        System.out.println(s.change2(amount2, coins2)); //0
        System.out.println(s.change2(amount3, coins3)); //1
    }
}
