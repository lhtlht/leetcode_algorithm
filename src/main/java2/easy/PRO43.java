package easy;

public class PRO43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int n1 = num1.length();
        int n2 = num2.length();
        int[] res = new int[n1+n2];
        for (int i=n1-1; i>=0; i--) {
            int c1 = num1.charAt(i)-'0';
            for (int j=n2-1; j>=0; j--){
                int c2 = num2.charAt(j)-'0';
                int sum = res[i+j+1] + c1*c2;
                res[i+j+1] = sum%10;
                res[i+j] = res[i+j] + sum/10;
            }
        }

        StringBuffer result = new StringBuffer();
        for (int i=0; i<res.length; i++) {
            if (i == 0 && res[i]==0) continue;
            result.append(res[i]);
        }
        return result.toString();

    }
    public static String mulTwoNum(char c, String s) {
        int num = c - '0';
        int p = 0;
        StringBuffer res = new StringBuffer();
        for (int i=s.length()-1; i>=0; i--) {
            int tmp = num * (s.charAt(i)-'0');
            res.append(tmp%10+p);
            p = tmp/10;
        }
        if (p != 0) {
            res.append(p);
        }
        return res.reverse().toString();
    }


    public static void main(String[] args) {
        PRO43 p = new PRO43();
        System.out.println(p.multiply("12","34"));
    }
}
