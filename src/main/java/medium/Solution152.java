package medium;

public class Solution152 {
    /*
    152. 乘积最大子数组
    给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。



    示例 1:

    输入: [2,3,-2,4]
    输出: 6
    解释: 子数组 [2,3] 有最大乘积 6。
    示例 2:
    输入: [-2,0,-1]
    输出: 0
    解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] maxNums = new int[n];
        int[] minNums = new int[n];

        maxNums[0] = nums[0];
        minNums[0] = nums[0];
        int res = nums[0];
        for (int i=1; i<n; i++) {
            maxNums[i] = Math.max(maxNums[i-1]*nums[i], Math.max(minNums[i-1]*nums[i], nums[i]));
            minNums[i] = Math.min(maxNums[i-1]*nums[i], Math.min(minNums[i-1]*nums[i], nums[i]));
            res = Math.max(res, maxNums[i]);
        }


        return res;
    }

    public int maxProduct2(int[] nums) {
        int maxNums = nums[0];
        int minNums = nums[0];
        int res = nums[0];
        for (int i=1; i<nums.length; i++) {
            int ma = maxNums;
            int mi = minNums;
            maxNums = Math.max(ma*nums[i], Math.max(mi*nums[i], nums[i]));
            minNums = Math.min(ma*nums[i], Math.min(mi*nums[i], nums[i]));
            res = Math.max(res, maxNums);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums1 = {2,3,-2,4};
        int[] nums2 = {-2,0,-1};
        int[] nums3 = {-4,-3,-2};
        Solution152 s = new Solution152();
        System.out.println(s.maxProduct(nums1)); //6
        System.out.println(s.maxProduct(nums2)); //0
        System.out.println(s.maxProduct(nums3)); //12

        System.out.println(s.maxProduct2(nums1)); //6
        System.out.println(s.maxProduct2(nums2)); //0
        System.out.println(s.maxProduct2(nums3)); //12

    }
}
