package easy;

import java.util.HashMap;
import java.util.Map;

public class PRO567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<Character, Integer>();
        Map<Character, Integer> window = new HashMap<Character, Integer>();
        for (int i=0; i<s1.length(); i++) {
            need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i),0)+1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s2.length()){
            char c = s2.charAt(right);
            right++;
            //窗口更新
            if(need.containsKey(c)) {
                window.put(c, window.getOrDefault(c,0)+1);
                if(window.get(c).equals(need.get(c))) valid++;
            }

            //左侧窗口更新移动
            while (right - left >= s1.length()) {
                if (valid == need.size()) return true;
                char d = s2.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if (window.get(d) == need.get(d)) {
                        valid--;
                    }
                    window.put(d, window.get(d)-1);

                }
            }

        }

        return false;
    }

    public static void main(String[] args) {
        PRO567 p = new PRO567();
        System.out.println(p.checkInclusion("ab", "eidbaooo")); //true
        System.out.println(p.checkInclusion("ab", "eidboaoo")); //false
    }
}
