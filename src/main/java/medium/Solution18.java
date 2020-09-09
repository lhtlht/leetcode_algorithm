package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution18 {
    /*
    18. 四数之和
    给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

    注意：

    答案中不可以包含重复的四元组。

    示例：

    给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

    满足要求的四元组集合为：
    [
      [-1,  0, 0, 1],
      [-2, -1, 1, 2],
      [-2,  0, 0, 2]
    ]
     */
    List<List<Integer>> ans;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ans = new ArrayList<List<Integer>>();
        if (nums.length < 4) {
            return ans;
        }
        Arrays.sort(nums);
        LinkedList<Integer> tmp = new LinkedList<Integer>();
        backtrack(nums, target, tmp, 0, 0);
        return ans;
    }

    public void backtrack(int[] nums, int target, LinkedList<Integer> tmp, int start, int sum) {

        if (target == sum && tmp.size() == 4) {
            ans.add(new ArrayList<Integer>(tmp));
            return;
        }
        if (tmp.size() >= 4) {
            return;
        }
        for (int i=start; i<nums.length; i++) {
            if (i > 0 && i!=start && nums[i] == nums[i-1]) {
                continue;
            }
            sum += nums[i];
            tmp.add(nums[i]);
            backtrack(nums, target, tmp, i+1, sum);
            tmp.removeLast();
            sum -= nums[i];
        }

    }




    public static void main(String[] args) {
        Solution18 s = new Solution18();
        //System.out.println(s.fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0));
        System.out.println(s.fourSum(new int[] {-1,0,1,2,-1,-4}, -1));
    }
}
