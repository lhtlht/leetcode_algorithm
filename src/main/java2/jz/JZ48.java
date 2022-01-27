package jz;

import java.util.HashMap;
import java.util.Map;

public class JZ48 {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals("")) return 0;
        if(s.length() == 1) return 1;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int[] dp = new int[s.length()];
        dp[0] = 1;
        map.put(s.charAt(0),0);

        int res = 1;
        for (int i=1; i<s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                int j = map.get(c);
                if(i - dp[i-1] > j) {
                    dp[i] = dp[i-1] + 1;
                } else {
                    dp[i] = i - j;
                }
            } else {
                dp[i] = dp[i-1] + 1;
            }
            res = Math.max(res, dp[i]);
            map.put(c,i);
        }
        return res;

    }

    public static void main(String[] args) {
        JZ48 j = new JZ48();
        System.out.println(j.lengthOfLongestSubstring("abcabcbb")); //3
        System.out.println(j.lengthOfLongestSubstring("bbbbb")); //1
        System.out.println(j.lengthOfLongestSubstring("pwwkew"));
    }
}
