package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution78 {
    /*
    78. 子集
    给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

    说明：解集不能包含重复的子集。

    示例:

    输入: nums = [1,2,3]
    输出:
    [
      [3],
      [1],
      [2],
      [1,2,3],
      [1,3],
      [2,3],
      [1,2],
      []
    ]
     */

    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, nums.length-1);
    }

    public List<List<Integer>> subsets(int[] nums, int n) {
        if (n < 0) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            res.add(new ArrayList<Integer>());
            return res;
        }
        int num = nums[n];
        List<List<Integer>> res = subsets(nums, n-1);

        int size = res.size();
        for (int i=0; i<size; i++) {
            List<Integer> tmp = new ArrayList<Integer>(res.get(i));
            tmp.add(num);
            res.add(tmp);
        }
        return res;
    }

    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets2(int[] nums) {
        List<Integer> track = new ArrayList<Integer>();
        backtrack(nums, 0, track);
        return res;
    }
    public void backtrack(int[] nums, int start, List<Integer> track) {
        res.add(new ArrayList<Integer>(track));
        for (int i = start; i<nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, i+1, track);
            track.remove(track.size()-1);
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};

        Solution78 s = new Solution78();
        System.out.println(s.subsets(nums));
        System.out.println(s.subsets2(nums));
    }
}
