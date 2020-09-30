package jianzhi_offer;

import java.util.HashMap;

public class Solution57 {
    /*
    剑指 Offer 57. 和为s的两个数字
输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。



示例 1：

输入：nums = [2,7,11,15], target = 9
输出：[2,7] 或者 [7,2]
示例 2：

输入：nums = [10,26,30,31,47,60], target = 40
输出：[10,30] 或者 [30,10]
     */

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (map.containsKey(target-num)) {
                res[0] = num;
                res[1] = target-num;
            } else {
                map.put(num,1);
            }
        }
        return res;
    }
    public int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        int i = 0;
        int j = nums.length-1;
        while (i < j) {
            if (nums[i]+nums[j] == target) {
                res[0] = nums[i];
                res[1] = nums[j];
                break;
            } else if (nums[i]+nums[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return res;
    }
}
