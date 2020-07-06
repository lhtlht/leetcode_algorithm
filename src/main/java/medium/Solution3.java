package medium;

import java.util.HashMap;

public class Solution3 {
    /**
     * 3. 无重复字符的最长子串
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int res = 0;
        HashMap<Character, Integer> window = new HashMap<Character, Integer>();

        while (right < s.length()) {
            char r = s.charAt(right);
            right++;
            if (window.containsKey(r)) {
                window.put(r, window.get(r)+1);
            } else {
                window.put(r, 1);
            }

            while (window.get(r) > 1) {
                //更新窗口
                char l = s.charAt(left);
                left ++;
                window.put(l, window.get(l)-1);
            }
            res = Math.max(res, right-left);
        }
        return res;
    }


    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        Solution3 s = new Solution3();
        System.out.println(s.lengthOfLongestSubstring(s1)); //3
        System.out.println(s.lengthOfLongestSubstring(s2)); //1
        System.out.println(s.lengthOfLongestSubstring(s3)); //3


    }
}
