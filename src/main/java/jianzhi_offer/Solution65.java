package jianzhi_offer;

public class Solution65 {
    /*
    剑指 Offer 65. 不用加减乘除做加法
    写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
     */

    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution65 s = new Solution65();
        System.out.println(s.add(1,2)); //3
    }


}
