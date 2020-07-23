package easy;

public class Solution326 {
    /*
    326. 3的幂
    给定一个整数，写一个函数来判断它是否是 3 的幂次方。

    示例 1:

    输入: 27
    输出: true
    示例 2:

    输入: 0
    输出: false
    示例 3:

    输入: 9
    输出: true
    示例 4:

    输入: 45
    输出: false

    进阶：你能不使用循环或者递归来完成本题吗？
     */

    public boolean isPowerOfThree(int n) {
        while (n>1) {
            if (n%3 == 0) {
                n /= 3;
            } else {
                return false;
            }
        }
        return n==1;
    }

    public boolean isPowerOfThree2(int n) {
        if (n == 0) return false;
        double a = Math.log10(n) / Math.log10(3);
        int b = (int)a;
        return a==b;
    }

    public static void main(String[] args) {
        int n1 = 27;
        int n2 = 0;
        int n3 = 9;
        int n4 = 45;
        Solution326 s = new Solution326();
        System.out.println(s.isPowerOfThree(n1)); //true
        System.out.println(s.isPowerOfThree(n2)); //false
        System.out.println(s.isPowerOfThree(n3)); //true
        System.out.println(s.isPowerOfThree(n4)); //false
        System.out.println("-------------------------------");
        System.out.println(s.isPowerOfThree2(n1)); //true
        System.out.println(s.isPowerOfThree2(n2)); //false
        System.out.println(s.isPowerOfThree2(n3)); //true
        System.out.println(s.isPowerOfThree2(n4)); //false

        double a = 2.0;
        int b = (int)a;
        System.out.println(a==b);
    }
}
