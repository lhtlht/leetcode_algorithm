package medium;

import java.util.Arrays;
import java.util.Comparator;

public class Solution593 {
    /*
    593. 有效的正方形
    给定二维空间中四点的坐标，返回四点是否可以构造一个正方形。

    一个点的坐标（x，y）由一个有两个整数的整数数组表示。

    示例:

    输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
    输出: True


    注意:

    所有输入整数都在 [-10000，10000] 范围内。
    一个有效的正方形有四个等长的正长和四个等角（90度角）。
    输入点没有顺序。
     */

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p = {p1,p2,p3,p4};
        Arrays.sort(p, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1]-o2[1] : o1[0]-o2[0];
            }
        });
        return dist(p[0],p[1]) != 0 && dist(p[0],p[1]) == dist(p[1],p[3]) && dist(p[1],p[3]) == dist(p[3],p[2]) && dist(p[3],p[2]) == dist(p[2],p[0]) && dist(p[0],p[3]) == dist(p[1],p[2]);

    }
    public double dist(int[] p1, int[] p2) {
        return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0]);
    }
    public static void main(String[] args) {
        Solution593 s = new Solution593();
        System.out.println(s.validSquare(new int[] {0,0}, new int[] {1,1}, new int[] {1,0}, new int[] {0,1})); //true
        System.out.println(s.validSquare(new int[] {0,0}, new int[] {1,1}, new int[] {1,0}, new int[] {0,1})); //true

    }
}
