package jz;

public class JZ42 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];

        for(int i=1; i<nums.length; i++) {


            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            res = Math.max(res, dp[i]);


        }


        return res;
    }

    public static void main(String[] args) {
        JZ42 j = new JZ42();
        System.out.println(j.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4})); //6
    }
}
