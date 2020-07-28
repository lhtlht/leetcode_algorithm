package easy;

public class Solution28 {
    /*
    28. 实现 strStr()
    实现 strStr() 函数。

    给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

    示例 1:

    输入: haystack = "hello", needle = "ll"
    输出: 2
    示例 2:

    输入: haystack = "aaaaa", needle = "bba"
    输出: -1
    说明:

    当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

    对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
     */

    public int strStr(String haystack, String needle) {
        //暴力解法
        if (needle.equals("")) {
            return 0;
        }
        int m = haystack.length();
        int n = needle.length();
        for (int i=0; i<m-n+1; i++) {
            int j;
            for (j=0; j<n; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == n) {
                return i;
            }

        }
        return -1;
    }


    public int[] getNext(String needle) {
        int[] next = new int[needle.length()];

        return next;

    }
    public int strStr2(String haystack, String needle) {
        //KMP解法
        if (needle.equals("")) {
            return 0;
        }
        return 1;

    }


    public static void main(String[] args) {
        String haystack1 = "hello";
        String needle1 = "ll";

        String haystack2 = "aaaaa";
        String needle2 = "bba";

        String haystack3 = "mississippi";
        String needle3 = "issip";
        Solution28 s = new Solution28();
        System.out.println(s.strStr2(haystack1, needle1)); //2
        System.out.println(s.strStr2(haystack2, needle2)); //-1
        System.out.println(s.strStr2(haystack3, needle3)); //4

    }
}
