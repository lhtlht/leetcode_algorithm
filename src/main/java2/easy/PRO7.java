package easy;

public class PRO7 {
    public int reverse(int x) {

        long res = 0;
        while (x != 0){
            int m = x%10;
            res *= 10;
            res += m;
            x /= 10;
        }
        if(res < (int)Math.pow(-2,31) || res > (int)(Math.pow(2,31)-1)) {
            return 0;
        } else {
            return (int)res;
        }
    }

    public static void main(String[] args) {
        PRO7 p = new PRO7();
        System.out.println(p.reverse(120)); //21
        System.out.println(p.reverse(123));
        System.out.println(p.reverse(-123));
        System.out.println(p.reverse(0));
        System.out.println(p.reverse(1534236469)); //0

    }
}
