package easy;

import java.util.HashMap;

public class Solution13 {
    /**
     * 13.  罗马数字转整数
     */

    public static int romanToInt(String s) {
        //哈希表
        HashMap<Character, Integer> romanTo = new HashMap<Character, Integer>() {
            {
                put('I',1);
                put('V',5);
                put('X',10);
                put('L',50);
                put('C',100);
                put('D',500);
                put('M',1000);
            }
        };

        int res = romanTo.get(s.charAt(0));
        for (int i=1; i<s.length(); i++) {
            if (  romanTo.get(s.charAt(i)) > romanTo.get(s.charAt(i-1))  ) {
                res += romanTo.get(s.charAt(i));
                res -= (romanTo.get(s.charAt(i-1))*2);
            } else {
                res += romanTo.get(s.charAt(i));

            }
        }
        return res;
    }

    public static int romanToInt2(String s) {
        int res = getValue(s.charAt(s.length()-1));
        for (int i=s.length()-2; i>=0; i--) {
            if (  getValue(s.charAt(i)) < getValue(s.charAt(i+1))  ) {
                res -= getValue(s.charAt(i));
                //res -= (getValue(s.charAt(i-1))*2);
            } else {
                res += getValue(s.charAt(i));

            }
        }
        return res;
    }

    private static int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        String s1 = "III";
        String s2 = "IV";
        String s3 = "IX";
        String s4 = "LVIII";
        String s5 = "MCMXCIV";
        System.out.println("哈希表解法");
        System.out.println(Solution13.romanToInt(s1)); //3
        System.out.println(Solution13.romanToInt(s2)); //4
        System.out.println(Solution13.romanToInt(s3)); //9
        System.out.println(Solution13.romanToInt(s4)); //58
        System.out.println(Solution13.romanToInt(s5)); //1994


        System.out.println("switch解法");
        System.out.println(Solution13.romanToInt2(s1)); //3
        System.out.println(Solution13.romanToInt2(s2)); //4
        System.out.println(Solution13.romanToInt2(s3)); //9
        System.out.println(Solution13.romanToInt2(s4)); //58
        System.out.println(Solution13.romanToInt2(s5)); //1994




    }
}
