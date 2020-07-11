package medium;

public class Solution416 {
    /**
     * 416. 分割等和子集
     * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     *
     * 注意:
     *
     * 每个数组中的元素不会超过 100
     * 数组的大小不会超过 200
     * 示例 1:
     *
     * 输入: [1, 5, 11, 5]
     *
     * 输出: true
     *
     * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
     *
     *
     * 示例 2:
     *
     * 输入: [1, 2, 3, 5]
     *
     * 输出: false
     *
     * 解释: 数组不能分割成两个元素和相等的子集.
     */


    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i:nums) {
            sum += i;
        }
        //转化为背包问题
        if ( sum%2 != 0) return false;

        sum = sum/2;
        boolean[][] dp = new boolean[nums.length+1][sum+1]; //用nums是否可以把amount装满,默认全部为false
        //base case
        for (int i=0; i<nums.length+1; i++) { //sum为0，默认能装满
            dp[i][0] = true;
        }


        for (int i=1; i<=nums.length; i++) {
            for (int j=1; j<=sum; j++) {
                if (j-nums[i-1] < 0) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }

        return dp[nums.length][sum];

    }

    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int i:nums) {
            sum += i;
        }
        //转化为背包问题
        if ( sum%2 != 0) return false;

        sum = sum/2;
        boolean[] dp = new boolean[sum+1];
        //base case
        dp[0] = true;


        for (int i=1; i<=nums.length; i++) {
            for (int j=sum; j>=0; j--) {
                if (j-nums[i-1] >= 0) {
                    dp[j] = dp[j] || dp[j-nums[i-1]];
                }
            }
        }

        return dp[sum];

    }


    public static void main(String[] args) {
        int[] nums1 = {1,5,11,5};
        int[] nums2 = {1,2,3,5};

        Solution416 s = new Solution416();
        System.out.println(s.canPartition(nums1)); // true
        System.out.println(s.canPartition(nums2)); // false

        System.out.println(s.canPartition2(nums1)); // true
        System.out.println(s.canPartition2(nums2)); // false
    }
}
