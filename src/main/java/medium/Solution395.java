package medium;

import java.util.ArrayList;
import java.util.List;

public class Solution395 {
    /*
    395. 至少有K个重复字符的最长子串
    找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。

    示例 1:
    输入:
    s = "aaabb", k = 3
    输出:
    3
    最长子串为 "aaa" ，其中 'a' 重复了 3 次。

    示例 2:
    输入:
    s = "ababbc", k = 2
    输出:
    5
    最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
     */

    public int longestSubstring(String s, int k) {
        if (s == null) {
            return 0;
        }
        int[] nums = new int[26];
        for (int i=0; i<s.length(); i++) {
            nums[s.charAt(i)-'a']++;
        }
        List<Integer> split = new ArrayList<Integer>();
        for (int i=0; i<s.length(); i++) {
            if (nums[s.charAt(i)-'a'] < k) {
                split.add(i);
            }
        }
        if (split.size() == 0) return s.length();

        int res = 0;
        int left = 0;
        //System.out.println(split);
        split.add(s.length());
        for (int i=0; i<split.size(); i++) {
            int len = split.get(i) - left;
            if (len > res) {
                res = Math.max(res, longestSubstring(s.substring(left, split.get(i)),k));
            }
            left = split.get(i) + 1;
        }
        return res;

    }

    public static void main(String[] args) {
        String s1 = "aaabb";
        int k1 = 3;

        String s2 = "ababbc";
        int k2 = 2;
        System.out.println(s1.substring(0,3));
        Solution395 s = new Solution395();
        System.out.println(s.longestSubstring(s1, k1)); //3
        System.out.println(s.longestSubstring(s2, k2)); //5
        System.out.println(s.longestSubstring("aaabbb",3)); //6
        System.out.println(s.longestSubstring("ababacb",3)); //0
    }
}
