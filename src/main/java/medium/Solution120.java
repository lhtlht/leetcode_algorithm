package medium;

import sun.nio.cs.ext.MacArabic;

import java.util.ArrayList;
import java.util.List;

public class Solution120 {
    /*
    120. 三角形最小路径和
    给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

    相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。



    例如，给定三角形：

    [
         [2],
        [3,4],
       [6,5,7],
      [4,1,8,3]
    ]
    自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。



    说明：

    如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
     */
    int target = Integer.MAX_VALUE;
    public int minimumTotal(List<List<Integer>> triangle) {
        int levels = triangle.size();

        dfs(triangle, levels, 0, 0, 0);
        return target;
    }

    public void dfs(List<List<Integer>> triangle, int levels, int level, int index, int sum) {
        if (index < 0 || index > level) {
            return;
        }
        if (level == levels) {
            target = Math.min(target, sum);
            return;
        }
        sum += triangle.get(level).get(index);
        dfs(triangle, levels, level+1, index, sum);
        dfs(triangle, levels, level+1, index+1, sum);
    }


    public int minimumTotal2(List<List<Integer>> triangle) {

        int levels = triangle.size();
        int[][] dp = new int[levels][levels];
        dp[0][0] = triangle.get(0).get(0);
        for (int i=1; i<levels; i++) {
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);
        }
        int res = Math.min(dp[levels-1][0], dp[levels-1][levels-1]);
        for (int i=2; i<levels; i++) {
            for (int j=1; j<=i-1; j++) {
                dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);
                if (i == levels-1) {
                    res = Math.min(res, dp[i][j]);
                }


            }
        }
        return res;

    }

    public int minimumTotal3(List<List<Integer>> triangle) {
        int levels = triangle.size();
        int[][] dp = new int[levels][levels];
        dp[0][0] = triangle.get(0).get(0);
        int res = Integer.MAX_VALUE;
        for (int i=1; i<levels; i++) {
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            for (int j=1; j<=i-1; j++) {
                dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);
        }

        for (int i=0; i<levels; i++) {
            res = Math.min(res, dp[levels-1][i]);
        }
        return res;
    }

    public int minimumTotal4(List<List<Integer>> triangle) {
        int levels = triangle.size();
        if (levels == 1) return triangle.get(0).get(0);
        if (levels == 2) return Math.min(triangle.get(0).get(0)+triangle.get(1).get(0), triangle.get(0).get(0)+triangle.get(1).get(1));
        int[] dp = new int[levels];
        dp[0] = triangle.get(0).get(0)+triangle.get(1).get(0);
        dp[1] = triangle.get(0).get(0)+triangle.get(1).get(1);

        for (int i=2; i<levels; i++) {
            dp[i] = dp[i-1] + triangle.get(i).get(i);
            for (int j=i-1; j>=1; j--) {
                dp[j] = Math.min(dp[j], dp[j-1]) + triangle.get(i).get(j);
            }
            dp[0] = dp[0] + triangle.get(i).get(0);
        }
        int res = Integer.MAX_VALUE;
        for (int i=0; i<levels; i++) {
            res = Math.min(res, dp[i]);
        }
        return res;
    }


    public static void main(final String[] args) {
        Solution120 s = new Solution120();
        List<List<Integer>> triangle = new ArrayList<List<Integer>>() {{
           add(new ArrayList<Integer>() {{
               add(2);
           }});
            add(new ArrayList<Integer>() {{
                add(3);
                add(4);
            }});
            add(new ArrayList<Integer>() {{
                add(6);
                add(5);
                add(7);
            }});
            add(new ArrayList<Integer>() {{
                add(4);
                add(1);
                add(8);
                add(3);
            }});
        }};

        List<List<Integer>> triangle2 = new ArrayList<List<Integer>>() {{
            add(new ArrayList<Integer>() {{
                add(-1);
            }});
            add(new ArrayList<Integer>() {{
                add(-2);
                add(-3);
            }});
        }};

        System.out.println(triangle2);
        System.out.println(s.minimumTotal4(triangle));
    }
}
