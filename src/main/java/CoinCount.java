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

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;

        CoinCount cc = new CoinCount();
        System.out.println(cc.coinChange(coins, amount)); //3
    }

}
