package easy;

public class Solution171 {
    /*
    171. Excel表列序号
    给定一个Excel表格中的列名称，返回其相应的列序号。

    例如，

        A -> 1
        B -> 2
        C -> 3
        ...
        Z -> 26
        AA -> 27
        AB -> 28
        ...
    示例 1:

    输入: "A"
    输出: 1
    示例 2:

    输入: "AB"
    输出: 28
    示例 3:

    输入: "ZY"
    输出: 701
     */

    public int titleToNumber(String s) {
        int n = s.length();
        int res = 0;
        int j = n;
        for (int i=0; i<n-1; i++) {
            res += (s.charAt(i) - 'A' + 1) * Math.pow(26,j-1);
            j --;
        }

        return res + s.charAt(n-1) - 'A' + 1;
    }


    public static void main(String[] args) {
        String s1 = "A";
        String s2 = "AB";
        String s3 = "AAA";
        Solution171 s = new Solution171();
        System.out.println(s.titleToNumber(s1)); // 1
        System.out.println(s.titleToNumber(s2)); //28
        System.out.println(s.titleToNumber(s3)); //703
    }
}
