package easy;

import java.util.Arrays;

public class Solution66 {
    /*
    66. 加一
    给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

    最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

    你可以假设除了整数 0 之外，这个整数不会以零开头。

    示例 1:

    输入: [1,2,3]
    输出: [1,2,4]
    解释: 输入数组表示数字 123。
    示例 2:

    输入: [4,3,2,1]
    输出: [4,3,2,2]
    解释: 输入数组表示数字 4321。
     */

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] res = new int[n+1];
        int move = 1;
        for (int i = n; i>=1; i--) {
            res[i] = (digits[i-1] + move ) % 10;
            move = (digits[i-1] + move ) / 10;
        }
        res[0] = move;
        if (move == 0) {
            int[] newRes = new int[n];
            for (int i=1; i<n+1; i++) {
                newRes[i-1] = res[i];
            }
            return newRes;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] dig1 = {1,2,3};
        int[] dig2 = {1,2,9};
        Solution66 s = new Solution66();
        int[] res = s.plusOne(dig1);
        int[] res2 = s.plusOne(dig2);

        for (int i:res) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i:res2) {
            System.out.print(i + " ");
        }
    }
}
