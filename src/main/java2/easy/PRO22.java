package easy;

import java.util.LinkedList;
import java.util.List;

public class PRO22 {
    public List<String> generateParenthesis(int n) {
        List<List<String>> res = new LinkedList<List<String>>();
        if (n == 0) return res.get(0);
        List<String> list0 = new LinkedList<String>();
        list0.add("");
        res.add(list0);
        List<String> list1 = new LinkedList<String>();
        list1.add("()");
        res.add(list1);
        for (int i=2; i<=n; i++) {
            LinkedList<String> tmp = new LinkedList<String>();
            for (int j=0; j<i; j++) {
                List<String> str1 = res.get(j);
                System.out.println(i + ":" + j);
                List<String> str2 = res.get(i-j-1);
                for (String s1: str1){
                    for (String s2: str2) {
                        String s = "(" + s1 + ")" + s2;
                        tmp.add(s);
                    }
                }
            }
            res.add(tmp);
        }


        return res.get(n);
    }

    public static void main(String[] args) {
        PRO22 p = new PRO22();
        System.out.println(p.generateParenthesis(3));
    }
}
