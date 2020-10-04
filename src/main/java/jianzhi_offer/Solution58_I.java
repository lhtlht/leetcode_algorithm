package jianzhi_offer;

public class Solution58_I {
    /*
    剑指 Offer 58 - I. 翻转单词顺序
    输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。



    示例 1：

    输入: "the sky is blue"
    输出: "blue is sky the"
     */

    public String reverseWords(String s) {
        /*

         */
        s = s.trim();
        StringBuffer ans = new StringBuffer();
        int n = s.length();
        int j = n-1;
        int i = j;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            ans.append(s.substring(i+1,j+1) + " ");
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return ans.toString().trim();
    }


}
