package medium;

public class Solution48 {
    /*
    48. 旋转图像
    给定一个 n × n 的二维矩阵表示一个图像。

    将图像顺时针旋转 90 度。

    说明：

    你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //转置
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        //左右翻转
        for (int i=0; i<n; i++) {
            for (int j=0; j<n/2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = tmp;
            }
        }

    }


    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        Solution48 s = new Solution48();
        s.rotate(matrix);
        for (int[] rows : matrix) {
            System.out.println(rows[0] + " " + rows[1] + " " + rows[2]);
        }
    }
}
