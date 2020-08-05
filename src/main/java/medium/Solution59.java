package medium;

public class Solution59 {
    /*
    59. 螺旋矩阵 II
    给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

    示例:

    输入: 3
    输出:
    [
     [ 1, 2, 3 ],
     [ 8, 9, 4 ],
     [ 7, 6, 5 ]
    ]
     */

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int index = 1;
        int count = (n+1)/2;
        for (int k = 0; k<count; k++) {
            //保留起点
            for (int i=k; i<n-1-k; i++) { // 行不变
                res[k][i] = index;
                index++;
            }

            for (int i=k; i<(n-1)-k; i++) { //列不变
                res[i][n-1-k] = index;
                index++;
            }

            for (int i=n-1-k; i>=k+1; i--) { //行不变
                res[n-1-k][i] = index;
                index++;
            }

            for (int i=n-1-k; i>=k+1; i--) { //列不变
                res[i][k] = index;
                index++;
            }

        }
        if (n%2 == 1) {
            res[n/2][n/2] = n*n;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution59 s = new Solution59();
        int n = 2;
        int[][] res = s.generateMatrix(n);

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }

    }
}
