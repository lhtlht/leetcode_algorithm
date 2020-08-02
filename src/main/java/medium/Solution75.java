package medium;

public class Solution75 {
    /*
    75. 颜色分类
    给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

    此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

    注意:
    不能使用代码库中的排序函数来解决这道题。

    示例:

    输入: [2,0,2,1,1,0]
    输出: [0,0,1,1,2,2]
    进阶：

    一个直观的解决方案是使用计数排序的两趟扫描算法。
    首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
    你能想出一个仅使用常数空间的一趟扫描算法吗？
     */

    public void sortColors2(int[] nums) {
        int[] d = new int[3];
        for (int i=0; i<nums.length; i++) {
            d[nums[i]]++;
        }
        int index = 0;
        for (int i=0; i<3; i++) {
            for (int j=0; j<d[i]; j++) {
                nums[index] = i;
                index++;
            }
        }
    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0;
        int p2 = n-1;
        int curr = 0;
        while (curr <= p2) {
            if (nums[curr] == 1) {
                curr++;
            } else if (nums[curr] == 0) {
                int tmp = nums[curr];
                nums[curr] = nums[p0];
                nums[p0] = tmp;
                p0++;
                curr++;
            } else {
                int tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2] = tmp;
                p2--;
            }
        }
    }
    public static void main(String[] args) {
        Solution75 s = new Solution75();
        int[] nums = {2,0,2,1,1,0};
        s.sortColors(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
