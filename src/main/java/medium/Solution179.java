package medium;

import java.util.Arrays;
import java.util.Comparator;

public class Solution179 {
    /*
    179. 最大数
    给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。

    示例 1:

    输入: [10,2]
    输出: 210
    示例 2:

    输入: [3,30,34,5,9]
    输出: 9534330
    说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     */

    public String largestNumber(int[] nums) {
        String[] numstr = new String[nums.length];
        for (int i=0; i<nums.length; i++) {
            numstr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numstr, new Comparator<String>() {
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        });

        String res = "";
        if (numstr[0].equals("0")) {
            return "0";
        }
        for (String s : numstr) {
            res += s;
        }


        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {10,2};
        int[] nums2 = {3,30,34,5,9};
        int[] nums3 = {0,0};
        Solution179 s = new Solution179();
        System.out.println(s.largestNumber(nums1)); //210
        System.out.println(s.largestNumber(nums2)); //9534330
        System.out.println(s.largestNumber(nums3)); //0

    }
}
