package easy;

public class Solution125 {
    /**
     125 . 验证回文串
     给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     说明：本题中，我们将空字符串定义为有效的回文串。

     示例 1:
     输入: "A man, a plan, a canal: Panama"
     输出: true
     示例 2:
     输入: "race a car"
     输出: false

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/valid-palindrome
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        //s = s.toLowerCase();
        int left = 0;
        int right = s.length()-1;
        while (left<=right) {

            while ( !Character.isLetterOrDigit(s.charAt(left))) {
                left ++;
                if (left>=s.length()) {
                    return true;
                }

            }
            while ( !Character.isLetterOrDigit(s.charAt(right)) ) {
                right --;
            }
            if ((left<=right) &&
                    (Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right)))) {
                return false;
            } else {
                left ++;
                right --;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = " ";
        String s4 = ".";

        System.out.println(Solution125.isPalindrome(s1)); //true
        System.out.println(Solution125.isPalindrome(s2)); //false
        System.out.println(Solution125.isPalindrome(s3)); //false
        System.out.println(Solution125.isPalindrome(s4)); //false


    }
}
