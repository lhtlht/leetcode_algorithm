package easy;

import java.util.ArrayList;
import java.util.List;

public class PRO54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = cols-1;
        int top = 0;
        int bottom = rows - 1;
        //从（left，top）开始遍历，到（right，bottom）截止
        while (left <= right && top <= bottom) {
            for (int col=left; col<=right; col++) {
                res.add(matrix[top][col]);
            }
            for (int row=top+1; row<=bottom; row++){
                res.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int col=right-1; col>left; col--){
                    res.add(matrix[bottom][col]);
                }
                for (int row=bottom; row>top; row--){
                    res.add(matrix[row][left]);
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }

    public static void main(String[] args) {
        PRO54 p = new PRO54();
        System.out.println(p.spiralOrder(new int[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        }));
        System.out.println(p.spiralOrder(new int[][] {
                {1,2,3}
        }));
        System.out.println(p.spiralOrder(new int[][] {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        }));
    }
}
