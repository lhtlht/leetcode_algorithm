package medium;

public class Solution718 {
    /*
    718. 最长重复子数组
    给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。



    示例：

    输入：
    A: [1,2,3,2,1]
    B: [3,2,1,4,7]
    输出：3
    解释：
    长度最长的公共子数组是 [3, 2, 1] 。
     */
    public int findLength(int[] A, int[] B) {
        int a = A.length;
        int b = B.length;
        int res = 0;
        int[][] dp = new int[a+1][b+1];
        for (int i=1; i<=a; i++) {
            for (int j=1; j<=b; j++) {
                if (A[i-1]==B[j-1]) {
                    dp[i][j] = dp[i-1][j-1]+1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
