package easy;

import java.util.LinkedList;
import java.util.List;

public class PRO448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new LinkedList<Integer>();
        int[] dp = new int[nums.length+1];
        for (int num : nums) {
            dp[num] += 1;
        }
        for (int i=1; i<nums.length+1; i++) {
            if(dp[i] < 1) {
                res.add(i);
            }
        }
        return res;

    }


}
