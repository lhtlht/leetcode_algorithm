package easy;

import java.util.LinkedList;
import java.util.List;

public class PRO119 {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> res = new LinkedList<Integer>();
        res.add(1);
        for (int i=1; i<=rowIndex; i++) {
            res.add(0); //最后一个位置初始化为0
            for (int j=i; j>0; j--) {
                res.set(j, res.get(j)+res.get(j-1));
            }
        }
        return res;



    }

    public static void main(String[] args) {
        PRO119 p = new PRO119();
        System.out.println(p.getRow(5));
    }


}
