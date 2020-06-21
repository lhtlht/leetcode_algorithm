public class MyGCD {
    //求最大公约数
    public static int gcd(int m,int n) {
        return m%n == 0?n:gcd(n,m%n);
    }


    public static void main(String[] args) {
        int m = 33;
        int n = 11;
        System.out.println(MyGCD.gcd(m,n));
    }
}
