package easy;

import java.util.ArrayList;

public class Solution557 {
    /*
    557. 反转字符串中的单词 III
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

示例 1:

输入: "Let's take LeetCode contest"
输出: "s'teL ekat edoCteeL tsetnoc"
注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
     */

    public String reverseWords1(String s) {
        String[] words = s.split(" ");
        StringBuffer ws = new StringBuffer();
        for (String word : words) {
            ws.append(new StringBuffer(word).reverse() + " ");
        }
        return ws.toString().trim();
    }

    //自实现split和reverse
    public String reverseWords2(String s) {
        String[] words = split(s);
        StringBuffer ws = new StringBuffer();
        for (String word : words) {
            ws.append(reverse(word));
        }
        return ws.toString().trim();
    }

    public String[] split(String s) {
        ArrayList<String> words = new ArrayList<String>();
        StringBuffer word = new StringBuffer();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == ' ') {
                words.add(word.toString());
                word = new StringBuffer();
            } else {
                word.append(s.charAt(i));
            }
        }
        words.add(word.toString());
        return words.toArray(new String[words.size()]);
    }

    public String reverse(String word) {
        StringBuffer revWord = new StringBuffer();
        for (int i=word.length()-1; i>=0; i--) {
            revWord.append(word.charAt(i));
        }
        return revWord.toString() + " ";
    }

    public String reverseWords3(String s) {
        StringBuffer words = new StringBuffer();
        StringBuffer word = new StringBuffer();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == ' ') {
                words.append(word.reverse());
                words.append(" ");
                word.setLength(0);
            } else {
                word.append(s.charAt(i));
            }
        }
        words.append(word.reverse());
        return words.toString();
    }


    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";
        Solution557 s = new Solution557();

        System.out.println(s.reverseWords3(str));
    }
}
