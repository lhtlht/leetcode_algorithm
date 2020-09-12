package medium;

public class Solution153 {
    /*
    153. 寻找旋转排序数组中的最小值
    假设按照升序排序的数组在预先未知的某个点上进行了旋转。

    ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

    请找出其中最小的元素。

    你可以假设数组中不存在重复元素。

    示例 1:

    输入: [3,4,5,1,2]
    输出: 1
    示例 2:

    输入: [4,5,6,7,0,1,2]
    输出: 0
     */

    public int findMin(int[] nums) {
        int len = nums.length;

        for (int i=0; i<len-2; i++) {
            if (nums[i] > nums[i+1]) {
                return nums[i+1];
            }
        }
        return nums[0];
    }
    public int findMin2(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int left = 0;
        int right = len-1;
        if (nums[right] > nums[left]) return nums[0];
        while (left < right) {
            int mid = left + (right-left)/2;
            if (nums[mid] > nums[mid+1]) {
                return nums[mid+1];
            }
            if (nums[mid] < nums[mid-1]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                left = mid+1;
            } else {
                right = mid;
            }

        }
        return -1;
    }
    public static void main(String[] args) {
        Solution153 s = new Solution153();
        System.out.println(s.findMin2(new int[] {3,4,5,1,2})); //1
        System.out.println(s.findMin2(new int[] {4,5,6,7,0,1,2})); //0
    }
}
