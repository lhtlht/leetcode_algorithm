package easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PRO118 {
    public List<List<Integer>> generate(int numRows) {
        /*
        1 <= numRows <= 30
         */
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> p = new LinkedList<Integer>();
        p.add(1);
        res.add(new LinkedList<Integer>(p));
        if (numRows == 1) {
            return res;
        }
        p.clear();
        p.add(1);
        p.add(1);
        res.add(new LinkedList<Integer>(p));
        if (numRows == 2) {
            return res;
        }
        List<Integer> q = new LinkedList<Integer>();
        for (int i=2; i<numRows; i++) {
            q.add(1);
            for (int j=1;j<i; j++) {
                q.add(p.get(j-1)+p.get(j));
            }
            q.add(1);
            res.add(new LinkedList<Integer>(q));
            p = new LinkedList<Integer>(q);
            q.clear();
        }
        return res;
    }

    public static void main(String[] args) {
        PRO118 p = new PRO118();
        System.out.println(p.generate(5));
    }
}
