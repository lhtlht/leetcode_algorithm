package easy;

public class Solution1342 {
    public static int numberOfSteps (int num) {
        /**
         * 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
         */
        int res = 0;
        while (num>0) {
            if ((num&1) == 1) {
                num -= 1;
            } else {
                num /= 2;
            }
            res ++;
        }
        return res;
    }

    public static void main(String[] args) {
        int num1 = 14;
        int num2 = 8;
        System.out.println(Solution1342.numberOfSteps(num1)); //6
        System.out.println(Solution1342.numberOfSteps(num2)); //4
    }
}
