package jianzhi_offer;

public class Solution05 {
    /*
    剑指 Offer 05. 替换空格
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。



示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."
     */

    public String replaceSpace(String s) {
        StringBuffer res = new StringBuffer();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) != ' ') {
                res.append(s.charAt(i));
            } else {
                res.append("%20");
            }
        }
        return res.toString();
    }
}
