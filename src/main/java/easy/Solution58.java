package easy;

public class Solution58 {
    /*
    58. 最后一个单词的长度
    给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。

    如果不存在最后一个单词，请返回 0 。

    说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。



    示例:

    输入: "Hello World"
    输出: 5
     */

    public int lengthOfLastWord(String s) {
        int count = 0;
        int index = s.length()-1;
        while (index >= 0 && s.charAt(index) == ' ') {
            index--;
        }
        while (index >= 0 && s.charAt(index) != ' ') {
            count++;
            index--;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution58 s = new Solution58();
        System.out.println(s.lengthOfLastWord("Hello World"));
        System.out.println(s.lengthOfLastWord(""));
        System.out.println(s.lengthOfLastWord("a "));
    }
}
