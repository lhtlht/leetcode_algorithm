package easy;

public class Solution459 {
    /**
     * 459. 重复的子字符串
     * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
     *
     * 示例 1:
     *
     * 输入: "abab"
     *
     * 输出: True
     *
     * 解释: 可由子字符串 "ab" 重复两次构成。
     * @param s
     * @return
     */
    public static boolean repeatedSubstringPattern(String s) {
        String str = s+s;
        return str.substring(1,str.length()-1).contains(s);
    }

    public static void main(String[] args) {
        String s = "aba";
        System.out.println(Solution459.repeatedSubstringPattern(s));
    }
}
