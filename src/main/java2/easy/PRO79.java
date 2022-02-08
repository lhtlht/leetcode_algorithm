package easy;

public class PRO79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] wa = word.toCharArray();
        int pl = wa.length-1;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == wa[0]) {
                    if (dfs(board, m, n, i, j, wa, 0, pl)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, int m, int n, int i, int j, char[] wa, int p, int pl) {
        if (i<0 || i>=m || j<0 || j>=n || board[i][j]=='0' || board[i][j]!=wa[p]){
            return false;
        }
        if (p == pl) {
            return true;
        }
        char c = board[i][j];
        board[i][j] = '0';
        p++;
        boolean res =  dfs(board, m, n, i-1, j, wa, p, pl) ||
                dfs(board, m, n, i+1, j, wa, p, pl) ||
                dfs(board, m, n, i, j-1, wa, p, pl) ||
                dfs(board, m, n, i, j+1, wa, p, pl);
        board[i][j] = c;
        return res;


        
    }

    public static void main(String[] args) {
        PRO79 p = new PRO79();
        System.out.println(p.exist(new char[][] {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'},
        },"ABCCED"));
    }

}
