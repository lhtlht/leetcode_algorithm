package easy;

public class Solution1281 {
    /**
     * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
     * @param n
     * @return
     */
    public static int subtractProductAndSum(int n) {
        int s = 0;
        int m = 1;

        while (n>0) {
            s += n%10;
            m *= n%10;
            n /= 10;
        }
        return m-s;
    }

    public static void main(String[] args) {
        int n = 234;
        System.out.println(Solution1281.subtractProductAndSum(n)); //15
    }
}
