package medium;

import java.util.LinkedList;
import java.util.Stack;

public class Solution150 {
    /*
    150. 逆波兰表达式求值
    根据 逆波兰表示法，求表达式的值。

    有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。



    说明：

    整数除法只保留整数部分。
    给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        int res = 1;
        stack.push(str2num(tokens[0]));
        for (int i=1; i<tokens.length; i++) {
            if (!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")) {
                stack.push(str2num(tokens[i]));
            } else {
                int a = stack.pop();
                int b = stack.pop();
                if (tokens[i].equals("+")) {
                    res = a + b;
                } else if(tokens[i].equals("-")) {
                    res = b - a;
                } else if (tokens[i].equals("*")) {
                    res = b * a;
                } else {
                    res = b / a;
                }
                stack.push(res);
            }
        }
        return stack.pop();
    }

    public int str2num(String str) {
        boolean f = false;
        if (str.charAt(0) == '-'){
            f = true;
            str = str.substring(1,str.length());
        }
        int res = 0;
        int index = 0;
        for (int i=str.length()-1; i>=0; i--) {
            res += (str.charAt(i)-'0') * Math.pow(10, index);
            index++;
        }
        return f ? -res : res;
    }

    public static void main(String[] args) {
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        String[] tokens2 = {"3", "-4", "+"};
        Solution150 s = new Solution150();
        System.out.println(s.evalRPN(tokens1)); // 9
        System.out.println(s.evalRPN(tokens2)); //-1
    }
}
