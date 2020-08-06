package medium;

import java.util.HashMap;
import java.util.Map;

public class Solution166 {
    /*
    166. 分数到小数
    给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。

    如果小数部分为循环小数，则将循环的部分括在括号内。

    示例 1:

    输入: numerator = 1, denominator = 2
    输出: "0.5"
    示例 2:

    输入: numerator = 2, denominator = 1
    输出: "2"
    示例 3:

    输入: numerator = 2, denominator = 3
    输出: "0.(6)"
     */

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuffer fraction = new StringBuffer();
        if (denominator < 0 ^ numerator < 0) {
            fraction.append("-");
        }
        long dividend = Math.abs(Long.valueOf(numerator)); //被除数
        long divisor = Math.abs(Long.valueOf(denominator)); //除数

        fraction.append(String.valueOf(dividend/divisor));
        long remainder = dividend%divisor;
        if (remainder == 0) {  //如果整除，直接返回
            return fraction.toString();
        }
        fraction.append(".");

        Map<Long, Integer> map = new HashMap<Long, Integer>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(')');
                break;
            }
            map.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(String.valueOf(remainder/divisor));
            remainder %= divisor;
        }
        return fraction.toString();




    }

    public static void main(String[] args) {
        Solution166 s = new Solution166();
        System.out.println(s.fractionToDecimal(1,2));
        System.out.println(s.fractionToDecimal(2,1));
        System.out.println(s.fractionToDecimal(2,3));
    }
}
