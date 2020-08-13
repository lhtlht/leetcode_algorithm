package jianzhi_offer;

import java.util.HashMap;

public class Solution48 {
    /*
    剑指 Offer 48. 最长不含重复字符的子字符串
    请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     */

    public int lengthOfLongestSubstring(String s) {
        //双指针 + hashmap
        int left = 0;
        int right = 0;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        while (right < s.length()) {
            char r = s.charAt(right);
            right++;
            if (map.containsKey(r)) {
                map.put(r, map.get(r)+1);
            } else {
                map.put(r, 1);
            }

            while (map.get(r) > 1) {
                char l = s.charAt(left);
                left++;
                map.put(l, map.get(l)-1);
            }
            res = Math.max(res, right-left);

        }
        return res;
    }

    public static void main(String[] args) {
        Solution48 s = new Solution48();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb")); //3
        System.out.println(s.lengthOfLongestSubstring("bbbbb")); //1
        System.out.println(s.lengthOfLongestSubstring("pwwkew")); //3
    }
}
