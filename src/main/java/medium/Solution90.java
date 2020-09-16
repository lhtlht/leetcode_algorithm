package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution90 {
    /*
    90. 子集 II
    给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

    说明：解集不能包含重复的子集。

    示例:

    输入: [1,2,2]
    输出:
    [
      [2],
      [1],
      [1,2,2],
      [2,2],
      [1,2],
      []
    ]
     */

    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<List<Integer>>();
        LinkedList<Integer> tmp = new LinkedList<Integer>();
        if (nums == null) {
            res.add(new ArrayList<Integer>(tmp));
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;
        backtrack(nums, n, tmp, 0);
        return res;
    }

    public void backtrack(int[] nums, int n, LinkedList<Integer> tmp, int start) {
        res.add(new ArrayList<Integer>(tmp));
        for (int i=start; i<n; i++) {
            if (i > 0 && i != start && nums[i] == nums[i-1]) {
                continue;
            }
            tmp.add(nums[i]);
            backtrack(nums, n, tmp, i+1);
            tmp.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution90 s = new Solution90();
        System.out.println(s.subsetsWithDup(new int[] {1,2,2}));
    }
}
