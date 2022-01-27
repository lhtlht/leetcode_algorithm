package easy;

import java.util.LinkedList;
import java.util.List;

public class PRO120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int h = triangle.size();
        if (h == 1) {
            return triangle.get(0).get(0);
        }
        triangle.get(1).set(0, triangle.get(0).get(0)+triangle.get(1).get(0));
        triangle.get(1).set(1, triangle.get(0).get(0)+triangle.get(1).get(1));

        for(int i=2; i<h; i++) {
            triangle.get(i).set(i, triangle.get(i).get(i)+triangle.get(i-1).get(i-1));
            triangle.get(i).set(0, triangle.get(i).get(0)+triangle.get(i-1).get(0));
            for (int j=i-1; j>=1; j--) {
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i-1).get(j-1),triangle.get(i-1).get(j)));
            }


        }

        int res = 100000;
        for (int i=0; i<h; i++) {
            res = Math.min(res, triangle.get(h-1).get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        PRO120 p = new PRO120();
        List<List<Integer>> triangle = new LinkedList<List<Integer>>();
        List<Integer> l = new LinkedList<Integer>();
        l.add(2);
        triangle.add(new LinkedList<Integer>(l));
        l.clear();
        l.add(3);
        l.add(4);
        triangle.add(new LinkedList<Integer>(l));
        l.clear();
        l.add(6);
        l.add(5);
        l.add(7);
        triangle.add(new LinkedList<Integer>(l));
        l.clear();
        l.add(4);
        l.add(1);
        l.add(8);
        l.add(3);
        triangle.add(new LinkedList<Integer>(l));

        System.out.println(p.minimumTotal(triangle));
    }


}
