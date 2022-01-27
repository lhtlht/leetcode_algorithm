package easy;

public class PRO48 {
    public void rotate(int[][] matrix) {
        //先对斜翻转
        int n = matrix.length;
        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        //再左右翻转
        for (int i=0; i<n; i++) {
            for (int j=0; j<n/2; j++) {
                int k = n-1-j;
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = tmp;
            }
        }

    }

    public static void main(String[] args) {
        PRO48 p = new PRO48();
        int[][] ma = new int[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        p.rotate(ma);
        int n = ma.length;
        int m = ma[0].length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                System.out.print(ma[i][j] + " ");
            }
            System.out.println();
        }
    }
}
