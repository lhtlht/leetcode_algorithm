package easy;

import java.util.LinkedList;
import java.util.List;

public class PRO46 {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<List<Integer>>();
        boolean[] using = new boolean[nums.length];
        backtrack(nums,using, new LinkedList<Integer>());
        return res;
    }
    public void backtrack(int[] nums, boolean[] using, LinkedList<Integer> tmp) {
        if (tmp.size() == nums.length) {
            res.add(new LinkedList<Integer>(tmp));
        }
        if (tmp.size() > nums.length) return;

        for (int i=0; i<nums.length; i++) {
            if (!using[i]) {
                tmp.add(nums[i]);
                using[i] = true;
                backtrack(nums, using, tmp);
                using[i] = false;
                tmp.removeLast();
            }


        }

    }

    public static void main(String[] args) {
        PRO46 p = new PRO46();
        System.out.println(p.permute(new int[] {1,2,3}));
    }
}
