package medium;

public class Solution289 {
    /*
    289. 生命游戏
根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。

给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：

如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
     */

    public void gameOfLife(int[][] board) {
        if (board == null) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                int ar = around(board, i, j, m, n);
                int live = board[i][j];
                if (live == 1) {
                    if (ar < 2) {
                        board[i][j] = 3;
                    } else if (ar > 3) {
                        board[i][j] = 3;
                    }
                } else {
                    if (ar == 3) {
                        board[i][j] = 4;
                    }
                }
            }
        }
        //把状态3和4改为存活与否的1和0
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                int live = board[i][j];
                if (live == 3) {
                    board[i][j] = 0;
                } else if (live == 4){
                    board[i][j] = 1;
                }
            }
        }


    }

    public int around(int[][] board, int x, int y, int m, int n) {
        int aroundSum = 0;
        int[][] roundm = {{-1, 0, 1}, {-1, 0, 1}};
        for (int i=-1; i<=1; i++) {
            for (int j=-1; j<=1; j++) {
                //忽略本坐标
                if (i==0 && j==0) continue;
                //判断边界情况
                if (x+i < 0 || x+i > m-1 || y+j < 0 || y+j > n-1) continue;
                aroundSum += board[x+i][y+j]%2;
            }
        }
        return aroundSum;
    }

    public static void main(String[] args) {
        int[][] board = {{0,1,0}, {0,0,1}, {1,1,1}, {0,0,0}};
        Solution289 s = new Solution289();
        s.gameOfLife(board);
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }
}
