package medium;

public class Solution79 {
    /*
    79. 单词搜索
    给定一个二维网格和一个单词，找出该单词是否存在于网格中。

    单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。



    示例:

    board =
    [
      ['A','B','C','E'],
      ['S','F','C','S'],
      ['A','D','E','E']
    ]

    给定 word = "ABCCED", 返回 true
    给定 word = "SEE", 返回 true
    给定 word = "ABCB", 返回 false
     */
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] words = word.toCharArray();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == words[0]) {
                    boolean[][] used = new boolean[m][n];
                    if(search(board, words, m, n, i, j, 0, used)) return true;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, char[] words, int m, int n, int i, int j, int index, boolean[][] used) {
        if (index == words.length) {
            return true;
        }
        if (i < 0 || i > m-1 || j < 0 || j > n-1 || used[i][j] || board[i][j] != words[index]) {
            return false;
        }
        used[i][j] = true;
//        return  search(board, words, m, n, i+1, j, index+1, used) ||
//                search(board, words, m, n, i-1, j, index+1, used) ||
//                search(board, words, m, n, i, j+1, index+1, used) ||
//                search(board, words, m, n, i, j-1, index+1, used);

        boolean a1 = search(board, words, m, n, i+1, j, index+1, used);
        if (a1) return true;
        boolean a2 = search(board, words, m, n, i-1, j, index+1, used);
        if (a2) return true;
        boolean a3 = search(board, words, m, n, i, j+1, index+1, used);
        if (a3) return true;
        boolean a4 = search(board, words, m, n, i, j-1, index+1, used);
        if (a4) return true;
        used[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        Solution79 s = new Solution79();
        System.out.println(s.exist(new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED")); //true
        System.out.println(s.exist(new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE")); //true
        System.out.println(s.exist(new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB")); //false
        System.out.println(s.exist(new char[][] {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}}, "ABCESEEEFS")); //true
    }
}
