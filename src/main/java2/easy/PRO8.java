package easy;

public class PRO8 {
    public int myAtoi(String s) {
        long res = 0;
        s = s.trim();
        int n = s.length();
        if (n == 0) return (int)res;
        int p = 1;
        if (s.charAt(0)=='-') {
            p = -1;
            s = s.substring(1);
            n--;
        } else if (s.charAt(0)=='+') {
            s = s.substring(1);
            n--;
        }
        for (int i=0; i<n; i++) {
            if (s.charAt(i) == ' ' || s.charAt(i)<48 || s.charAt(i) > 57){
                return (int)res;
            }
            res = res*10 + (s.charAt(i)-48)*p;
            if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return (int)res;
    }

    public static void main(String[] args) {
        PRO8 p = new PRO8();
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(p.myAtoi("42"));
        System.out.println(p.myAtoi("   42"));
        System.out.println(p.myAtoi("  42  "));
        System.out.println(p.myAtoi("4193 with words"));
        System.out.println(p.myAtoi("words and 987"));
        System.out.println(p.myAtoi("-42"));
        System.out.println(p.myAtoi("-91283472332"));
        System.out.println(p.myAtoi("-6147483648"));

    }
}
