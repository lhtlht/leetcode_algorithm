package easy;

public class Solution680 {
    /**
     * 680. 验证回文字符串 Ⅱ
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     *
     * 示例 1:
     *
     * 输入: "aba"
     * 输出: True
     * 示例 2:
     *
     * 输入: "abca"
     * 输出: True
     * 解释: 你可以删除c字符。
     * @param s
     * @return
     */
    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while (left<=right) {
            if (s.charAt(left)==s.charAt(right)) {
                left++;
                right--;
            } else {
                return Solution680.isPalindrome(s, left+1, right) || Solution680.isPalindrome(s, left, right-1);

            }
        }
        return true;




    }

    public static boolean isPalindrome(String s, int left, int right) {
        while (left<right) {
            if (s.charAt(left)==s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "aba";
        String s2 = "abca";
        String s3 = "ababcd";
        String s4 = "eeccccbebaeeabebccceea";
        String s5 = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        System.out.println(Solution680.validPalindrome(s1)); //true
        System.out.println(Solution680.validPalindrome(s2)); //true
        System.out.println(Solution680.validPalindrome(s3)); //false
        System.out.println(Solution680.validPalindrome(s4)); //false
        System.out.println(Solution680.validPalindrome(s5)); //true

        String s = "cupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucu";

    }
}
