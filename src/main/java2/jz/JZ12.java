package jz;

public class JZ12 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m == 0) return false;
        int n = board[0].length;
        int[][] help = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(board, i, j, m, n, word, 0, help)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, int m, int n, String word, int wi, int[][] help) {
        if(wi == word.length()) {
            return true;
        }
        if(i<0 || i>=m || j<0 || j>=n || help[i][j]==1 || board[i][j] != word.charAt(wi)) {
            return false;
        }
        help[i][j] = 1;
        wi++;

        boolean res = dfs(board, i-1, j, m, n, word, wi, help) ||
                dfs(board, i+1, j, m, n, word, wi, help) ||
                dfs(board, i, j-1, m, n, word, wi, help) ||
                dfs(board, i, j+1, m, n, word, wi, help);
        help[i][j] = 0;
        return res;
    }



    public static void main(String[] args) {
        JZ12 j = new JZ12();
        System.out.println(j.exist(new char[][] {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCED"));
        System.out.println(j.exist(new char[][] {
                {'a', 'b'},
                {'c', 'd'}
        }, "abcd"));
        System.out.println(j.exist(new char[][] {
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}
        }, "AAB")); //true
    }

}
