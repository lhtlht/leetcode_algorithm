package easy;

public class PRO198 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[][] dp = new int[2][len+1]; //0表示不偷，1表示偷
        dp[0][0] = 0;
        dp[1][0] = nums[0];

        for (int i=1; i<len; i++) {
            dp[0][i] = Math.max(dp[0][i-1], dp[1][i-1]);
            dp[1][i] = dp[0][i-1] + nums[i];
        }
        return Math.max(dp[0][len-1],dp[1][len-1]);

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        PRO198 p = new PRO198();
        System.out.println(p.rob(nums));
    }
}
