package easy;

public class Solution1480 {
    public static int[] runningSum(int[] nums) {
        /**
         给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。

         请返回 nums 的动态和。

         来源：力扣（LeetCode）
         链接：https://leetcode-cn.com/problems/running-sum-of-1d-array
         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         示例
         输入：nums = [1,2,3,4]
         输出：[1,3,6,10]
         解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
         */
        int[] runningNums = new int[nums.length];
        runningNums[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            runningNums[i] =  runningNums[i-1] + nums[i];
        }
        return runningNums;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] runningNums = Solution1480.runningSum(nums);
        for (int num:runningNums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
