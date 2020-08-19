package jianzhi_offer;

public class Solution56_II {
    /*
    剑指 Offer 56 - II. 数组中数字出现的次数 II
    在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。



    示例 1：

    输入：nums = [3,4,3,3]
    输出：4
    示例 2：

    输入：nums = [9,1,7,9,7,9,7]
    输出：1


    限制：

    1 <= nums.length <= 10000
    1 <= nums[i] < 2^31
     */

    public int singleNumber(int[] nums) {
        if (nums.length == 0) return -1;
        int[] bitSum = new int[32];
        for (int num : nums) {
            int tmp = 1;
            for (int i=31; i>=0; i--) {
                if ((num&tmp) != 0) {
                    bitSum[i]++;
                }
                tmp = tmp << 1;
            }
        }
        int res = 0;
        for (int i=0; i<32; i++) {
            res = res << 1;
            res += bitSum[i]%3;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution56_II s = new Solution56_II();
        System.out.println(s.singleNumber(new int[] {3,4,3,3}));
    }
}
