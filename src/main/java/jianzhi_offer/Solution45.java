package jianzhi_offer;

public class Solution45 {
    /*
    剑指 Offer 45. 把数组排成最小的数
    输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。



    示例 1:

    输入: [10,2]
    输出: "102"
    示例 2:

    输入: [3,30,34,5,9]
    输出: "3033459"
     */

    public String minNumber(int[] nums) {
        //快排
        //
        String[] strs = new String[nums.length];
        for (int i = 0; i<nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        quickSort(strs, 0, nums.length-1);

        StringBuffer res = new StringBuffer();
        for (String s : strs) {
            res.append(s);
        }
        return res.toString();
    }

    public void quickSort(String[] strs, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) return;
        String tmp = strs[leftIndex];
        int i = leftIndex;
        int j = rightIndex;
        while (i < j) {
            while ((strs[j] + tmp).compareTo(tmp + strs[j]) >= 0 && i < j) {
                //j+tmp > tmp+j  ==>> tmp<j
                j--;
            }
            strs[i] = strs[j];
            while ((tmp+strs[i]).compareTo(strs[i]+tmp) >= 0 && i<j) {
                i++;
            }
            strs[j] = strs[i];
        }
        strs[i] = tmp;
        quickSort(strs, leftIndex, i-1);
        quickSort(strs, i+1, rightIndex);
    }

    public static void main(String[] args) {
        Solution45 s = new Solution45();
        System.out.println(s.minNumber(new int[] {10,2}));
        System.out.println(s.minNumber(new int[] {3,30,34,5,9}));
    }
}
