package medium;

public class Solution357 {
    /*
    357. 计算各个位数不同的数字个数
    给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。

    示例:

    输入: 2
    输出: 91
    解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
     */

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 10;
        }


        int count = 10;
        int mul = 9;
        int muls = 9;
        for (int i=2; i<=n; i++) {
            muls *= (mul--);
            count += muls;
        }
        return count;
    }
    public static void main(String[] args) {
        Solution357 s = new Solution357();
        //System.out.println(s.countNumbersWithUniqueDigits(0)); // 1
        //System.out.println(s.countNumbersWithUniqueDigits(1)); //9
        System.out.println(s.countNumbersWithUniqueDigits(2)); //91 = 10*9+1 = 9*9+9+1
        System.out.println(s.countNumbersWithUniqueDigits(3)); //739 = 9*9*8+91 =
    }
}
