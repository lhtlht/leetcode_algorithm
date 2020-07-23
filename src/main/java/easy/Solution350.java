package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution350 {
    /*
    350. 两个数组的交集 II
    给定两个数组，编写一个函数来计算它们的交集。



    示例 1：
    输入：nums1 = [1,2,2,1], nums2 = [2,2]
    输出：[2,2]
    示例 2:
    输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    输出：[4,9]


    说明：
    输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
    我们可以不考虑输出结果的顺序。
    进阶：

    如果给定的数组已经排好序呢？你将如何优化你的算法？
    如果 nums1 的大小比 nums2 小很多，哪种方法更优？
    如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     */

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
        List<Integer> res = new ArrayList<Integer>();
        for (int i=0; i<nums1.length; i++) {
            numsMap.put(nums1[i], numsMap.getOrDefault(nums1[i],0)+1);
        }

        int[] inter = new int[nums2.length];
        int index = 0;
        for (int i=0; i<nums2.length; i++) {
            if (numsMap.containsKey(nums2[i]) && numsMap.get(nums2[i])>0) {
                numsMap.put(nums2[i], numsMap.get(nums2[i])-1);
                inter[index] = nums2[i];
                index++;
            }
        }


        return Arrays.copyOfRange(inter, 0, index);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2,2};
        Solution350 s = new Solution350();
        int[] res = s.intersect(nums1, nums2);  //[2,2]
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

}
