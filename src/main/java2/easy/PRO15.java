package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PRO15 {
    //排序 + 双指针
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        for (int i=0; i<n; i++) {
            if (i>0 && nums[i] == nums[i-1]) continue;
            int k = n-1;
            int tar = -nums[i];
            for (int j=i+1; j<n; j++) {
                if (j>i+1 && nums[j] == nums[j-1]) continue;
                while (j < k && nums[j] + nums[k] > tar) {
                    k--;
                }
                if (j == k) break;
                if (nums[j] + nums[k] == tar) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    res.add(tmp);
                }
            }

        }

        return res;
    }

    public static void main(String[] args) {
        PRO15 p = new PRO15();
        System.out.println(p.threeSum(new int[] {-1,0,1,2,-1,-4}));
    }
}
