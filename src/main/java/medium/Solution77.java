package medium;

import java.util.ArrayList;
import java.util.List;

public class Solution77 {
    /*
    77. 组合
    给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

    示例:

    输入: n = 4, k = 2
    输出:
    [
      [2,4],
      [3,4],
      [2,3],
      [1,2],
      [1,3],
      [1,4],
    ]
     */
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        if (k == 0 || n ==0) {
            return res;
        }
        List<Integer> track = new ArrayList<Integer>();
        backtrack(n, k, 1, track);
        return res;
    }

    public void backtrack(int n, int k, int start, List<Integer> track) {
        if (k == track.size()) {
            res.add(new ArrayList<Integer>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(n, k, i+1, track);
            track.remove(track.get(track.size()-1));
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;

        Solution77 s = new Solution77();
        System.out.println(s.combine(n,k));
    }
}
