package easy;

import java.util.HashMap;
import java.util.Map;

public class PRO76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<Character, Integer>();
        Map<Character, Integer> window = new HashMap<Character, Integer>();
        for (int i=0; i<t.length(); i++) {
            need.put(t.charAt(i),need.getOrDefault(t.charAt(i),0)+1);
            window.put(t.charAt(i),0);
        }
        int left = 0;
        int right = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            //窗口更新
            if(need.containsKey(c)){
                window.put(c, window.get(c)+1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            //判断左窗口是否收敛
            while (valid == need.size()) {
                if(right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left ++;
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d)-1);
                }
            }

        }
        return len == Integer.MAX_VALUE? "":s.substring(start,start+len);
    }


    public static void main(String[] args) {
        PRO76 p = new PRO76();
        System.out.println(p.minWindow("ADOBECODEBANC", "ABC")); //"BANC"
        System.out.println(p.minWindow("a","a")); //"a"
        System.out.println(p.minWindow("a","aa")); //""
        System.out.println(p.minWindow("aa","aa"));
    }
}
