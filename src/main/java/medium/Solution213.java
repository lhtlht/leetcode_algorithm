package medium;

public class Solution213 {
    /**
     * 213. 打家劫舍 II
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     *
     * 示例 1:
     *
     * 输入: [2,3,2]
     * 输出: 3
     * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     * 示例 2:
     *
     * 输入: [1,2,3,1]
     * 输出: 4
     * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     */

    public int rob(int[] nums) {
        if (nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        int n = nums.length;
        return Math.max(robRange(nums, 0, n-2), robRange(nums, 1, n-1));
    }

    public int robRange(int[] nums, int start, int end) {
        int[] dp = new int[nums.length+2];
        for (int i=end; i>=start; i--) {
            dp[i] = Math.max(dp[i+1], dp[i+2]+nums[i]);
        }
        return dp[start];
    }

    public int rob2(int[] nums) {
        if (nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        int n = nums.length;
        return Math.max(robRange2(nums, 0, n-2), robRange2(nums, 1, n-1));
    }

    public int robRange2(int[] nums, int start, int end) {
        int[] dp = new int[nums.length+2];
        int dp_i_1 = 0;
        int dp_i_2 = 0;
        int dp_i = 0;
        for (int i=end; i>=start; i--) {
            dp_i = Math.max(dp_i_1, dp_i_2+nums[i]);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }


    public static void main(String[] args) {
        int[] nums1 = {2,3,2};
        int[] nums2 = {1,2,3,1};
        Solution213 s = new Solution213();
        System.out.println(s.rob(nums1)); //3
        System.out.println(s.rob(nums2)); //4

        System.out.println(s.rob2(nums1)); //3
        System.out.println(s.rob2(nums2)); //4
    }
}
