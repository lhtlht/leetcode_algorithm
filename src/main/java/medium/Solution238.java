package medium;

public class Solution238 {
    /*
    238. 除自身以外数组的乘积
    给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。



    示例:

    输入: [1,2,3,4]
    输出: [24,12,8,6]
     */

    public int[] productExceptSelf(int[] nums) {
        //先乘左边
        int k = 1;
        int[] res = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            res[i] = k;
            k *= nums[i];
        }
        k = 1;
        //再乘右边
        for (int i=nums.length-1; i>=0; i--) {
            res[i] = k * res[i];
            k *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        Solution238 s = new Solution238();
        int[] res = s.productExceptSelf(nums);

        for (int num: res   ) {
            System.out.println(num);
        }
    }
}
