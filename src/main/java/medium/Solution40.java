package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution40 {
    /*
    40. 组合总和 II
    给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

    candidates 中的每个数字在每个组合中只能使用一次。

    说明：

    所有数字（包括目标数）都是正整数。
    解集不能包含重复的组合。
     */

    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length < 1) return res;
        Arrays.sort(candidates);
        LinkedList<Integer> tmp = new LinkedList<Integer>();
        backtrack(candidates, target, tmp, 0,0);
        return res;
    }

    public void backtrack(int[] candidates, int target, LinkedList<Integer> tmp, int start, int sum) {
        if (sum == target) {
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        if (sum > target || start > candidates.length-1) {
            return;
        }

        for (int i=start; i<candidates.length; i++) {
            if (i > 0 && i!=start && candidates[i-1] == candidates[i]) {
                continue;
            }
            sum += candidates[i];
            tmp.add(candidates[i]);
            backtrack(candidates, target, tmp, i+1, sum);
            sum -= candidates[i];
            tmp.removeLast();
        }

    }

    public static void main(String[] args) {
        Solution40 s = new Solution40();
        System.out.println(s.combinationSum2(new int[] {10,1,2,7,6,1,5}, 8));
    }
}
