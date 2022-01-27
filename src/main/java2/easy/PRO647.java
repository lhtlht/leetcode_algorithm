package easy;

public class PRO647 {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i=0; i<n; i++) {
            dp[i][i] = true;
        }
        int res = n;
        for (int i=n-2; i>=0; i--) {
            for (int j=i+1; j<n; j++) {
                if (s.charAt(i) == s.charAt(j) && (dp[i+1][j-1] || j-i<2)) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PRO647 p = new PRO647();
        System.out.println(p.countSubstrings("aaa"));
    }
}
