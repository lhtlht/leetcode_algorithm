package jianzhi_offer;

import java.util.HashSet;
import java.util.Set;

public class Solution61 {
    /*
    剑指 Offer 61. 扑克牌中的顺子
    从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。



    示例 1:

    输入: [1,2,3,4,5]
    输出: True

     */
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int min = 14;
        int max = 0;
        for (int num : nums) {
            if (num == 0) continue;
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (set.contains(num)) return false;
            set.add(num);
        }
        return max - min < 5;
    }



    public static void main(String[] args) {
        Solution61 s = new Solution61();
        System.out.println(s.isStraight(new int[] {1,2,3,4,5})); //true
        System.out.println(s.isStraight(new int[] {0,0,1,2,5}));
    }
}
