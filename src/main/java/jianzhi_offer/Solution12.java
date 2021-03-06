package jianzhi_offer;

public class Solution12 {
    /*
    剑指 Offer 12. 矩阵中的路径
    请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。

    [["a","b","c","e"],
    ["s","f","c","s"],
    ["a","d","e","e"]]

    但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。



    示例 1：

    输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
    输出：true
    示例 2：

    输入：board = [["a","b"],["c","d"]], word = "abcd"
    输出：false
     */

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] flag = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if(dfs(board, m, n, flag, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int m, int n, boolean[][] flag, int i, int j, String word, int index) {
        if (i<0 || i>m-1 || j<0 || j>n-1 || flag[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length()-1) {
            return true;
        }
        flag[i][j] = true;
        index++;
        boolean res = dfs(board, m,n,flag, i+1, j, word, index) || dfs(board, m,n,flag, i-1, j, word, index) || dfs(board, m,n,flag, i, j-1, word, index) || dfs(board, m,n,flag, i, j+1, word, index);
        flag[i][j] = false;
        return res;
    }

    public static void main(String[] args) {
        Solution12 s = new Solution12();
        System.out.println(s.exist(new char[][] {{'a','b'}, {'c','d'}}, "abcd")); //fasle
        System.out.println(s.exist(new char[][] {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}}, "ABCCED")); //true
        System.out.println(s.exist(new char[][] {{'C','A','A'}, {'A','A','A'}, {'B','C','D'}}, "AAB")); //true
    }
}
