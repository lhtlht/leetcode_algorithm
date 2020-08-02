package medium;

public class Solution11 {
    /*
    11. 盛最多水的容器
    给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

    说明：你不能倾斜容器，且 n 的值至少为 2。
     */

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int i = 0;
        int j = height.length-1;
        int res = 0;
        while (i < j) {

            res = Math.max(res, Math.min(height[i], height[j])*(j-i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] hs = {1,8,6,2,5,4,8,3,7};
        Solution11 s = new Solution11();
        System.out.println(s.maxArea(hs));
    }
}
