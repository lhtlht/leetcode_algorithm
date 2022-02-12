package easy;

import java.util.Arrays;

public class PRO16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i=0; i<nums.length; i++){
            int start = i+1;
            int end = nums.length-1;
            while (start < end) {
                int tmp = nums[i] + nums[start] + nums[end];
                if (Math.abs(tmp-target) < Math.abs(res-target)) {
                    res = tmp;
                }
                if (tmp == target) {
                    return target;
                } else if (tmp > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return res;
    }


}
