package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution131 {
    /*
    131. 分割回文串
    给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

    返回 s 所有可能的分割方案。

    示例:

    输入: "aab"
    输出:
    [
      ["aa","b"],
      ["a","a","b"]
    ]
     */
    List<List<String>> res = new LinkedList<List<String>>();
    public List<List<String>> partition(String s) {
        //回溯
        LinkedList<String> p = new LinkedList<String>();
        backtrack(s, p, 0);
        return res;
    }

    public void backtrack(String s, LinkedList<String> p, int pre) {
        if (pre == s.length()) {
            res.add(new ArrayList<String>(p));
            return;
        }

        String temp;

        for (int i=pre; i<s.length(); i++) { //每次增加一个长度的字符
            boolean flag = true;
            temp = s.substring(pre, i+1);
            int wide = temp.length();
            for(int j=0;j<wide;j++){        //判断是否为回文
                if(temp.charAt(j) != temp.charAt(wide-1-j)){
                    flag = false;
                    break;
                }
            }
            if (!flag) continue;
            p.add(temp);
            backtrack(s, p, i+1);  //每次增加一条的分割线
            p.removeLast();
        }


    }


    public static void main(String[] args) {
        Solution131 s = new Solution131();
        //System.out.println(s.partition("aab"));
        System.out.println(s.partition("ababab"));
    }
}
