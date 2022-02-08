package easy;

import java.util.HashMap;
import java.util.Map;

public class PRO128 {
    public int longestConsecutive(int[] nums) {
        //记录右边界
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num: nums){
            map.put(num,num);
        }
        int res = 0;
        for (int num : nums) {
            int right = map.get(num);
            while (map.containsKey(right+1)) {
                right = map.get(right+1);
            }
            map.put(num,right);
            res = Math.max(res, right-num+1);
        }
        return res;
    }

    public static void main(String[] args) {
        PRO128 p = new PRO128();
        System.out.println(p.longestConsecutive(new int[] {100,4,200,1,3,2})); //4 1,2,3,4
        System.out.println(p.longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1})); //9
    }
}
