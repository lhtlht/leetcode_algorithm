package medium;

public class Solution130 {
    /*
    130. 被围绕的区域
    给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

    找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     */

    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return;
        }
        int n = board[0].length;
        if (m <= 2 || n <= 2) {
            return;
        }
        //检索头尾两列
        for (int i=0; i<m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0, m, n);
            }
            if (board[i][n-1] == 'O') {
                dfs(board, i, n-1, m, n);
            }
        }
        //检索头尾两行
        for (int i=0; i<n; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i, m, n);
            }
            if (board[m-1][i] == 'O') {
                dfs(board, m-1, i, m, n);
            }
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

            }
        }

    }

    public void dfs(char[][] board, int i, int j, int m, int n) {
        if (i < 0 || i > m-1 || j < 0 || j > n-1) {
            return;
        }
        if (board[i][j] == 'X' || board[i][j] == '*') {
            return;
        }
        board[i][j] = '*';
        dfs(board, i-1, j, m, n);
        dfs(board, i+1, j, m, n);
        dfs(board, i, j-1, m, n);
        dfs(board, i, j+1, m, n);
    }

    public static void main(String[] args) {
        Solution130 s = new Solution130();

        char[][] m = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        s.solve(m);

        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }

    }
}
