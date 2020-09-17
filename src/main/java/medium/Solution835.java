package medium;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Solution835 {
    /*
    835. 图像重叠
    给出两个图像 A 和 B ，A 和 B 为大小相同的二维正方形矩阵。（并且为二进制矩阵，只包含0和1）。

    我们转换其中一个图像，向左，右，上，或下滑动任何数量的单位，并把它放在另一个图像的上面。之后，该转换的重叠是指两个图像都具有 1 的位置的数目。

    （请注意，转换不包括向任何方向旋转。）

    最大可能的重叠是什么？

    示例 1:

    输入：A = [[1,1,0],
              [0,1,0],
              [0,1,0]]
         B = [[0,0,0],
              [0,1,1],
              [0,0,1]]
    输出：3
    解释: 将 A 向右移动一个单位，然后向下移动一个单位。
     */
    public int largestOverlap(int[][] A, int[][] B) {
        Integer length = A.length;
        Integer max = 0;

        // 遍历所有偏移情况
        for (int offsetX = -A.length + 1; offsetX < length; offsetX++) {
            for (int offsetY = -A.length + 1; offsetY < length; offsetY++) {
                int count1 = 0;
                int count2 = 0;
                for (int i = 0; i + offsetX < length; i++) {
                    for (int j = 0; j + offsetY < length; j++) {
                        if (i < 0 || i >= length) continue;
                        if (j < 0 || j >= length) continue;
                        if (i + offsetX < 0 || i + offsetX >=length) continue;
                        if (j + offsetY < 0 || j + offsetY >=length) continue;
                        // 第二个矩阵B相对A向右偏移
                        if (A[i + offsetX][j + offsetY] == B[i][j] && B[i][j] == 1) count1++;

                        // 第二个矩阵B相对A向左偏移
                        // if (A[i][j] == B[i + offsetX][j + offsetY] && A[i][j] == 1) count2++;
                    }
                }
                System.out.println(count1 + " " + count2);
                max = Math.max(Math.max(count1, count2), max);
            }
        }
        return max;
    }
    public int check(int[][] a, int[][] b, int r, int c) {
        int x = 0;
        for (int i1 = r, i2 = 0; i1 < a.length && i2 < b.length; i1++, i2++) {
            for (int j1 = c, j2 = 0; j1 < a.length && i2 < b.length; j1++, j2++) {
                x += (a[i1][j1] & b[i2][j2]);
            }
        }
        return x;
    }
}
