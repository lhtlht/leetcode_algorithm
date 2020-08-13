package jianzhi_offer;

import java.util.ArrayList;

public class Solution56 {
    /*
    剑指 Offer 56 - I. 数组中数字出现的次数
一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。



示例 1：

输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]
示例 2：

输入：nums = [1,2,10,4,1,4,3,3]
输出：[2,10] 或 [10,2]
     */

    public int[] singleNumbers(int[] nums) {
        //全部数一起异或，得出最终答案的a^b = x
        int x = 0;
        for (int num : nums) {
            x ^= num;
        }


        int div = 1;
        while ((div & x) == 0) { //对应的位置有2个1才是1，不然为0， 找出第一个为1的位置
            div <<= 1; //向左移
        }
        //对数组实行根据div进行分组
        int a = 0;
        int b = 0;
        for (int n : nums) {
            if ((div & n) == n) {  //这表示对应位置相同
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[] {a,b};
    }


    public int[] singleNumbers2(int[] nums) {
        int x = 0; //初始化为0  0^任何数=本身
        for (int n : nums) {
            x ^= n;
        }

        int div = 1;
        while ((div & x) == 0) {
            div <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int n : nums) {
            if ((n & div) == div) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[] {a,b};

    }
    public static void main(String[] args) {
        int[] nums = {1,2,5,2};
        Solution56 s = new Solution56();
        int[] res = s.singleNumbers2(nums);
        System.out.println(res[0] + " " + res[1]);
    }
}
