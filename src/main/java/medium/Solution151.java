package medium;

import java.util.LinkedList;

public class Solution151 {
    /*
    151. 翻转字符串里的单词
    给定一个字符串，逐个翻转字符串中的每个单词。

    示例 1：
    输入: "the sky is blue"
    输出: "blue is sky the"

    示例 2：
    输入: "  hello world!  "
    输出: "world! hello"
    解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。

    示例 3：
    输入: "a good   example"
    输出: "example good a"
    解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

    说明：
    无空格字符构成一个单词。
    输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
    如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     */
    public String reverseWords(String s) {
        if (s == null) return null;
        int start = 0;
        int end = s.length();
        while (start < end && s.charAt(start) == ' ') start++; //去除头部空格
        while (start < end && s.charAt(end-1) == ' ') end--; //去除尾部空格

        LinkedList<String> words = new LinkedList<String>();
        StringBuffer word = new StringBuffer();

        while (start < end) {
            if (s.charAt(start) == ' ') {
                if (word.length() > 0) {
                    words.push(word.toString());
                    word = new StringBuffer();
                }
                start++;
                continue;
            } else {
                word.append(s.charAt(start));
                start++;
            }
        }
        words.push(word.toString());
        return String.join(" ", words);
//        String ans = "";
//        for (int i=words.size()-1; i>=0; i--) {
//            if (i==0) ans += words.get(i);
//            else ans += words.get(i) + " ";
//
//        }
//        return "-"+ans+"-";
    }

    public static void main(String[] args) {
        Solution151 s = new Solution151();
        System.out.println(s.reverseWords("the sky is blue"));
        System.out.println(s.reverseWords("  hello world!  "));
        System.out.println(s.reverseWords("a good   example"));
        System.out.println(s.reverseWords(""));
    }
}
