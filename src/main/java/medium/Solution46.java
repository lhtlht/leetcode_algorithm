package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution46 {
    /*
    46. 全排列
    给定一个 没有重复 数字的序列，返回其所有可能的全排列。

    示例:

    输入: [1,2,3]
    输出:
    [
      [1,2,3],
      [1,3,2],
      [2,1,3],
      [2,3,1],
      [3,1,2],
      [3,2,1]
    ]
     */

    List<List<Integer>> res = new LinkedList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<Integer>();
        trackback(nums, track);
        return res;
    }

    public void trackback(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<Integer>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) continue;
            track.add(nums[i]);
            trackback(nums, track);
            track.removeLast();
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};

        Solution46 s = new Solution46();
        System.out.println(s.permute(nums));

    }


}
