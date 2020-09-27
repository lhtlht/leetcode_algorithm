package jianzhi_offer;

public class Solution04 {
    /*
    剑指 Offer 04. 二维数组中的查找
    在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。



    示例:

    现有矩阵 matrix 如下：

    [
      [1,   4,  7, 11, 15],
      [2,   5,  8, 12, 19],
      [3,   6,  9, 16, 22],
      [10, 13, 14, 17, 24],
      [18, 21, 23, 26, 30]
    ]
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;

        int i = m-1;
        int j = 0;
        while (i >= 0 && j < n) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target > matrix[i][j]) {
                j++;
            } else {
                i--;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Solution04 s = new Solution04();
        System.out.println(s.findNumberIn2DArray(new int[][] {{1,   4,  7, 11, 15}, {2,   5,  8, 12, 19}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5)); //true
        System.out.println(s.findNumberIn2DArray(new int[][] {{1,   4,  7, 11, 15}, {2,   5,  8, 12, 19}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 20)); //false

    }
}
