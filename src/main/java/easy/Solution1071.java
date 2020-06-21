package easy;

public class Solution1071 {
    /**
     * 1071. 字符串的最大公因子
     * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
     *
     * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
     *
     *
     *
     * 示例 1：
     *
     * 输入：str1 = "ABCABC", str2 = "ABC"
     * 输出："ABC"
     * 示例 2：
     *
     * 输入：str1 = "ABABAB", str2 = "ABAB"
     * 输出："AB"
     * 示例 3：
     *
     * 输入：str1 = "LEET", str2 = "CODE"
     * 输出：""
     */


    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1+str2).equals(str2+str1)) {
            return "";
        }
        int maxCommonLen = Solution1071.gcd(str1.length(), str2.length());

        return str1.substring(0, maxCommonLen);
    }

    public static int gcd(int m,int n) {
        return m%n==0? n:gcd(n,m%n);
    }


    public static void main(String[] args) {
        String str1 = "ABCABC", str2 = "ABC";  //"ABC"
        String str11 = "ABABAB", str22 = "ABAB"; //"AB"
        String str111 = "LEET", str222 = "CODE"; //""
        System.out.println(Solution1071.gcdOfStrings(str1, str2));
        System.out.println(Solution1071.gcdOfStrings(str11, str22));
        System.out.println(Solution1071.gcdOfStrings(str111, str222));

    }
}
