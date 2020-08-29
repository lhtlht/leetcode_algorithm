package medium;

import sun.awt.image.ImageWatched;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class Solution394 {
    /*
    394. 字符串解码
    给定一个经过编码的字符串，返回它解码后的字符串。
    编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
    你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
    此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

    示例 1：
    输入：s = "3[a]2[bc]"
    输出："aaabcbc"

    示例 2：
    输入：s = "3[a2[c]]"
    输出："accaccacc"

    示例 3：
    输入：s = "2[abc]3[cd]ef"
    输出："abcabccdcdcdef"

    示例 4：
    输入：s = "abc3[cd]xyz"
    输出："abccdcdcdxyz"
     */
    int ptr;
    public String decodeString(String s) {
        LinkedList<String> stk = new LinkedList<String>();
        ptr = 0;
        while (ptr < s.length()) {
            char curr = s.charAt(ptr);
            if (Character.isDigit(curr)) {
                //获取第一个数字并进栈
                String digits = getDigits(s);
                stk.addLast(digits);
            } else if (Character.isLetter(curr) || curr == '[') {
                //获取一个字母并进栈
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                ptr++;
                LinkedList<String> sub = new LinkedList<String>();
                while (!"[".equals(stk.peekLast())) {
                    sub.addLast(stk.removeLast());
                }
                Collections.reverse(sub);
                //左括号出栈
                stk.removeLast();
                //栈顶对应次数
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                while (repTime > 0) {
                    t.append(o);
                    repTime--;
                }
                stk.addLast(t.toString());
            }




        }
        return getString(stk);
    }

    public String getDigits(String s) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    public String getString(LinkedList<String> s) {
        StringBuffer t = new StringBuffer();
        for (String v : s) {
            t.append(v);
        }
        return t.toString();
    }

    public static void main(String[] args) {
        Solution394 s = new Solution394();
        System.out.println(s.decodeString("3[a]2[bc]"));
        System.out.println(s.decodeString("3[a2[c]]"));
        System.out.println(s.decodeString("2[abc]3[cd]ef"));
        System.out.println(s.decodeString("abc3[cd]xyz"));
    }
}
