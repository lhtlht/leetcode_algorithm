package medium;

public class Solution12 {
    /*
    12. 整数转罗马数字
    罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。

    字符          数值
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
     */

    public String intToRoman(int num) {
        String ans = "";
        int p = 1;
        while (num > 0) {
            int cur = (num%10) * p;
            ans = subString(cur, p) + ans;
            p *= 10;
            num /= 10;

        }
        return ans;
    }

    public String subString(int cur, int p) {
        //System.out.println("cur:" + cur + " p:" + p);
        String sub = "";
        if (p == 1) {
            while (cur > 0) {
                if (cur == 4) {
                    sub += "IV";
                    return sub;
                } else if (cur == 9) {
                    sub += "IX";
                    return sub;
                } else if (cur >= 5) {
                    sub += "V";
                    cur -= 5;
                } else {
                    sub += "I";
                    cur -= 1;
                }
            }
        } else if (p == 10) {
            while (cur > 0) {
                if (cur == 40) {
                    sub += "XL";
                    return sub;
                } else if (cur == 90) {
                    sub += "XC";
                    return sub;
                } else if (cur >= 50) {
                    sub += "L";
                    cur -= 50;
                } else {
                    sub += "X";
                    cur -= 10;
                }
            }

        } else if (p == 100) {
            while (cur > 0) {
                if (cur == 400) {
                    sub += "CD";
                    return sub;
                } else if (cur == 900) {
                    sub = "CM";
                    return sub;
                } else if (cur >= 500) {
                    sub += "D";
                    cur -= 500;
                } else {
                    sub += "C";
                    cur -= 100;
                }
            }

        } else {
            while (cur > 0) {
                sub += "M";
                cur -= 1000;
            }
        }
        return sub;
    }

    public static void main(String[] args) {
        Solution12 s = new Solution12();
        System.out.println(s.intToRoman(3));
        System.out.println(s.intToRoman(4));
        System.out.println(s.intToRoman(9));
        System.out.println(s.intToRoman(58));
        System.out.println(s.intToRoman(1994));
        System.out.println(s.intToRoman(456));
    }
}
