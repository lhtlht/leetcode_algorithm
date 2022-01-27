package easy;

public class PRO1646 {
    public int getMaximumGenerated(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        int res = 0;
        for (int i=2; i<=n; i++) {
            if(i%2 == 0) {
                dp[i] = dp[i/2];
            } else {
                dp[i] = dp[(i-1)/2]+dp[(i-1)/2+1];
            }
            res = Math.max(res, dp[i]);
        }
        return res;

    }

    public static void main(String[] args) {
        PRO1646 p = new PRO1646();
        System.out.println(p.getMaximumGenerated(7));
    }
}
