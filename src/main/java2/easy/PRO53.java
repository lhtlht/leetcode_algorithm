package easy;

public class PRO53 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i=1; i<nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            res = Math.max(dp[i],res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {5,4,-1,7,8};
        PRO53 p = new PRO53();
        System.out.println(p.maxSubArray(nums));
    }


}
