package easy;

import java.util.ArrayList;
import java.util.List;

public class Solution118 {
    /*
    118. 杨辉三角
    给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     */

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (numRows == 0) {
            return res;
        }

        res.add(new ArrayList<Integer>() {{
            add(1);
        }});
        if (numRows == 1) {
            return res;
        }
        res.add(new ArrayList<Integer>() {{
            add(1);
            add(1);
        }});

        for (int i=2; i<numRows; i++) {
            List<Integer> rows = new ArrayList<Integer>();
            List<Integer> pre = res.get(i-1);
            rows.add(1);
            for (int j=1; j<i; j++) {
                rows.add(pre.get(j-1) +  pre.get(j));
            }
            rows.add(1);
            res.add(rows);
        }

        return res;
    }
    public static void main(String[] args) {
        Solution118 s = new Solution118();
        System.out.println(s.generate(1));
        System.out.println(s.generate(2));
        System.out.println(s.generate(3));
        System.out.println(s.generate(5));
    }
}
