public class CoinCount {
    public int coinChange(int[] coins, int amount) {
        //暴力递归
        if (amount<=0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        return dp(coins, amount, res);
    }

    public int dp(int[] coins, int n, int res) {
        if (n==0) return 0;
        if (n<0) return -1;
        for (int coin:coins) {
            int subProblem = dp(coins,n-coin, res);
            if (subProblem==-1) continue; //此问题无解
            res = Math.min(res, 1+subProblem);
        }
        return res!=Integer.MAX_VALUE? res:-1;

    }


    public int coinChange2(int[] coins, int amount) {
        //暴力递归
        if (amount<=0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        int[] mem = new int[amount+1];
        return dp2(coins, amount, res, mem);
    }

    public int dp2(int[] coins, int n, int res, int[] mem) {
        if (n==0) return 0;
        if (n<0) return -1;
        if (mem[n]>0) return mem[n];
        for (int coin:coins) {
            int subProblem = dp2(coins,n-coin, res, mem);
            if (subProblem==-1) continue; //此问题无解
            res = Math.min(res, 1+subProblem);
        }
        mem[n] = res==Integer.MAX_VALUE?-1:res;
        return res!=Integer.MAX_VALUE? res:-1;

    }

    public int coinChange3(int[] coins, int amount) {
        //动态规划
        int[] dp = new int[amount+1];
        for (int i=0; i<amount+1; i++) {
            dp[i] = amount+1;
        }
        dp[0] = 0; //设置base case
        for (int i=0; i<dp.length; i++) {
            for (int coin:coins) {
                if (i-coin<0) continue;
                dp[i] = Math.min(dp[i], 1+dp[i-coin]);

            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }


    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;

        CoinCount cc = new CoinCount();
        //System.out.println(cc.coinChange(coins, amount)); //3

        //System.out.println(cc.coinChange2(coins, amount)); //3
        System.out.println(cc.coinChange3(coins, amount)); //3

    }

}
