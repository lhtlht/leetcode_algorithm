package medium;

public class Solution33 {
    /*
    33. 搜索旋转排序数组
    假设按照升序排序的数组在预先未知的某个点上进行了旋转。

    ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

    搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

    你可以假设数组中不存在重复的元素。

    你的算法时间复杂度必须是 O(log n) 级别。

    示例 1:

    输入: nums = [4,5,6,7,0,1,2], target = 0
    输出: 4
    示例 2:

    输入: nums = [4,5,6,7,0,1,2], target = 3
    输出: -1
     */

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int n = nums.length;
        if (n == 1) {
            return nums[0] == target?0:-1;
        }
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {  //左边有序
                //比较有序的一边情况
                if (target >= nums[0] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else { //右边有序
                if (target > nums[mid] && target <= nums[n-1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] n1 = {4,5,6,7,0,1,2};
        int[] n2 = {4,5,6,7,0,1,2};
        int[] n3 = {1,3};
        Solution33 s = new Solution33();
        System.out.println(s.search(n1, 0)); //4
        System.out.println(s.search(n2,3)); //-1
        System.out.println(s.search(n3,0));
    }
}
