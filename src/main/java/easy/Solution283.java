package easy;

public class Solution283 {
    /*
    283. 移动零
    给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

    示例:

    输入: [0,1,0,3,12]
    输出: [1,3,12,0,0]
    说明:

    必须在原数组上操作，不能拷贝额外的数组。
    尽量减少操作次数。
     */

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = 0;
        for (int i=0; i<n; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j ++;
            }
        }
        while (j < n) {
            nums[j] = 0;
            j++;
        }
    }

    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int n = nums.length;
        int j = 0;
        for (int i=0; i<n; i++) {
            if (nums[i] != 0) {
                if (i > j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,0,1,3,12};
        Solution283 s = new Solution283();
        s.moveZeroes2(nums);
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
