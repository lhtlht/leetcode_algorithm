package easy;

public class Solution242 {
    /*
    242. 有效的字母异位词
    给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

    示例 1:

    输入: s = "anagram", t = "nagaram"
    输出: true
    示例 2:

    输入: s = "rat", t = "car"
    输出: false
    说明:
    你可以假设字符串只包含小写字母。

    进阶:
    如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     */

    public boolean isAnagram(String s, String t) {
        int[] res = new int[26];
        if (s.length() != t.length()) return false;
        for (int i=0; i<s.length(); i++) {
            res[s.charAt(i)-'a']++;
            res[t.charAt(i)-'a']--;
        }
        for (int i=0; i<26; i++) {
            if (res[i] != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        Solution242 sol = new Solution242();
        System.out.println(sol.isAnagram(s,t)); //true
    }
}
