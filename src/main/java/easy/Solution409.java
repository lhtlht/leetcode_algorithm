package easy;

public class Solution409 {
    /**
     * 409. 最长回文串
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
     *
     * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
     *
     * 注意:
     * 假设字符串的长度不会超过 1010。
     *
     * 示例 1:
     *
     * 输入:
     * "abccccdd"
     *
     * 输出:
     * 7
     *
     * 解释:
     * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     */


    public static int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray()) //存储每个字符的出现次数
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v%2;
        }
        return ans==0? s.length():(s.length()-ans+1);
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        String s1 = "aaaabbbb";
        System.out.println(Solution409.longestPalindrome(s));
        System.out.println(Solution409.longestPalindrome(s1));

    }
}
