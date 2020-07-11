package medium;

import java.util.Arrays;

public class Solution300 {
    /**
     * 300. 最长上升子序列
     * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
     *
     * 示例:
     *
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     * 说明:
     *
     * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
     * 你算法的时间复杂度应该为 O(n2) 。
     * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
     *
     */

    //时间复杂度O（n^2）
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length==0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i=1; i<nums.length; i++) {
            for (int j=0; j<i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    //2分法
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length==0) return 0;
        int[] top = new int[nums.length]; //初始化堆
        int piles = 0; //初始化堆的数量为0

        for (int i=0; i<nums.length; i++) {
            int poker = nums[i]; // 要处理的扑克牌
            //二分查找合适的堆
            int left = 0, right = piles;
            while (left < right) {
                int mid = left + (right-left)/2;
                if (poker > top[mid]) {
                    left = mid + 1;
                } else if (poker < top[mid]) {
                    right = mid;
                } else {
                    right = mid;
                }


            }

            //
            if (left == piles) piles++;
            top[left] = poker;


        }
    return piles;



    }


    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};

        Solution300 s = new Solution300();
        System.out.println(s.lengthOfLIS(nums)); //4
        System.out.println(s.lengthOfLIS2(nums)); //4

    }
}
