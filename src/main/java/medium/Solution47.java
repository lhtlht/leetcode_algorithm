package medium;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution47 {
    /*
    47. 全排列 II
    给定一个可包含重复数字的序列，返回所有不重复的全排列。

    示例:

    输入: [1,1,2]
    输出:
    [
      [1,1,2],
      [1,2,1],
      [2,1,1]
    ]
     */
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null) return null;
        int n = nums.length;
        res = new ArrayList<List<Integer>>();
        if (n < 1) {
            return res;
        }
        Arrays.sort(nums);
        LinkedList<Integer> tmp = new LinkedList<Integer>();
        LinkedList<Integer> index = new LinkedList<Integer>();

        bachtrack(nums, n, 0, tmp, index);
        return res;
    }

    public void bachtrack(int[] nums, int n, int start, LinkedList<Integer> tmp, LinkedList<Integer> index) {
        if (tmp.size() == n) {
            res.add(new ArrayList<Integer>(tmp));
            return;
        }

        for (int i=0; i<n; i++) {
            if (index.contains(i)) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i-1] && !index.contains(i-1)) {
                continue;
            }
            tmp.add(nums[i]);
            index.add(i);
            bachtrack(nums, n, i+1, tmp, index);
            tmp.removeLast();
            index.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution47 s = new Solution47();
        System.out.println(s.permuteUnique(new int[] {1,1,2}));
    }
}
