package jianzhi_offer;

import java.util.LinkedList;
import java.util.Stack;

public class Solution46 {
    /*
    剑指 Offer 46. 把数字翻译成字符串
给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。



示例 1:

输入: 12258
输出: 5
解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
     */

    public int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        Stack<Integer> nums = new Stack<Integer>();
        while (num > 0) {
            nums.push(num%10);
            num /= 10;
        }

        //0-25 对应合法
        int pre = nums.pop();
        int res = 1;
        int resp = 1;
        while (!nums.isEmpty()) {
            int n = nums.pop();
            int np = pre*10+n;
            if (np > 25 || pre == 0) {
                resp = res;
            } else {
                int tmp = res;
                res = res + resp;
                resp = tmp;
            }
            pre = n;

        }
        return res;
    }



    public int translateNum2(int num) {
        if (num < 10) {
            return 1;
        }
        if (num % 100 < 26 && num % 100 > 9) {
            return translateNum2(num/100) + translateNum2(num/10);
        } else {
            return translateNum2(num/10);
        }
    }

    public static void main(String[] args) {
        Solution46 s = new Solution46();
        System.out.println(s.translateNum(12258)); //5
        System.out.println(s.translateNum(506)); //1
        System.out.println(s.translateNum(0)); //1
        System.out.println(s.translateNum2(18822)); //4
    }



}
