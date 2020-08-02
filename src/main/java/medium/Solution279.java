package medium;

import java.util.Arrays;

public class Solution279 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,n); //初始化，最大为n本身
        dp[0] = 0;
        dp[1] = 1;

        for (int i=2; i<=n; i++) {
            for (int j=1; j*j<=i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        for (int i=0; i<n+1; i++) {
            System.out.print(dp[i] + " ");
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution279 s = new Solution279();
        System.out.println(s.numSquares(12)); //3
        System.out.println(s.numSquares(13)); //2
    }
}
