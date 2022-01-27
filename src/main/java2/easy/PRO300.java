package easy;

public class PRO300 {
    public int lengthOfLIS(int[] nums) {
        int res = 1;
        int[] dp = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            dp[i] = 1;
            for (int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        PRO300 p = new PRO300();
        System.out.println(p.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18})); //4
        System.out.println(p.lengthOfLIS(new int[] {0,1,0,3,2,3})); //4
        System.out.println(p.lengthOfLIS(new int[] {7,7,7,7,7,7,7})); //1
    }
}
