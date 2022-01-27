package jz;

public class JZ04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) return false;
        int m = matrix[0].length;
        int row = 0;
        int col = m-1;
        while (row < n && col >= 0) {
            int num = matrix[row][col];
            if(num == target) {
                return true;
            } else if (num > target) {
                col --;
            } else {
                row ++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JZ04 j = new JZ04();
        System.out.println(j.findNumberIn2DArray(new int[][] {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, 19));

        System.out.println(j.findNumberIn2DArray(new int[][] {
                {-1},
                {-1}
        }, -2));

        System.out.println(j.findNumberIn2DArray(new int[][] {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        }, 19));


    }
}
