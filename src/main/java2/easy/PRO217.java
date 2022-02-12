package easy;

import java.util.HashMap;
import java.util.Map;

public class PRO217 {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int num : nums) {
            if (map.containsKey(num)){
                return true;
            } else {
                map.put(num,1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PRO217 p = new PRO217();
        System.out.println(p.containsDuplicate(new int[] {1,2,3,1})); //true
        System.out.println(p.containsDuplicate(new int[] {1,2,3,4})); //false
        System.out.println(p.containsDuplicate(new int[] {1,1,1,3,3,4,3,2,4,2})); //true
    }
}
