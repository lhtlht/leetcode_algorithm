package medium;

public class Solution74 {
    /*
    74. 搜索二维矩阵
    编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

    每行中的整数从左到右按升序排列。
    每行的第一个整数大于前一行的最后一个整数。
    示例 1:

    输入:
    matrix = [
      [1,   3,  5,  7],
      [10, 11, 16, 20],
      [23, 30, 34, 50]
    ]
    target = 3
    输出: true
    示例 2:

    输入:
    matrix = [
      [1,   3,  5,  7],
      [10, 11, 16, 20],
      [23, 30, 34, 50]
    ]
    target = 13
    输出: false
     */

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        int m = matrix.length;
        if (m < 1) return false;
        int n = matrix[0].length;
        if (n < 1) return false;
        int i = 0;
        int j = 0;
        while (i < m && matrix[i][0] <= target) {
            i++;
        }
        i--;
        if (i == -1) return false;
        while (j < n) {
            if (matrix[i][j] == target) {
                return true;
            } else {
                j++;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        Solution74 s = new Solution74();
        System.out.println(s.searchMatrix(new int[][] {{1,3,5,7}, {10,11,16,20}, {23,30,34,50}}, 3));
        System.out.println(s.searchMatrix(new int[][] {{1,3,5,7}, {10,11,16,20}, {23,30,34,50}}, 13));
        System.out.println(s.searchMatrix(new int[][] {{1,3,5,7}, {10,11,16,20}, {23,30,34,50}}, 23));
        System.out.println(s.searchMatrix(new int[][] {{1}}, 0));
    }

}
