package jianzhi_offer;

public class Solution15 {
    /*
    剑指 Offer 15. 二进制中1的个数
    请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
     */

    public int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            if (n%2 == 1) {
                count++;
            }
            n /= 2;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution15 s = new Solution15();
        System.out.println(s.hammingWeight(9));
    }
}
