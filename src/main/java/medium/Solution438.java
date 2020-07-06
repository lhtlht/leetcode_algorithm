package medium;

import java.util.LinkedList;
import java.util.List;

public class Solution438 {
    /**
     * 438. 找到字符串中所有字母异位词
     * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
     *
     * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
     *
     * 说明：
     *
     * 字母异位词指字母相同，但排列不同的字符串。
     * 不考虑答案输出的顺序。
     * 示例 1:
     *
     * 输入:
     * s: "cbaebabacd" p: "abc"
     *
     * 输出:
     * [0, 6]
     *
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
     */

    public List<Integer> findAnagrams(String s, String p) {
        int[] window = new int[26];
        int[] needs = new int[26];
        int need_size = 0;
        for (int i=0; i<p.length(); i++) {
            int pp = p.charAt(i)-97;
            if (needs[pp]==0) need_size++;
            needs[pp] ++;
        }

        int left = 0;
        int right = 0;
        int val = 0;
        List<Integer> res = new LinkedList<Integer>();
        while (right < s.length()) {
            //更新窗口
            int r = s.charAt(right)-97;
            if (needs[r]>0) {
                window[r]++;
                if (window[r] == needs[r]) {
                    val ++;
                }
            }
            right++;

            //左移条件
            while (right - left == p.length()) {
                //判断是否符合
                if (val == need_size) {
                    res.add(left);
                }

                //删除窗口
                int l = s.charAt(left)-97;
                if (needs[l]>0) {
                    if (window[l] == needs[l]) {
                        val--;
                    }
                    window[l]--;
                }

                left ++;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        Solution438 res = new Solution438();
        System.out.println(res.findAnagrams(s,p)); //[0, 6]



    }
}
