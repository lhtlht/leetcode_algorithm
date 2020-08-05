package medium;

public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;

        int i = m-1;
        int j = 0;
        while (i >= 0 && j < n) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target > matrix[i][j]) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] m = {
              {1,   4,  7, 11, 15},
              {2,   5,  8, 12, 19},
              {3,   6,  9, 16, 22},
              {10, 13, 14, 17, 24},
              {18, 21, 23, 26, 30}
        };

        Solution240 s = new Solution240();
        System.out.println(s.searchMatrix(m, 5)); //true
        System.out.println(s.searchMatrix(m,20)); //false
    }

}
