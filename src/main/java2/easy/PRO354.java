package easy;

import java.util.Arrays;
import java.util.Comparator;

public class PRO354 {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0]? o2[1]-o1[1]:o1[0]-o2[0];
            }
        });

        int[] height = new int[n];
        for (int i=0; i<n; i++) {
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);

    }

    public int lengthOfLIS(int[] nums) {
        int res = 1;
        int[] dp = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            dp[i] = 1;
            for (int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
