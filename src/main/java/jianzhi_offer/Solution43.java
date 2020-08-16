package jianzhi_offer;

import medium.Solution3;

public class Solution43 {
    /*
    剑指 Offer 43. 1～n整数中1出现的次数
    输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。

    例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。



    示例 1：

    输入：n = 12
    输出：5
    示例 2：

    输入：n = 13
    输出：6

    限制：

    1 <= n < 2^31
     */
    public int countDigitOne(int n) {
        int count = 0;
        int curr = 1;
        int mod;
        int digit = 1;
        while (curr > 0) {
            int chushu = (int)Math.pow(10,digit);
            curr = n / chushu;
            mod = n % chushu;
            if (mod < chushu/10) {
                count += curr * (chushu/10);
            } else if (mod >= chushu/10 && mod < chushu/10*2) {
                count += curr * (chushu/10) + mod+1-chushu/10;
            } else {
                count += (curr+1) * (chushu/10);
            }
            System.out.println("curr:"+curr + ",mode:"+mod + "count:" + count);
            digit++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution43 s = new Solution43();
        System.out.println(s.countDigitOne(1410065408)); //1737167499
        //System.out.println(s.countDigitOne(2012)); //1605
        //System.out.println(s.countDigitOne(12)); //5
        //System.out.println(s.countDigitOne(13)); //6
    }
}
