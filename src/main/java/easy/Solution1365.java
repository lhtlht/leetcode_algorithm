package easy;

public class Solution1365 {
    /**
     * 1365. 有多少小于当前数字的数字
     给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
     换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。

     以数组形式返回答案。

     输入：nums = [8,1,2,2,3]
     输出：[4,0,1,1,3]
     * @param nums
     * @return
     */
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        int[] buc = new int[101];
        for (int i:nums) buc[i] ++; // 记录每个值出现的次数
        for (int i=1; i<buc.length; i++) buc[i] += buc[i-1];

        for (int i=0; i<nums.length; i++) {
            res[i] = nums[i]==0 ? 0:buc[nums[i]-1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {8,1,2,2,3};
        int[] res = Solution1365.smallerNumbersThanCurrent(nums);
        for (int i=0; i<nums.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
