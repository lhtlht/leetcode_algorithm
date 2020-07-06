package easy;

public class Solution198 {
    /**
     * 198. 打家劫舍
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     *
     *
     *
     * 示例 1：
     *
     * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     * 示例 2：
     *
     * 输入：[2,7,9,3,1]
     * 输出：12
     * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        //选择 抢或者不抢
        //状态转移
        //base case

        if (nums.length<1) return 0;
        if (nums.length<2) return nums[0];
        int[][] dp = new int[nums.length+1][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        dp[1][0] = nums[0];
        dp[1][1] = nums[1];

        for (int i=2; i<nums.length; i++) {
            //
            dp[i][0] = dp[i-1][1]; //本次不打劫
            dp[i][1] = Math.max(dp[i-1][0]+nums[i], dp[i-2][0]+nums[i]); //本次打劫
        }
        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
    }

    public int rob2(int[] nums) {
        //选择 抢或者不抢
        //状态转移
        //base case

        if (nums.length<1) return 0;
        if (nums.length<2) return nums[0];

        int[] dp = new int[nums.length+2];
        int n = nums.length;
        for (int i=n-1; i>=0; i--) {
            //// base case: dp[n] = 0
            dp[i] = Math.max(dp[i+1], dp[i+2]+nums[i]);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,1};
        int[] nums2 = {2,7,9,3,1};
        int[] nums3 = {2,1,1,2};
        int[] nums4 = {1,2};
        Solution198 s = new Solution198();
        System.out.println(s.rob(nums1)); //4
        System.out.println(s.rob(nums2)); //12
        System.out.println(s.rob(nums3)); //4
        System.out.println(s.rob(nums4)); //2


        System.out.println(s.rob2(nums1)); //4
        System.out.println(s.rob2(nums2)); //12
        System.out.println(s.rob2(nums3)); //4
        System.out.println(s.rob2(nums4)); //2
    }
}
