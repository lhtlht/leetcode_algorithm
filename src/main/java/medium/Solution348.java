package medium;

public class Solution348 {
    class TicTacToe {
        int n;
        int[] rows, cols, dig;
        /** Initialize your data structure here. */
        public TicTacToe(int n) {
            this.n = n;
            rows = new int[n];
            cols = new int[n];
            dig = new int[2];
        }

        /** Player {player} makes a move at ({row}, {col}).
         @param row The row of the board.
         @param col The column of the board.
         @param player The player, can be either 1 or 2.
         @return The current winning condition, can be either:
         0: No one wins.
         1: Player 1 wins.
         2: Player 2 wins. */
        public int move(int row, int col, int player) {
            if (player == 1) {
                rows[row]++;
                cols[col]++;
                if (row == col) dig[0]++;
                if (row + col == this.n-1) dig[1]++;
            }

            if (player == 2) {
                rows[row]--;
                cols[col]--;
                if (row == col) dig[0]--;
                if (row + col == this.n-1) dig[1]--;
            }

            if (rows[row] == this.n || cols[col]==this.n || dig[0]==this.n || dig[1] == this.n) return 1;
            if (rows[row] == this.n*-1 || cols[col]==this.n*-1 || dig[0]==this.n*-1 || dig[1] == this.n*-1) return 2;
            return 0;


        }
    }
}
