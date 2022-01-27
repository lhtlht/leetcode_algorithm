package easy;

import java.util.LinkedList;
import java.util.List;

public class PRO78 {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new LinkedList<List<Integer>>();
        int n = nums.length;
        boolean[] info = new boolean[n];
        LinkedList<Integer> sl = new LinkedList<Integer>();
        backtrack(nums, 0, info, sl);
        return res;
    }

    public void backtrack(int[] nums, int start, boolean[] info, LinkedList<Integer> sl) {
        res.add(new LinkedList<Integer>(sl));
        for (int i=start; i<nums.length; i++) {
            sl.add(nums[i]);
            info[i] = true;
            backtrack(nums, i+1, info, sl);
            sl.removeLast();
        }
    }



    public static void main(String[] args) {
        PRO78 p = new PRO78();
        System.out.println(p.subsets(new int[] {1,2,3}));
    }


}
