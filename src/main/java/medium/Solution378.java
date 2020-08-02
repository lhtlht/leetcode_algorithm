package medium;

public class Solution378 {
    /*
    378. 有序矩阵中第K小的元素
    给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
    请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。



    示例：

    matrix = [
       [ 1,  5,  9],
       [10, 11, 13],
       [12, 13, 15]
    ],
    k = 8,

    返回 13。
     */

    /*
    二分法


     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (check(matrix, n, k, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int n, int k, int mid) {
        //小于mid的个数和k的比较关系，如果小于mid的个数 大于 k 在扩大 返回true，则往右移动，反之则左
        //从左下角开始搜索
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i+1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }

    public static void main(String[] args) {
        int[][] m1 = {{1,5,9},
                {10,11,13},
                {12,13,15}};
        int[][] m2 = {{-1}};
        int[][] m3 = {{1,2},{1,3}};
        Solution378 s = new Solution378();
        System.out.println(s.kthSmallest(m1,8)); //13
        System.out.println(s.kthSmallest(m2,1)); //-1
        System.out.println(s.kthSmallest(m3,2));//1
    }
}
