package medium;

import java.util.ArrayList;
import java.util.List;

public class Solution228 {
    /*
    228. 汇总区间
    给定一个无重复元素的有序整数数组 nums 。

    返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。

    列表中的每个区间范围 [a,b] 应该按如下格式输出：

    "a->b" ，如果 a != b
    "a" ，如果 a == b
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            return ans;
        }

        if (nums.length == 1) {
            ans.add(String.valueOf(nums[0]));
            return ans;
        }

        int start = nums[0];
        int end = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i] - nums[i-1] == 1) {
                end = nums[i];
            } else {
                if (start == end) {
                    ans.add(String.valueOf(start));
                } else {
                    ans.add(String.valueOf(start) + "->" + String.valueOf(end));
                }

                start = nums[i];
                end = nums[i];
            }
        }
        if (start == end) {
            ans.add(String.valueOf(start));
        } else {
            ans.add(String.valueOf(start) + "->" + String.valueOf(end));
        }
        return ans;

    }

    public static void main(String[] args) {
        Solution228 s = new Solution228();
        System.out.println(s.summaryRanges(new int[] {0,1,2,4,5,7}));
        System.out.println(s.summaryRanges(new int[] {0,2,3,4,6,8,9}));
    }
}
