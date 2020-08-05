package medium;

import java.util.Arrays;

public class Solution16 {
    /*
    16. 最接近的三数之和
    给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。



    示例：

    输入：nums = [-1,2,1,-4], target = 1
    输出：2
    解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。


    提示：

    3 <= nums.length <= 10^3
    -10^3 <= nums[i] <= 10^3
    -10^4 <= target <= 10^4
     */

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        //双指针法
        int n = nums.length;
        int res = nums[0] + nums[1] + nums[n-1];
        for (int i=0; i<n; i++) {
            int start = i+1;
            int end = n-1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(sum-target) < Math.abs(res-target)) {
                    res = sum;
                }
                if (sum > target) {
                    end --;
                } else if (sum < target) {
                    start ++;
                } else {
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        Solution16 s = new Solution16();
        System.out.println(s.threeSumClosest(nums, 1)); //2

    }
}
