package medium;

public class Solution31 {
    /*
    31. 下一个排列
    实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

    如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

    必须原地修改，只允许使用额外常数空间。

    以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
    1,2,3 → 1,3,2
    3,2,1 → 1,2,3
    1,1,5 → 1,5,1
     */
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return;
        }

        int i = len - 2;
        int j = len - 1;
        int k = len - 1;
        while (i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }

        if (i >= 0) {
            while (i >= 0 && nums[i] >= nums[k]) {
                k--;
            }
            int tmp = nums[i];
            nums[i] = nums[k];
            nums[k] = tmp;
        }



        while (j < len) {
            int tmp = nums[j];
            nums[j] = nums[len-1];
            nums[len-1] = tmp;
            j++;
            len--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,8,5,7,6,4};
        Solution31 s = new Solution31();
        s.nextPermutation(nums);
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
