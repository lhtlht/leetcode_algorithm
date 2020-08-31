package medium;

public class Solution186 {
    /*
    186. 翻转字符串里的单词 II
    给定一个字符串，逐个翻转字符串中的每个单词。

    示例：

    输入: ['t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e']
    输出: ['b','l','u','e',' ','i','s',' ','s','k','y',' ','t','h','e']
    注意：

    单词的定义是不包含空格的一系列字符
    输入字符串中不会包含前置或尾随的空格
    单词与单词之间永远是以单个空格隔开的
    进阶：使用 O(1) 额外空间复杂度的原地解法。
     */

    public void reverseWords(char[] s) {
        
    }

    public static void main(String[] args) {
        Solution186 s = new Solution186();
        char[] q = new char[] {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        s.reverseWords(q);
        for (char c : q) {
            System.out.print(c + " ");
        }
    }
}
