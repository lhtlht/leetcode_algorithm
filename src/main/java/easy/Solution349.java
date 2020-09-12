package easy;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution349 {
    /*
    349. 两个数组的交集
    给定两个数组，编写一个函数来计算它们的交集。



    示例 1：

    输入：nums1 = [1,2,2,1], nums2 = [2,2]
    输出：[2]
    示例 2：

    输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    输出：[9,4]


    说明：

    输出结果中的每个元素一定是唯一的。
    我们可以不考虑输出结果的顺序。
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int m = nums1.length;
        int n = nums2.length;
        ArrayList<Integer> res = new ArrayList<Integer>();
        while (i < m && j < n) {
            if (nums1[i] == nums2[j]) {
                if (i == 0) {
                    res.add(nums1[i]);
                }
                if (i > 0 && nums1[i-1] != nums2[j]) {
                    res.add(nums1[i]);
                }

                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] ans = new int[res.size()];
        for (int k=0; k<res.size(); k++) {
            ans[k] = res.get(k);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution349 s = new Solution349();
        int[] res1 = s.intersection(new int[] {1,2,2,1}, new int[] {2,2});
        int[] res2 = s.intersection(new int[] {4,9,5}, new int[] {9,4,9,8,4});

        for (int i : res1) System.out.print(i + " ");
        System.out.println();
        System.out.println("res2");
        for (int i : res2) System.out.print(i + " ");
    }
}
