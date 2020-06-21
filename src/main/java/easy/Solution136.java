package easy;

public class Solution136 {
    /**
     * 136. 只出现一次的数字
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 说明：
     *
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     *
     * 示例 1:
     *
     * 输入: [2,2,1]
     * 输出: 1
     * 示例 2:
     *
     * 输入: [4,1,2,1,2]
     * 输出: 4
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        //异或性质解答最好，最简便
        //相同的两个数异或为0，0和其他数异或为数本身， 多个数异或满足交换定律
        int single= 0;
        for (int i: nums) {
            single ^= i;
        }
        return single;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1};
        int[] nums1 = {4,1,2,1,2};

        System.out.println(Solution136.singleNumber(nums));
        System.out.println(Solution136.singleNumber(nums1));
    }
}
