package hard;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution51 {
    /**
     * N queen
     *
     */

    private static List<String> charToString(char[][] array) {
        List<String> result = new LinkedList<String>();
        for (char[] chars : array) {
            result.add(String.valueOf(chars));
        }
        return result;
    }


    List<List<String>> res = new LinkedList<List<String>>();

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0)  return null;
        char[][] board = new char[n][n];
        for (char[] chars:board) Arrays.fill(chars,'.');
        trackback(board, 0);
        return res;
    }

    /**
     * 路径：board中小于row的那些行已经放置了Q
     * 可选择列表：第row行的所有列
     * 结束条件：row超过board的最后一行
     * @param board
     * @param row
     */
    public void trackback(char[][] board, int row) {
        if (row==board.length) {
            res.add(charToString(board));
            return;
        }
        int n = board[row].length;//列数
        for (int col=0; col<n; col++) {
            //valid selet
            if (!isValid(board,row,col)) continue;
            //do select
            board[row][col] = 'Q';
            trackback(board, row+1);
            //
            board[row][col] = '.';
        }
    }

    public boolean isValid(char[][] board, int row, int col) {
        int rows = board.length;
        for (char[] chars:board) if (chars[col] == 'Q') return false;

        for (int i = row-1, j = col+1; i>=0&&j<rows; i--,j++) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = row-1, j = col-1; i>=0&&j>=0; i--,j--) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution51 s = new Solution51();
        System.out.println(s.solveNQueens(4));


    }
}
