package hard;

public class Solution10 {
    /**
     * 10. 正则表达式匹配
     给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     '.' 匹配任意单个字符
     '*' 匹配零个或多个前面的那一个元素
     所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

     说明:
     s 可能为空，且只包含从 a-z 的小写字母。
     p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
     */

    public static boolean isMatch(String s, String p) {
        //异常情况判断
        if (p==null) {
            if (s==null) {
                return true;
            } else {
                return false;
            }
        }
        if (p.length()==0) {
            if (s.length()==0) {
                return true;
            } else {
                return false;
            }
        }


        int sPos = 0;
        for (int i=0; i<p.length(); i++) {
            char pp = p.charAt(i);
            if (pp=='.') {
                
                while (s.charAt(sPos)==p.charAt(i-1)) {

                }
            }





        }
    }


    public static void main(String[] args) {
        String s1 = "aa", p1 = "a";
        String s2 = "aa", p2 = "a*";
        String s3 = "ab", p3 = ".*";
        String s4 = "aab", p4 = "c*a*b";
        String s5 = "mississippi", p5 = "mis*is*p*.";

        System.out.println(Solution10.isMatch(s1,p1)); //false
        System.out.println(Solution10.isMatch(s2,p2));//true
        System.out.println(Solution10.isMatch(s3,p3));//true
        System.out.println(Solution10.isMatch(s4,p4));//true
        System.out.println(Solution10.isMatch(s5,p5));//false


    }
}
