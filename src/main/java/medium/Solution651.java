package medium;

public class Solution651 {
    /**
     * 651. 4键键盘
     * 假设你有一个特殊的键盘包含下面的按键：
     *
     * Key 1: (A)：在屏幕上打印一个 'A'。
     *
     * Key 2: (Ctrl-A)：选中整个屏幕。
     *
     * Key 3: (Ctrl-C)：复制选中区域到缓冲区。
     *
     * Key 4: (Ctrl-V)：将缓冲区内容输出到上次输入的结束位置，并显示在屏幕上。
     *
     * 现在，你只可以按键 N 次（使用上述四种按键），请问屏幕上最多可以显示几个 'A'呢？
     *
     * 样例 1:
     *
     * 输入: N = 3
     * 输出: 3
     * 解释:
     * 我们最多可以在屏幕上显示三个'A'通过如下顺序按键：
     * A, A, A
     *
     *
     * 样例 2:
     *
     * 输入: N = 7
     * 输出: 9
     * 解释:
     * 我们最多可以在屏幕上显示九个'A'通过如下顺序按键：
     * A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V
     */
    public int maxA(int N) {
        //3种状态 剩余操作次数N，屏幕上A的数量aNum, 剪切板A的数量copy
        return dp(N, 0, 0);
    }

    public int dp(int n, int aNum, int copy) {
        if (n <= 0) return aNum;
        return Math.max(Math.max(
                dp(n-1, aNum+1, copy), //按下A
                dp(n-1, aNum+copy, copy) //按住啊ctrl+v
        ), dp(n-2, aNum,aNum)); //按下ctrl+a ctrl+c
    }

    public int maxA2(int N) {
        //1种状态
        int[] dp = new int[N+1];
        dp[0] = 0;
        for (int i=1; i<=N; i++) {
            dp[i] = dp[i-1]+1; //按下A
            for (int j=2; j<i; j++) { //按下CA、CC、CV
                dp[i] = Math.max(dp[i], dp[j-2]*(i-j+1));
            }
        }

        return dp[N];
    }

    public static void main(String[] args) {
        int N1 = 3;
        int N2 = 7;



        Solution651 s = new Solution651();
        System.out.println(s.maxA(N1)); //3
        System.out.println(s.maxA(N2)); //9
        System.out.println(s.maxA2(N1)); //3
        System.out.println(s.maxA2(N2)); //9
    }


}
