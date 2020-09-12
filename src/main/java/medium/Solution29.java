package medium;

public class Solution29 {
    /*
    29. 两数相除
    给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

    返回被除数 dividend 除以除数 divisor 得到的商。

    整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
     */
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (divisor == 1) return  dividend;
        if (divisor == -1 ) {
            if (dividend > Integer.MIN_VALUE) return -dividend;
            return Integer.MAX_VALUE;
        }
        long a = dividend;
        long b = divisor;
        int flag = 1;
        if ((dividend>0 && divisor<0) || (dividend<0 && divisor>0)) {
            flag = -1;
        }
        a = a > 0? a : -a;
        b = b > 0? b : -b;
        long res = div(a, b);
        if (flag > 0) return res > (long)Integer.MAX_VALUE? Integer.MAX_VALUE:(int)res;
        return (int)-res;


    }

    public long div(long a, long b) {
        if (a < b) return 0;
        long count = 1;
        long tb = b;
        while (tb+tb<=a) {
            count = count+count;
            tb = tb+tb;
        }
        return count + div(a-tb,b);
    }

    public static void main(String[] args) {
        Solution29 s = new Solution29();
        //System.out.println(s.divide(10,3)); //3
        System.out.println(s.divide(7,-3)); //-2
    }
}
