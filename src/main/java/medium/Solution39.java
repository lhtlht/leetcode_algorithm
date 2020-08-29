package medium;

import sun.java2d.pipe.AAShapePipe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution39 {
    /*
    39. 组合总和
    给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

    candidates 中的数字可以无限制重复被选取。

    说明：

    所有数字（包括 target）都是正整数。
    解集不能包含重复的组合。
    示例 1：

    输入：candidates = [2,3,6,7], target = 7,
    所求解集为：
    [
      [7],
      [2,2,3]
    ]
    示例 2：

    输入：candidates = [2,3,5], target = 8,
    所求解集为：
    [
      [2,2,2,2],
      [2,3,3],
      [3,5]
    ]
     */
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        ans = new ArrayList<List<Integer>>();
        if (len == 0) return ans;

        LinkedList<Integer> path = new LinkedList<Integer>();
        backtrack(candidates,target, len, 0, path);
        return ans;
    }

    public void backtrack(int[] candidates, int target, int len, int currIndex, LinkedList<Integer> path) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(path));
            return;
        }


        for (int i=currIndex; i<len; i++) {
            path.add(candidates[i]);
            backtrack(candidates, target-candidates[i], len, i, path);
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        Solution39 s = new Solution39();
        System.out.println(s.combinationSum(new int[] {2,3,6,7}, 7));
        System.out.println(s.combinationSum(new int[] {2,3,5}, 8));
    }
}
