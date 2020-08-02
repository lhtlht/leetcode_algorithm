package medium;

public class Solution73 {
    /*
    73. 矩阵置零
    给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
     */

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == 0) {
                    //如果一个元素为 0，则将其所在行和列的所有元素都设为 0
                    for (int k=0; k<n; k++) {
                        if (matrix[i][k] != 0) matrix[i][k] = -10000;

                    }
                    for (int p = 0; p<m; p++) {
                        if (matrix[p][j] != 0) matrix[p][j] = -10000;
                    }
                }
            }
        }


        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == -10000) {
                    matrix[i][j] = 0;
                }
            }
        }
    }



    public static void main(String[] args) {
        int[][] m1 = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] m2 = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        Solution73 s = new Solution73();
        s.setZeroes(m1);
        s.setZeroes(m2);

        for (int i=0; i<m1.length; i++) {
            for (int j=0; j<m1[0].length; j++) {
                System.out.print(m1[i][j] + " ");
            }
            System.out.println();
        }

        for (int i=0; i<m2.length; i++) {
            for (int j=0; j<m2[0].length; j++) {
                System.out.print(m2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
