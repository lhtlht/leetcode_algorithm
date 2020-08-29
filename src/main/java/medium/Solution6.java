package medium;

import java.util.ArrayList;
import java.util.List;

public class Solution6 {
    /*
    6. Z 字形变换
    将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

    比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

    L   C   I   R
    E T O E S I I G
    E   D   H   N
    之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

    请你实现这个将字符串进行指定行数变换的函数：

    string convert(string s, int numRows);
    示例 1:

    输入: s = "LEETCODEISHIRING", numRows = 3
    输出: "LCIRETOESIIGEDHN"
    示例 2:

    输入: s = "LEETCODEISHIRING", numRows = 4
    输出: "LDREOEIIECIHNTSG"
    解释:

    L     D     R
    E   O E   I I
    E C   I H   N
    T     S     G
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int len = s.length();
        List<StringBuilder> res = new ArrayList<StringBuilder>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            res.add(new StringBuilder());
        int index = 0;
        int col = 0;
        while (index < len) {
            if (col%(numRows-1)==0) {
                for (int i=0; i<numRows && index<len; i++) {
                    res.get(i).append(s.charAt(index));
                    index++;
                }
            } else {
                int row = (numRows-1) - col%(numRows-1);
                res.get(row).append(s.charAt(index));
                index++;
            }
            col++;
        }
        String ans = "";
        for (int i=0; i<Math.min(numRows, s.length()); i++) {
            ans += res.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution6 s = new Solution6();
        System.out.println(s.convert("LEETCODEISHIRING",3)); //LCIRETOESIIGEDHN
        System.out.println(s.convert("LEETCODEISHIRING",4)); //LDREOEIIECIHNTSG
        System.out.println(s.convert("A",1));
    }
}
