package easy;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Solution345 {
    /*
    345. 反转字符串中的元音字母
    编写一个函数，以字符串作为输入，反转该字符串中的元音字母。



    示例 1：

    输入："hello"
    输出："holle"
    示例 2：

    输入："leetcode"
    输出："leotcede"
     */
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String vowels = "aeiouAEIOU";
        int n = s.length();
        int left = 0;
        int right = n-1;
        char[] ss = s.toCharArray();
        while (left < right) {
            while (left < right && !vowels.contains(ss[left]+"")) {
                left++;
            }
            while (left < right && !vowels.contains(ss[right]+"")) {
                right--;
            }
            char tmp = ss[left];
            ss[left] = ss[right];
            ss[right] = tmp;

            left++;
            right--;
        }
        return new String(ss);
    }

    public static void main(String[] args) {
        Solution345 s = new Solution345();
        System.out.println(s.reverseVowels("hello"));
        System.out.println(s.reverseVowels("leetcode"));
        System.out.println(s.reverseVowels("aA"));
        System.out.println(s.reverseVowels("A man, a plan, a canal: Panama")); // "a man, a plan, a canal: PanamA"
    }
}
