package jianzhi_offer;

public class Solution44 {
    public int findNthDigit(int n) {
        if (n <= 9) return n;
        int a = 1;
        int b = 0;
        long c = 9;
        while (n > c) {
            a++;
            b++;
            n -= c;
            c = a * 9 * (long)Math.pow(10,b);
        }

        int th = n/a;
        int mo = n%a;
        long res;
        if (mo > 0) {
            res = ((long)Math.pow(10,b)) + th;

        } else {
            res = ((long)Math.pow(10,b)) + th - 1;
            mo = a;
        }
        long result = 0;
        //System.out.println(a + " " + b + " " + n + " " + mo + " " + res + " th:" + th);
        for (int i=0; i<mo; i++) {
            result = res/(int)Math.pow(10,b);
            res %= (int)Math.pow(10,b);
            b--;
        }

        return (int)result;

    }

    public static void main(String[] args) {
        Solution44 s = new Solution44();
        //System.out.println(s.findNthDigit(3)); //3
        //System.out.println(s.findNthDigit(11)); //0
        //System.out.println(s.findNthDigit(189)); //9
        System.out.println(s.findNthDigit(190)); //1
        System.out.println(s.findNthDigit(1000000000)); //1
    }
}
