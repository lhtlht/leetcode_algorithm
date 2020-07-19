package medium;

import java.util.HashMap;

public class Solution560 {
    /*
    560. 和为K的子数组
    给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

    示例 1 :

    输入:nums = [1,1,1], k = 2
    输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
    说明 :

    数组的长度为 [1, 20,000]。
    数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
     */
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        //构造前缀和
        int[] preSum = new int[nums.length+1];
        preSum[1] = nums[0];
        for (int i=1; i<nums.length; i++) {
            preSum[i+1] = preSum[i] + nums[i];
        }


        //穷举所有的子数组
        for (int i=0; i<nums.length; i++) {
            for (int j=i; j<nums.length; j++) {
                if (preSum[j+1]-preSum[i] == k) {  //if (sum[j] == sum[i] - k) 引出哈希表优化
                    ans++;
                    ans++;
                }
            }
        }
        return ans;
    }

    public int subarraySum2(int[] nums, int k) {
        int ans = 0;
        int preSum =0;
        HashMap<Integer, Integer> preSumMap = new HashMap<Integer, Integer>();
        preSumMap.put(0, 1);
        for (int num: nums) {
            preSum += num;
            if (preSumMap.containsKey(preSum-k)) {
                ans += preSumMap.get(preSum-k);
            }
            preSumMap.put(preSum, preSumMap.getOrDefault(preSum, 0) + 1);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 9;
        Solution560 s = new Solution560();
        System.out.println(s.subarraySum(nums, k));
        System.out.println(s.subarraySum2(nums, k));

    }
}
