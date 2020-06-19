package easy;

public class Solution1313 {
    /**
     * 1313. 解压缩编码列表
     * 给你一个以行程长度编码压缩的整数列表 nums 。

     考虑每对相邻的两个元素 [freq, val] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后子列表中有 freq 个值为 val 的元素，你需要从左到右连接所有子列表以生成解压后的列表。

     请你返回解压后的列表。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/decompress-run-length-encoded-list
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static int[] decompressRLElist(int[] nums) {
        int resLen = 0;
        for (int i=0; i<nums.length/2; i++) {
            resLen += nums[2*i];
        }
        int[] res = new int[resLen];
        resLen = 0;
        for (int i=0; i<nums.length/2; i++) {
            int tmp = resLen;
            for (int j=tmp; j<nums[2*i]+tmp; j++) {
                res[j] = nums[2*i+1];
                resLen ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] res = Solution1313.decompressRLElist(nums);
        for (int i=0; i<res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }
}
