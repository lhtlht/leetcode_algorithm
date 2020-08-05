package medium;

public class Solution43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int l1 = num1.length();
        int l2 = num2.length();
        int[] res = new int[l1+l2];
        for (int i=l1-1; i>=0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j=l2-1; j>=0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = res[i+j+1] + n1*n2;
                res[i+j+1] = sum%10;
                res[i+j] = res[i+j] + sum/10;
            }
        }

        StringBuffer result = new StringBuffer();
        for (int i=0; i<l1+l2; i++) {
            if (i == 0 && res[i] == 0) {
                continue;
            }
            result.append(res[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "456";
        Solution43 s = new Solution43();
        System.out.println(s.multiply(s1,s2));
    }

}
