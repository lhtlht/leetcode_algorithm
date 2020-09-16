package easy;

public class Solution67 {
    /*
    67. 二进制求和
    给你两个二进制字符串，返回它们的和（用二进制表示）。

    输入为 非空 字符串且只包含数字 1 和 0。



    示例 1:

    输入: a = "11", b = "1"
    输出: "100"
    示例 2:

    输入: a = "1010", b = "1011"
    输出: "10101"
     */
    public String addBinary(String a, String b) {
        int n = a.length()-1;
        int m = b.length()-1;
        StringBuffer res = new StringBuffer();
        int k = 0;
        while (n >= 0 || m >= 0) {
            int i = n >= 0 ? a.charAt(n)-'0' : 0;
            int j = m >= 0 ? b.charAt(m)-'0' : 0;
            int ij = i ^ j ^ k;
            if ((i + j + k)>=2 ) {
                k = 1;
            } else {
                k = 0;
            }
            if (ij == 0) {
                res.append('0');
            } else {
                res.append('1');
            }
            n--;
            m--;
        }
        if (k == 1) {
            res.append('1');
        }

        return res.reverse().toString();

    }

    public static void main(String[] args) {
        Solution67 s = new Solution67();
        System.out.println(s.addBinary("11","1"));
        System.out.println(s.addBinary("1010","1011"));
        System.out.println(s.addBinary("1111","1111"));
    }
}
