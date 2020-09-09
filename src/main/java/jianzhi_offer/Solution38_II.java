package jianzhi_offer;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution38_II {
    ArrayList<String> res = new ArrayList<String>();
    public String[] permutation(String s) {
        int len = s.length();
        if (len == 0) {
            return new String[0];
        }

        char[] sArray = s.toCharArray();
        Arrays.sort(sArray); //去重

        boolean[] used = new boolean[len];
        StringBuffer tmp = new StringBuffer();
        backtrack(sArray, tmp, used);
        return res.toArray(new String[res.size()]);
    }

    public void backtrack(char[] sArray, StringBuffer tmp, boolean[] used) {
        if (tmp.length() == sArray.length) {
            res.add(tmp.toString());
            return;
        }

        for (int i=0; i<sArray.length; i++) {
            if (!used[i]) {
                if (i > 0 && sArray[i] == sArray[i-1] && !used[i-1]) {
                    //与前一个字符相同，且没使用，避免重复
                    continue;
                }
                tmp.append(sArray[i]);
                used[i] = true;
                backtrack(sArray, tmp, used);
                tmp.deleteCharAt(tmp.length()-1); //回溯
                used[i] = false;

            }
        }
    }




    public static void main(String[] args) {
        String str = "aba";
        Solution38_II s = new Solution38_II();
        String[] res = s.permutation(str);
        for (String ss : res) {
            System.out.print(ss + "  ");
        }
    }

}
