package easy;

public class Solution1470 {
    public static int[] shuffle(int[] nums, int n) {
        /**
         * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。

         请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。

         来源：力扣（LeetCode）
         链接：https://leetcode-cn.com/problems/shuffle-the-array
         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

         输入：nums = [2,5,1,3,4,7], n = 3
         输出：[2,3,5,4,1,7]
         解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]

         */
        int[] res = new int[nums.length];
        int mid = nums.length/2;
        for (int i=0; i<mid; i++) {
            res[i*2] = nums[i];
            res[i*2+1] = nums[i+mid];
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {2,5,1,3,4,7};
        int n = 3;
        int[] res = Solution1470.shuffle(nums, n);
        for (int i=0; i<res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
