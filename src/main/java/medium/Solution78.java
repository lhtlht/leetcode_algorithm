package medium;

import java.util.ArrayList;
import java.util.Arrays;
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
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());

        return res;
    }




    public static void main(String[] args) {
        int[] nums = {};

        Solution78 s = new Solution78();
        System.out.println(s.subsets(nums));
    }
}
