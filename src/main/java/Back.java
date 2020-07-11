public class Back {
    //0-1背包问题

    /**
     * 给你⼀个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两
     * 个属性。其中第 i 个物品的重量为 wt[i] ，价值为 val[i] ，现在让你⽤
     * 这个背包装物品，最多能装的价值是多少？
     *
     *
     * N = 3, W = 4
     * wt = [2, 1, 3]
     * val = [4, 2, 3]
     * 算法返回 6，选择前两件物品装进背包，总重量 3 ⼩于 W ，可以获得最⼤
     * 价值 6。
     *
     */

    public int knapsack(int W, int N, int[] wt, int[] val) {

        int[][] dp = new int[N+1][W+1];
        for (int i=1; i<N+1; i++) {
            for (int w=1; w<W+1; w++) {
                if (w - wt[i-1] < 0) {
                    dp[i][w] = dp[i-1][w]; //不装
                } else {
                    dp[i][w] = Math.max(
                            dp[i-1][w],//不装
                            dp[i-1][w-wt[i-1]] + val[i-1] //装
                    );
                }
            }
        }

        return dp[N][W];
    }

    public static void main(String[] args) {
        int W = 4, N = 3;
        int[] wt = {2,1,3};
        int[] val = {4,2,3};

        Back s = new Back();
        System.out.println(s.knapsack(W, N, wt, val)); //6

    }
}
