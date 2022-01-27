package easy;

public class PRO746 {
    public int minCostClimbingStairs(int[] cost) {
        /*
        cost 的长度范围是 [2, 1000]
         */
        int[] dp = new int[cost.length+1];
        dp[1] = cost[0];
        dp[2] = Math.min(cost[0],cost[1]);
        for (int i=3; i<= cost.length; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
        }
        return dp[cost.length];
    }

    public static void main(String[] args) {
        int[] cost1 = {10,15,20};
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        PRO746 p = new PRO746();
        System.out.println(p.minCostClimbingStairs(cost1));
        System.out.println(p.minCostClimbingStairs(cost2));

    }
}
