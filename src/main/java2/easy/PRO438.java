package easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PRO438 {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<Character, Integer>();
        Map<Character, Integer> window = new HashMap<Character, Integer>();
        List<Integer> res = new LinkedList<Integer>();
        for (int i=0; i<p.length(); i++) {
            need.put(p.charAt(i), need.getOrDefault(p.charAt(i),0)+1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s.length()){
            char c = s.charAt(right);
            right++;
            //窗口更新
            if(need.containsKey(c)) {
                window.put(c, window.getOrDefault(c,0)+1);
                if(window.get(c).equals(need.get(c))) valid++;
            }

            //左侧窗口更新移动
            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if (window.get(d) .equals( need.get(d))) { //==出错，Integer 在大于127 的时候 不从常量池里拿，是个对象，所以换成equals
                        valid--;
                    }
                    window.put(d, window.get(d)-1);

                }
            }

        }

        return res;

    }

    public static void main(String[] args) {
        PRO438 p = new PRO438();
        System.out.println(p.findAnagrams("cbaebabacd", "abc")); //0,6
        System.out.println(p.findAnagrams("abab", "ab")); //0,1,2
    }
}
