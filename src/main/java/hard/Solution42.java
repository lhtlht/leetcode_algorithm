package hard;

public class Solution42 {
    /*
    42. 接雨水
    给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     */

    public int trap(int[] height) {
        int len = height.length;
        int sum = 0;
        for (int i=1; i<len-1; i++) {
            int maxLeft = 0;
            int maxRight = 0;

            for (int l=0; l<i; l++) {
                if (height[l] > maxLeft) {
                    maxLeft = height[l];
                }
            }

            for (int l=i+1; l<len; l++) {
                if (height[l] > maxRight) {
                    maxRight = height[l];
                }
            }

            if (height[i] < Math.min(maxLeft, maxRight)) {
                sum += Math.min(maxLeft, maxRight) - height[i];
            }
        }
        return sum;
    }

    public int trap2(int[] height) {
        int len = height.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        for (int i=1; i<len-1; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
        }

        for (int i=len-2; i>=1; i--) {
            maxRight[i] = Math.max(maxRight[i+1], height[i+1]);
        }

        int sum = 0;
        for (int i=1; i<len-1; i++) {

            if (height[i] < Math.min(maxLeft[i], maxRight[i])) {
                sum += Math.min(maxLeft[i], maxRight[i]) - height[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        Solution42 s = new Solution42();
        System.out.println(s.trap2(nums)); //6
    }
}
