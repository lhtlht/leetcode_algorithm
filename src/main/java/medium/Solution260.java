package medium;

public class Solution260 {
    /*
    260. 只出现一次的数字 III
    给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。

    示例 :

    输入: [1,2,1,3,2,5]
    输出: [3,5]
    注意：

    结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
    你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
     */
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length < 2) return res;
        int ab = nums[0];
        for (int i=1; i<nums.length; i++) {
            ab ^= nums[i];
        }

        int tmp = 1;
        while (true) {
            if ((ab & 1) == 1) {
                break;
            }
            tmp = tmp << 1;
            ab = ab >> 1;
        }

        for (int n : nums){
            if ((n&tmp) == 0) {
                res[0] ^= n;
            } else {
                res[1] ^= n;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        Solution260 s = new Solution260();
        System.out.println(s.singleNumber(new int[] {1,2,1,3,2,5}));
    }
}
