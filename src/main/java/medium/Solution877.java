package medium;

public class Solution877 {
    /**
     * 877. 石子游戏
     * 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
     *
     * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
     *
     * 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
     *
     * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
     *
     *
     *
     * 示例：
     *
     * 输入：[5,3,4,5]
     * 输出：true
     * 解释：
     * 亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。
     * 假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
     * 如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
     * 如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
     * 这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。
     *
     *
     * 提示：
     *
     * 2 <= piles.length <= 500
     * piles.length 是偶数。
     * 1 <= piles[i] <= 500
     * sum(piles) 是奇数。
     * @param piles
     * @return
     */



    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        //base case
        int[][][] dp = new int[n][n][2];
        for (int i=0; i<n; i++) {
            dp[i][i][0] = piles[i];
            dp[i][i][1] = 0;
        }

        for (int l=2; l<=n; l++) {
            for (int i=0; i<=n-l; i++) {
                int j = l + i - 1;
                // 先⼿选择最左边或最右边的分数
                int left = piles[i] + dp[i+1][j][1];
                int right = piles[j] + dp[i][j-1][1];
                // 套⽤状态转移⽅程
                if (left > right) {
                    dp[i][j][0] = left;
                    dp[i][j][1] = dp[i+1][j][0];
                } else {
                    dp[i][j][0] = right;
                    dp[i][j][1] = dp[i][j-1][0];
                }
            }
        }
        return dp[0][n-1][0] - dp[0][n-1][1] > 0;


    }

    public static void main(String[] args) {
        int[] piles = {5,3,4,5};

        Solution877 s = new Solution877();
        System.out.println(s.stoneGame(piles)); //true
    }
}
