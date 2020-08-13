package jianzhi_offer;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution38 {
    /*
    剑指 Offer 38. 字符串的排列
    输入一个字符串，打印出该字符串中字符的所有排列。



    你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。



    示例:

    输入：s = "abc"
    输出：["abc","acb","bac","bca","cab","cba"]
     */

    ArrayList<String> res = new ArrayList<String>();
    public String[] permutation(String s) {
        int len = s.length();
        if (len == 0) {
            return new String[0];
        }
        char[] ss = s.toCharArray();
        Arrays.sort(ss); //排序，为了去重

        boolean[] used = new boolean[len];
        StringBuffer tmp = new StringBuffer();
        backtrack(ss, tmp, used);
        return res.toArray(new String[res.size()]);
    }

    public void backtrack(char[] ss, StringBuffer tmp, boolean[] used) {
        if (tmp.length() == ss.length) {
            res.add(tmp.toString());
            return;
        }
        for (int i=0; i<ss.length; i++) {
            if (!used[i]) {
                if (i > 0 && ss[i] == ss[i-1] && !used[i-1]) {
                    continue;
                }
                tmp.append(ss[i]);
                used[i] = true;
                backtrack(ss, tmp, used);
                tmp.deleteCharAt(tmp.length()-1);
                used[i] = false;
            }

        }

    }

    public static void main(String[] args) {
        String str = "aba";
        Solution38 s = new Solution38();
        String[] res = s.permutation(str);
        for (String ss : res) {
            System.out.print(ss + "  ");
        }
    }
}
