package easy;

public class Solution172 {
    /*
    172. 阶乘后的零
    给定一个整数 n，返回 n! 结果尾数中零的数量。

    示例 1:

    输入: 3
    输出: 0
    解释: 3! = 6, 尾数中没有零。
    示例 2:

    输入: 5
    输出: 1
    解释: 5! = 120, 尾数中有 1 个零.
     */

    public int trailingZeroes(int n) {
        //只需要计算有多少个5就可以了
        int count = 0;
        while (n > 0) {
            count += n/5;
            n /= 5;
        }
        return count;
    }

    public int trailingZeroes2(int n) {
        int count = 0;
        while (n > 0) {
            count += n/5;
            n /= 5;
        }
        return count;
    }


    public static void main(String[] args) {
        Solution172 s = new Solution172();
        System.out.println(s.trailingZeroes(3)); //0
        System.out.println(s.trailingZeroes(5)); //1
    }
}
