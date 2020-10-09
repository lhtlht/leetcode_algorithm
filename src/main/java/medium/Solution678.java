package medium;

import java.util.LinkedList;
import java.util.Stack;

public class Solution678 {
    /*
    678. 有效的括号字符串
给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：

任何左括号 ( 必须有相应的右括号 )。
任何右括号 ) 必须有相应的左括号 ( 。
左括号 ( 必须在对应的右括号之前 )。
* 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
一个空字符串也被视为有效字符串。
     */

    public boolean checkValidString(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> star = new Stack<Integer>();

        if (s == null || s.equals("")) return true;
        int i = 0;
        while (i == 0 || i < s.length()) {
            if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() < i) {
                    stack.pop();
                } else if (!star.isEmpty() && star.peek()<i) {
                    star.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                star.push(i);
            }
            i++;
        }
        while (!stack.isEmpty()) {
            if (!star.isEmpty() && star.peek()>stack.peek()) {
                stack.pop();
                star.pop();
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution678 s = new Solution678();
        System.out.println(s.checkValidString("()")); //true
        System.out.println(s.checkValidString("(*)")); //true
        System.out.println(s.checkValidString("(*))")); //true
        System.out.println(s.checkValidString(""));
        System.out.println(s.checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*")); //false
    }
}


