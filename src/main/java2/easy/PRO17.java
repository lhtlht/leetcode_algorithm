package easy;

import java.util.*;

public class PRO17 {
    Map<Character, String> digitsTo = new HashMap<Character, String>() {{
        put('2',"abc");
        put('3',"def");
        put('4',"ghi");
        put('5',"jkl");
        put('6',"mno");
        put('7',"pqrs");
        put('8',"tuv");
        put('9',"wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        List<String> res = new ArrayList<String>();
        if (len == 0) {
            return res;
        }
        backtrack(res, digits, 0, new StringBuffer());
        return res;
    }

    public void backtrack(List<String> res, String digits, int index, StringBuffer tmp) {
        if (index == digits.length()) {
            res.add(tmp.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = digitsTo.get(digit);
            int lettersCount = letters.length();
            for (int i=0; i<lettersCount; i++) {
                tmp.append(letters.charAt(i));
                backtrack(res, digits, index+1, tmp);
                tmp.deleteCharAt(index);
            }
        }

    }
}
