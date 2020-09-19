package medium;

public class Solution209 {
    /*
    209. 长度最小的子数组
    给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。



    示例：

    输入：s = 7, nums = [2,3,1,2,4,3]
    输出：2
    解释：子数组 [4,3] 是该条件下的长度最小的子数组。


    进阶：

    如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
     */
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int count = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int n = nums.length;
        if (n == 0) {
            return 0;
        }


        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                count = Math.min(count, end-start+1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return count == Integer.MAX_VALUE? 0:count;
    }

    public static void main(String[] args) {
        Solution209 s = new Solution209();
        System.out.println(s.minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
    }
}
