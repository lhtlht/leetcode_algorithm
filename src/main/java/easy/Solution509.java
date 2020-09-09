package easy;

public class Solution509 {
    /*
    509. 斐波那契数
    斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：

    F(0) = 0,   F(1) = 1
    F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
    给定 N，计算 F(N)。
     */
    public int fib(int N) {
        if (N < 2) return N;


        int dp_0 = 0;
        int dp_1 = 1;
        int dp_01 = 1;
        for (int i=2; i<=N; i++) {
            dp_01 = dp_0 + dp_1;
            dp_0 = dp_1;
            dp_1 = dp_01;

        }
        return dp_01;
    }
}
