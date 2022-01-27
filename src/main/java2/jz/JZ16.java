package jz;

public class JZ16 {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        int res = 1;
        if (n>0) {
            while (n>0) {
                res *= x;
                n--;
            }
        } else {
            while (n < 0) {
                res *= x;
                n++;
            }
            res = 1/res;
        }
        return res;
    }

    public double myPow2(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1/x;
        long b = n;
        if (b < 0) {
            x = 1/x;
            b = -b;
        }
        double res = 1.0;
        while (b > 0) {
            if((b&1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }

    public double powh(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1/x;
        double num = powh(x, n>>1);
        num *= num;
        if ((n&1) == 1) {
            num *= x;
        }
        return num;
    }




    public static void main(String[] args) {
        JZ16 j = new JZ16();
        System.out.println(j.myPow2(2,2));
        System.out.println(j.myPow2(2,-2));
        System.out.println(j.myPow2(2,10)); //1024
        System.out.println(j.myPow(1,-2147483648));
    }
}
