package medium;

public class Solution50 {
    /*
    50. Pow(x, n)
    实现 pow(x, n) ，即计算 x 的 n 次幂函数。

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
    说明:

    -100.0 < x < 100.0
    n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
     */

    public double myPow(double x, int n) {
        long N = n;
        return N > 0 ? PowHelp(x,N) : 1/PowHelp(x,-N);
    }
    public double PowHelp(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double y = PowHelp(x, n/2);
        return n%2 == 0 ? y*y : y*y*x;
    }




    public static void main(String[] args) {
        Solution50 s = new Solution50();
        System.out.println(s.myPow(2,4));
    }
}
