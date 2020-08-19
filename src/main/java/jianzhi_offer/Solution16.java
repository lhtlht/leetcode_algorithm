package jianzhi_offer;

public class Solution16 {
    /*
    剑指 Offer 16. 数值的整数次方
    实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。



    示例 1:

    输入: 2.00000, 10
    输出: 1024.00000
    示例 2:

    输入: 2.10000, 3
    输出: 9.26100
    示例 3:

    输入: 2.00000, -2
    输出: 0.25000
    解释: 2-2 = 1/22 = 1/4 = 0.25
     */
    public double myPow(double x, int n) {
        //二分法
        return n>0? powHelp(x,n) : 1/powHelp(x,-n);
    }

    public double powHelp(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double y = powHelp(x, n/2);
        return n%2 == 0 ? y*y : y*y*x;
    }

    public static void main(String[] args) {
        Solution16 s = new Solution16();
        System.out.println(s.myPow(2,10));
    }
}
