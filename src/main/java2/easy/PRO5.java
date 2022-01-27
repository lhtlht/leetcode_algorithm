package easy;

public class PRO5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;

        String res = s.substring(0,1);
        int[][] dp = new int[n][n];
        for (int i=0; i<n; i++) {
            dp[i][i] = 1;
        }
        for (int i=n-2; i>=0; i--) {
            for (int j=i+1; j<n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        return res;

    }


    public String longestPalindrome2(String s) {
        int strLen = s.length();
        int left = 0;
        int right = 0;
        int len = 1;
        int maxStart = 0;
        int maxLen = 0;
        for (int i=0; i<strLen; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                left ++;
                len++;
            }
            while (right < strLen && s.charAt(right) == s.charAt(i)) {
                len ++;
                right++;
            }
            while (left >= 0 && right < strLen && s.charAt(right) == s.charAt(left)) {
                len = len + 2;
                left--;
                right++;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return s.substring(maxStart+1, maxStart+maxLen+1);

    }


    public String longestPalindrome3(String s) {
        int strLen = s.length();
        int maxStart = 0;
        int maxEnd = 0;
        int maxLen = 1;
        boolean[][] dp = new boolean[strLen][strLen];
        for (int r=1; r<strLen; r++) {
            for (int l=0; l<r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r-l<=2 || dp[l+1][r-1])) {
                    dp[l][r] = true;
                    if (r-l+1 > maxLen) {
                        maxLen = r-l+1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd+1);
    }

}
