package easy;

public class PRO70 {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int j = 1;
        int k = 2;
        int res = 0;
        for (int i=3; i<=n; i++) {
            res = j+k;
            j = k;
            k = res;
        }
        return res;
    }
}
