package jianzhi_offer;

import java.util.HashMap;
import java.util.Map;

public class Solution20 {
    /*
    剑指 Offer 20. 表示数值的字符串
    请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
    例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
     */

    /*
    空格 「 」、数字「 0—90—9 」 、正负号 「 +-+− 」 、小数点 「 .. 」 、幂符号 「 eEeE 」 。
    按照字符串从左到右的顺序，定义以下 9 种状态。

    0.开始的空格
    1.幂符号前的正负号
    2.小数点前的数字
    3.小数点、小数点后的数字
    4.当小数点前为空格时，小数点、小数点后的数字
    5.幂符号
    6.幂符号后的正负号
    7.幂符号后的数字
    8.结尾的空格
    合法的结束状态有 2, 3, 7, 8 。
     */
    public boolean isNumber(String s) {
        if (s == null) return false;
        //定义状态
        //状态转移表 statesstates ： 设 states[i]states[i] ，其中 ii 为所处状态， states[i]states[i] 使用哈希表存储可转移至的状态。
        // 键值对 (key, value)(key,value) 含义：若输入 keykey ，则可从状态 ii 转移至状态 valuevalue 。
        Map[] states = {
                new HashMap<Character, Integer>() {{put(' ',0); put('s',1); put('d',2); put('.',4);}}, //0 空格 - 跳 （空格，正负号，数组，小数点后的数字）
                new HashMap<Character, Integer>() {{put('d', 2); put('.', 4);}},     //1 正负号
                new HashMap<Character, Integer>() {{put('d', 2); put('.',3); put('e',5); put(' ',8);}}, // 2.小数点前的数字
                new HashMap<Character, Integer>() {{put('d', 3); put('e',5); put(' ',8);}},
                new HashMap<Character, Integer>() {{put('d', 3);}},
                new HashMap<Character, Integer>() {{put('s', 6); put('d', 7);}}, //5
                new HashMap<Character, Integer>() {{put('d', 7); }}, //6
                new HashMap<Character, Integer>() {{put('d', 7); put(' ',8);}}, //7
                new HashMap<Character, Integer>() {{put(' ',8);}}
        };

        int p = 0;
        char t ;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                t = 'd';
            } else if (c == '+' || c == '-') {
                t = 's';
            } else if (c == 'e' || c == 'E') {
                t = 'e';
            } else if (c == '.' || c == ' ') {
                t = c;
            } else {
                t = '?';
            }
            if (!states[p].containsKey(t)) {
                return false;
            }
            //p = (int)states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }


    public static void main(String[] args) {
        Solution20 s = new Solution20();
        System.out.println(s.isNumber("+100"));
    }
}
