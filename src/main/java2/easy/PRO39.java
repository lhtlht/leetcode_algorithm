package easy;

import java.util.LinkedList;
import java.util.List;

public class PRO39 {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new LinkedList<List<Integer>>();
        backtrack(candidates, target, 0,0, new LinkedList<Integer>());
        return res;


    }

    public void backtrack(int[] candidates, int target, int start, int sum, LinkedList<Integer> tmp) {
        if (sum == target) {
            res.add(new LinkedList<Integer>(tmp));
        }
        if (sum > target) return;
        for (int i=start; i<candidates.length; i++) {
            tmp.add(candidates[i]);
            sum += candidates[i];
            backtrack(candidates, target, i, sum, tmp);
            tmp.removeLast();
            sum -= candidates[i];
        }

    }

    public static void main(String[] args) {
        PRO39 p = new PRO39();
        System.out.println(p.combinationSum(new int[] {2,3,6,7}, 7));
        System.out.println("------------");
        System.out.println(p.combinationSum(new int[] {2,3,5}, 8));
    }
}
