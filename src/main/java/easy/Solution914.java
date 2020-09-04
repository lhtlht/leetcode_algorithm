package easy;

import java.util.HashMap;
import java.util.HashSet;

public class Solution914 {
    /*
    914. 卡牌分组
    给定一副牌，每张牌上都写着一个整数。

    此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：

    每组都有 X 张牌。
    组内所有的牌上都写着相同的整数。
    仅当你可选的 X >= 2 时返回 true。
     */

    public boolean hasGroupsSizeX(int[] deck) {
        if (deck == null || deck.length<2) return false;
        HashMap<Integer,Integer> maps = new HashMap<Integer,Integer>();
        for (int i=0; i<deck.length; i++) {
            maps.put(deck[i], maps.getOrDefault(deck[i],0)+1);
        }
        //公约数
        if (maps.size() < 2) return true;
        int[] values = new int[maps.size()];
        int i=0;
        for (int v : maps.values()) {
            values[i++] = v;

        }

        int m = values[0];
        for (int j=1; j<values.length; j++) {
            int n = gcd(m, values[j]);
            System.out.println(m  + " " + values[j] + " " + n);
            if (m == 1|| n==1) {
                return false;
            }
            m = n;
        }
        return true;
    }

    public int gcd(int m, int n) {
        //System.out.println(m + " " + n);
        return m%n == 0 ? n : gcd(n ,m%n);
    }

    public static void main(String[] args) {
        Solution914 s = new Solution914();
        //System.out.println(s.hasGroupsSizeX(new int[] {1,2,3,4,4,3,2,1})); //true
        //System.out.println(s.hasGroupsSizeX(new int[] {1,1,1,2,2,2,3,3})); //false
        //System.out.println(s.hasGroupsSizeX(new int[] {1})); //false
        //System.out.println(s.hasGroupsSizeX(new int[] {1,1})); //true
        //System.out.println(s.hasGroupsSizeX(new int[] {1,1,2,2,2,2})); //true
        System.out.println(s.hasGroupsSizeX(new int[] {1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3}));

    }
}
