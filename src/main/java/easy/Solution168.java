package easy;

public class Solution168 {
    /*
    168. Excel表列名称
    给定一个正整数，返回它在 Excel 表中相对应的列名称。

    例如，

        1 -> A
        2 -> B
        3 -> C
        ...
        26 -> Z
        27 -> AA
        28 -> AB
        ...
    示例 1:

    输入: 1
    输出: "A"
    示例 2:

    输入: 28
    输出: "AB"
    示例 3:

    输入: 701
    输出: "ZY"
     */
    public String convertToTitle(int n) {
        char[] letter = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        StringBuffer res = new StringBuffer();
        while (n > 0) {
            int tmp = n%26==0?25:n%26-1;
            res.append(letter[tmp]);
            n = tmp == 25 ? n/26-1 :  n/26;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Solution168 s = new Solution168();
        System.out.println(s.convertToTitle(1)); //A
        System.out.println(s.convertToTitle(28)); //AB
        System.out.println(s.convertToTitle(701)); //ZY
        System.out.println(s.convertToTitle(52)); //AZ
    }
}
