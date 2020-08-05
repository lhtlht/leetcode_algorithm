package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution17 {


    String[] numBoard = {
      "",
      "",
      "abc",
      "def",
      "ghi",
      "jkl",
      "mno",
      "pqrs",
      "tuv",
      "wxyz"
    };
    List<String> res = new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
        int length = digits.length();
        if (length == 0) {
            return res;
        }

        String s = "";
        backtrack(s, digits);
        return res;
    }

    public void backtrack(String combination, String next_digits) {
        if (next_digits.length() == 0) {
            res.add(combination);
            return;
        }
        String digit = next_digits.substring(0, 1);
        String letters = numBoard[digit.charAt(0)-'0'];
        for (int i = 0; i < letters.length(); i++) {
            String letter = numBoard[digit.charAt(0)-'0'].substring(i, i + 1);
            backtrack(combination + letter, next_digits.substring(1));
        }

    }

    public static void main(String[] args) {
        String digits1 = "23";
        Solution17 s = new Solution17();
        System.out.println(s.letterCombinations(digits1));
    }
}
