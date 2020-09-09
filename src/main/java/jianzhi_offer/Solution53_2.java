package jianzhi_offer;

public class Solution53_2 {
    /*
    剑指 Offer 53 - II. 0～n-1中缺失的数字
    一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。



    示例 1:

    输入: [0,1,3]
    输出: 2
    示例 2:

    输入: [0,1,2,3,4,5,6,7,9]
    输出: 8
     */

    public int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i) {
                return i;
            }
            i++;
        }
        return i;
    }

    public int missingNumber2(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end-start)/2;
            if (mid == nums[mid]) {
                start = mid + 1;
            } else if (mid < nums[mid]){
                end = mid;
            }
        }
        return start == nums.length-1 && nums[start] == start ? start+1 : start;
    }


    public static void main(String[] args) {
        Solution53_2 s = new Solution53_2();
        System.out.println(s.missingNumber2(new int[] {0,1,2,3,4,5,6,7,9}));
    }
}
