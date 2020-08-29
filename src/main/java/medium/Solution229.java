package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution229 {
    /*
    229. 求众数 II
    给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。

    说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。

    示例 1:

    输入: [3,2,3]
    输出: [3]
    示例 2:

    输入: [1,1,1,3,3,2,2,2]
    输出: [1,2]
     */
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        int n = nums.length / 3;
        List<Integer> res = new LinkedList<Integer>();

        for (int i=0; i<nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i],1);
            } else {
                map.put(nums[i],map.get(nums[i])+1);
            }

        }
        for (Integer num : map.keySet()) {
            if (map.get(num) > n) {
                res.add(num);
            }
        }
        return res;

    }
    public List<Integer> majorityElement2(int[] nums) {
        //众数最多只有2个
        List<Integer> res = new LinkedList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        //初始候选人
        int cond1 = nums[0];
        int cnt1 = 0;
        int cond2 = nums[0];
        int cnt2 = 0;

        for (int num : nums) {
            if (num == cond1) {
                cnt1++;
                continue;
            }
            if (num == cond2) {
                cnt2++;
                continue;
            }

            if (cnt1 == 0) {
                cond1 = num;
                cnt1++;
                continue;
            }

            if (cnt2 == 0) {
                cond2 = num;
                cnt2++;
                continue;
            }

            cnt1--;
            cnt2--;
        }

        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == cond1) cnt1++;
            else if (num == cond2) cnt2++;
        }

        if (cnt1 > nums.length/3) res.add(cond1);
        if (cnt2 > nums.length/3) res.add(cond2);

        return res;
    }
    public static void main(String[] args) {
        Solution229 s = new Solution229();
        System.out.println(s.majorityElement(new int[] {1,1,1,3,3,2,2,2}));
    }
}
