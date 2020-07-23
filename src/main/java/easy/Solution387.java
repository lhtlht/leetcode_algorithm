package easy;

import java.util.HashMap;

public class Solution387 {
    /*
    387. 字符串中的第一个唯一字符
    给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。



    示例：

    s = "leetcode"
    返回 0

    s = "loveleetcode"
    返回 2


    提示：你可以假定该字符串只包含小写字母。
     */

    public int firstUniqChar(String s) {
        int[] newS = new int[26];
        for (int i=0; i<s.length(); i++) {
            newS[s.charAt(i)-97]++;
        }

        for (int i=0; i<s.length(); i++) {
            if (newS[s.charAt(i)-97]==1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar2(String s) {  //运行时间慢上个解决方案
        HashMap<Character,Integer> smap = new HashMap<Character, Integer>();
        for (int i=0; i<s.length(); i++) {
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i),0)+1);
        }

        for (int i=0; i<s.length(); i++) {
            if (smap.get(s.charAt(i))==1) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "loveleetcode";
        Solution387 s = new Solution387();
        System.out.println(s.firstUniqChar(s1)); //0
        System.out.println(s.firstUniqChar(s2)); //2

        System.out.println(s.firstUniqChar2(s1)); //0
        System.out.println(s.firstUniqChar2(s2)); //2
    }
}
