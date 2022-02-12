package easy;

public class PRO59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int p = 1;

        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n-1;
        while (left <= right && top <= bottom) {
            for (int col=left; col<=right; col++){
                matrix[top][col] = p;
                p++;
            }
            for (int row=top+1; row<=bottom; row++){
                matrix[row][right] = p;
                p++;
            }
            if (left < right && top < bottom) {
                for (int col=right-1; col>left; col--){
                    matrix[bottom][col] = p;
                    p++;
                }
                for (int row=bottom; row>top; row--){
                    matrix[row][left] = p;
                    p++;
                }
            }
            top++;
            bottom--;
            left++;
            right--;
        }


        return matrix;
    }

    public static void main(String[] args) {
        PRO59 p = new PRO59();

        int[][] matrix = p.generateMatrix(3);
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
