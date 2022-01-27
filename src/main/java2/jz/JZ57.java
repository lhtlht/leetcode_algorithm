package jz;

import java.util.HashMap;
import java.util.Map;

public class JZ57 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<nums.length; i++) {
            if(map.containsKey(target-nums[i])) {
                res[0] = nums[i];
                res[1] = target - nums[i];
                break;
            }
            map.put(nums[i],1);

        }
        return res;

    }


    public int[] twoSum2(int[] nums, int target) {
        int i = 0;
        int j = nums.length-1;
        int[] res = new int[2];
        while (i <= j) {
            if(nums[i] + nums[j] == target) {
                res[0] = nums[i];
                res[1] = nums[j];
                break;
            } else if (nums[i] + nums[j] > target) {
                j --;
            } else {
                i ++;
            }

        }
        return res;
    }


}
