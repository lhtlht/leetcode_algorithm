package medium;

public class Solution490 {
    /*
    490. 迷宫
    由空地和墙组成的迷宫中有一个球。球可以向上下左右四个方向滚动，但在遇到墙壁前不会停止滚动。当球停下时，可以选择下一个方向。

    给定球的起始位置，目的地和迷宫，判断球能否在目的地停下。

    迷宫由一个0和1的二维数组表示。 1表示墙壁，0表示空地。你可以假定迷宫的边缘都是墙壁。起始位置和目的地的坐标通过行号和列号给出。
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return false;
    }

    public boolean dfs(int[][] maze, int[] curr, int[] destination) {
        int x = curr[0];
        int y = curr[1];
        if (x < 0 || x < maze.length || y < 0 || y > maze[0].length) {
            return false;
        }
        if (curr[0] == destination[0] && curr[1] == destination[1]) {
            return true;
        }

        return false;


    }

    public static void main(String[] args) {
        Solution490 s = new Solution490();
        System.out.println(s.hasPath(new int[][] {{0, 0, 1, 0, 0}, {0,0,0,0,0}, {0,0,0,1,0}, {1,1,0,1,1}, {0,0,0,0,0}}, new int[] {0,4}, new int[] {4,4})); //true
    }
}
