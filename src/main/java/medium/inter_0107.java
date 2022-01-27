package medium;

public class inter_0107 {
    /*
    面试题 01.07. 旋转矩阵
    给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。

    不占用额外内存空间能否做到？
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int j=0; j<n/2; j++) {
            for (int i=0; i<n; i++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = tmp;
            }

        }
    }

    public static void main(String[] args) {
        inter_0107 s = new inter_0107();
        int[][] matrix = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
    }
}
