package easy;

public class Solution392 {
    /*
    392. 判断子序列
    给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

    你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。

    字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     */

    public boolean isSubsequence(String s, String t) {
        int p1 = 0;
        int p2 = 0;
        int l1 = s.length();
        int l2 = t.length();
        while (p1 < l1 && p2 < l2) {
            if (s.charAt(p1) == t.charAt(p2)) {
                p1++;
            }
            p2++;
        }
        if (p1 != l1) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Solution392 s = new Solution392();
        System.out.println(s.isSubsequence("abc", "ahbgdc")); //true
        System.out.println(s.isSubsequence("axc", "ahbgdc")); //false
    }
}
