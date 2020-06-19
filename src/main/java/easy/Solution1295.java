package easy;

public class Solution1295 {
    /**
     * 1295. 统计位数为偶数的数字
     * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
     * @param nums
     * @return
     */
    public static int findNumbers(int[] nums) {
        int res = 0;
        for (int i=0; i<nums.length; i++) {
            if (    ((((int)Math.log10(nums[i]))+1) & 1)==0      ) {
                res ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896};
        System.out.println(Solution1295.findNumbers(nums));

    }
}
