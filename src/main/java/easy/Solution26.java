package easy;

public class Solution26 {
    /*
    26. 删除排序数组中的重复项
    给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

    不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。



    示例 1:

    给定数组 nums = [1,1,2],

    函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

    你不需要考虑数组中超出新长度后面的元素。
    示例 2:

    给定 nums = [0,0,1,1,1,2,2,3,3,4],

    函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

    你不需要考虑数组中超出新长度后面的元素。
     */

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 1;
        int res = 0;
        while (i < n) {
            if (nums[i] == nums[res]) {
                i ++;
            } else {
                res ++ ;
                nums[res] = nums[i];

            }
        }
        return res+1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,2};
        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        Solution26 s = new Solution26();
        System.out.println(s.removeDuplicates(nums1));
        System.out.println(s.removeDuplicates(nums2));

        for (int i=0; i<nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println();
        for (int i=0; i<nums2.length; i++) {
            System.out.print(nums2[i] + " ");
        }
    }
}
