package easy;

public class Solution268 {
    /*
    268. 缺失数字
    给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。



    示例 1:

    输入: [3,0,1]
    输出: 2
    示例 2:

    输入: [9,6,4,2,3,5,7,0,1]
    输出: 8


    说明:
    你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
     */

    public int missingNumber(int[] nums) {
        int[] res = new int[nums.length+1];
        for (int i=0; i<nums.length; i++) {
            res[nums[i]]++;
        }

        for (int i=0; i<res.length; i++) {
            if (res[i]!=1) {
                return i;
            }
        }
        return 0;
    }

    public int missingNumber2(int[] nums) {
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
        }

        return nums.length*(nums.length+1)/2 - sum;
    }

    public static void main(String[] args) {
        int[] nums1 = {3,0,1};
        int[] nums2 = {9,6,4,2,3,5,7,0,1};
        Solution268 s = new Solution268();
        System.out.println(s.missingNumber(nums1)); //2
        System.out.println(s.missingNumber(nums2)); //8

        System.out.println(s.missingNumber2(nums1)); //2
        System.out.println(s.missingNumber2(nums2)); //8
    }
}
