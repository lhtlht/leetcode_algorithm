package easy;

import java.util.HashMap;
import java.util.Map;

public class pro1 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(target-nums[0],0);
        for (int i=1; i<nums.length; i++){
            if (map.containsKey(nums[i])) {
                return new int[] {map.get(nums[i]), i};
            } else {
                map.put(target-nums[i],i);
            }
        }
        return new int[] {0,0};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] res = twoSum(nums, target);
        for (int i=0; i<res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
