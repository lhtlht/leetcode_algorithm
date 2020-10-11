package medium;

public class Solution494 {
    /*
    494. 目标和
    给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。

    返回可以使最终数组和为目标数 S 的所有添加符号的方法数。



    示例：

    输入：nums: [1, 1, 1, 1, 1], S: 3
    输出：5
    解释：

    -1+1+1+1+1 = 3
    +1-1+1+1+1 = 3
    +1+1-1+1+1 = 3
    +1+1+1-1+1 = 3
    +1+1+1+1-1 = 3

    一共有5种方法让最终目标和为3。
     */
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, 0, S, 0);
        return count;
    }

    public void dfs(int[] nums, int i, int S, int s) {
        if (i == nums.length) {
            if (s == S) count++;
            return;
        }
        dfs(nums, i+1, S, s+nums[i]);
        dfs(nums, i+1, S, s-nums[i]);
    }

    public int findTargetSumWays2(int[] nums, int S) {
        //动态规划
        /*
        sum(A) - sum(B) = target
        sum(A) = target + sum(B)
        sum(A) + sum(A) = target + sum(B) + sum(A)
        2 * sum(A) = target + sum(nums)
        sum(A) = （target + sum(nums)）/ 2
        转化为背包问题
         */
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < S || (sum+S)%2==1) {
            return 0;
        }

        //动态定义
        int n = nums.length;
        int target = (S+sum)/2;
        int[][] dp = new int[n+1][target+1];
        for (int i=0; i<=n; i++) { //什么都不装
            dp[i][0] = 1;
        }
        for (int i=1; i<=n; i++) {
            for (int j=0; j<=target; j++) {
                if (j >= nums[i-1]) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }

            }
        }
        return dp[n][target];

    }


    public static void main(String[] args) {
        Solution494 s = new Solution494();
        System.out.println(s.findTargetSumWays2(new int[] {1, 1, 1, 1, 1}, 3));
    }
}
