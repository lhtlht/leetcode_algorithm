package jianzhi_offer;

import java.util.ArrayList;
import java.util.List;

public class Solution29 {
    /*
    剑指 Offer 29. 顺时针打印矩阵
    输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。



    示例 1：

    输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
    输出：[1,2,3,6,9,8,7,4,5]
    示例 2：

    输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
    输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[] {};
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m*n];
        int i = 0;
        int count = (Math.min(m,n)+1)/2;
        int index = 0;
        while (i < count) {
            for (int j=i; j<n-i; j++) { //上
                res[index] = matrix[i][j];
                index++;
            }
            for (int j=i+1; j<m-i; j++) {//右
                res[index] = matrix[j][n-1-i];
                index++;
            }
            for (int j=n-1-i-1; j>=i && (m-1-i != i); j--) { //下
                res[index] = matrix[m-1-i][j];
                index++;
            }
            for (int j=m-1-i-1; j>=i+1 && (n-1-i) != i; j--) {
                res[index] = matrix[j][i];
                index++;
            }
            i++;
        }
        return res;

    }


}
