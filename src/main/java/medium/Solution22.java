package medium;

import java.util.LinkedList;
import java.util.List;

public class Solution22 {
    /*
    22. 括号生成
    数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。



    示例：

    输入：n = 3
    输出：[
           "((()))",
           "(()())",
           "(())()",
           "()(())",
           "()()()"
         ]
     */

    public List<String> generateParenthesis(int n) {
        LinkedList<String> res = new LinkedList<String>();
        if (n == 0) return res;

        String track = "";
        backtrack(n, n, track, res);
        return res;

    }

    //left right 左右剩余的括号
    public void backtrack(int left, int right, String track, LinkedList<String> res) {
        //判断合法性
        if (right < left) return; //右边的剩余括号大于左边，不合法
        if (left < 0 || right < 0) return;
        if (left == 0 && right == 0) {
            res.add(track);
            return;
        }

        track = track + "(";
        backtrack(left-1, right, track, res);
        track = track.substring(0, track.length()-1);

        track = track + ")";
        backtrack(left, right-1, track, res);
        track = track.substring(0, track.length()-1);

    }



    public static void main(String[] args) {
        int n = 3;

        Solution22 s = new Solution22();
        System.out.println(s.generateParenthesis(n));
    }


}
