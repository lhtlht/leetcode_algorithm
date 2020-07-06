package medium;


public class Solution567 {
    /**
     * 567. 字符串的排列
     * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
     *
     * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
     *
     * 示例1:
     *
     * 输入: s1 = "ab" s2 = "eidbaooo"
     * 输出: True
     * 解释: s2 包含 s1 的排列之一 ("ba").
     * @param s1
     * @param s2
     * @return
     *
     * 注意：
     *
     * 输入的字符串只包含小写字母
     * 两个字符串的长度都在 [1, 10,000] 之间
     *
     *
     */
    public boolean checkInclusion(String s1, String s2) {
        int[] windows = new int[26];
        int[] needs = new int[26];
        int needs_size = 0;
        for (int i=0; i<s1.length(); i++) {
            if (needs[s1.charAt(i)-97]==0) needs_size++;
            needs[s1.charAt(i) - 97]++;
        }
        int left = 0;
        int right = 0;
        int val = 0;
        while (right < s2.length()) {
            //窗口更新
            int r = s2.charAt(right)-97;
            if (needs[r] > 0) {
                windows[r] ++;
                if (windows[r] == needs[r]) {
                    val ++;
                }
            }
            right ++;
            //判断左侧窗口是否要收缩
            if (right - left >= s1.length()) {
                //窗口左移.判断是否找到子串
                if (val == needs_size) {
                    return true;
                }

                int l = s2.charAt(left)-97;
                if (needs[l]>0) {
                    if (windows[l]==needs[l]) {
                        val --;
                    }
                    windows[l]--;
                }
                left++;

            }


        }
        return false;
    }


    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        Solution567 s = new Solution567();
        System.out.println(s.checkInclusion(s1,s2));
    }
}
