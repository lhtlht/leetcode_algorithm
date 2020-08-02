package medium;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {
    /*
    54. 螺旋矩阵
    给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

    示例 1:

    输入:
    [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
    ]
    输出: [1,2,3,6,9,8,7,4,5]
    示例 2:

    输入:
    [
      [1, 2, 3, 4],
      [5, 6, 7, 8],
      [9,10,11,12]
    ]
    输出: [1,2,3,4,8,12,11,10,9,5,6,7]
     */

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int count = (Math.min(m,n)+1)/2;
        int i = 0;
        while (i < count) {
            for (int j=i; j<n-i; j++ ) {
                res.add(matrix[i][j]);
            }
            for (int j=i+1; j<m-i; j++) {
                res.add(matrix[j][n-1-i]);
            }

            for (int j=n-1-i-1; j>=i && (m-1-i != i); j--) {
                res.add(matrix[m-1-i][j]);
            }

            for (int j=m-1-i-1; j>=i+1 && (n-1-i != i); j--) {
                res.add(matrix[j][i]);
            }
            i++;
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] m = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9,10,11,12}
            };

        Solution54 s = new Solution54();
        System.out.println(s.spiralOrder(m));
    }

}
