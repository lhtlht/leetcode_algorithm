package jianzhi_offer;

public class Solution42 {
    /*
    剑指 Offer 42. 连续子数组的最大和
输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

要求时间复杂度为O(n)。
     */
    public int maxSubArray(int[] nums) {
        int  max = nums[0];
        for (int i=1; i<nums.length; i++){
            nums[i] += Math.max(nums[i-1], 0);
            max = Math.max(max, nums[i]);
        }
        return max;
    }


}
