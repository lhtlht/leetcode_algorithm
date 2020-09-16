package medium;

public class Solution1131 {
    /*
    1131. 绝对值表达式的最大值
    给你两个长度相等的整数数组，返回下面表达式的最大值：

    |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|

    其中下标 i，j 满足 0 <= i, j < arr1.length。



    示例 1：

    输入：arr1 = [1,2,3,4], arr2 = [-1,4,5,6]
    输出：13
    示例 2：

    输入：arr1 = [1,-2,-5,0,10], arr2 = [0,-2,-1,-7,-4]
    输出：20
     */
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int ans = 0;
        int n = arr1.length;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                ans = Math.max(ans, Math.abs(arr1[i]-arr1[j]) + Math.abs(arr2[i]-arr2[j]) + Math.abs(i-j));
            }
        }
        return ans;
    }
    public int maxAbsValExpr2(int[] arr1, int[] arr2) {
        /*
        |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|

         =  (arr1[i] + arr2[i] + i) - (arr1[j] + arr2[j] + j)
         =  (arr1[i] + arr2[i] - i) - (arr1[j] + arr2[j] - j)
         =  (arr1[i] - arr2[i] + i) - (arr1[j] - arr2[j] + j)
         =  (arr1[i] - arr2[i] - i) - (arr1[j] - arr2[j] - j)
         = -(arr1[i] + arr2[i] + i) + (arr1[j] + arr2[j] + j)
         = -(arr1[i] + arr2[i] - i) + (arr1[j] + arr2[j] - j)
         = -(arr1[i] - arr2[i] + i) + (arr1[j] - arr2[j] + j)
         = -(arr1[i] - arr2[i] - i) + (arr1[j] - arr2[j] - j)

        因为存在四组两两等价的展开，所以可以优化为四个表达式：
        A = arr1[i] + arr2[i] + i
        B = arr1[i] + arr2[i] - i
        C = arr1[i] - arr2[i] + i
        D = arr1[i] - arr2[i] - i

        max( |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|)
        = max(max(A) - min(A),
              max(B) - min(B),
              max(C) - min(C),
              max(D) - min(D))
         */
        int n = arr1.length;
        int[] A = new int[2];
        int[] B = new int[2];
        int[] C = new int[2];
        int[] D = new int[2];
        A[1] = Integer.MAX_VALUE;
        B[1] = Integer.MAX_VALUE;
        C[1] = Integer.MAX_VALUE;
        D[1] = Integer.MAX_VALUE;
        A[0] = Integer.MIN_VALUE;
        B[0] = Integer.MIN_VALUE;
        C[0] = Integer.MIN_VALUE;
        D[0] = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            A[0] = Math.max(arr1[i]+arr2[i]+i, A[0]);
            A[1] = Math.min(arr1[i]+arr2[i]+i, A[1]);
            B[0] = Math.max(arr1[i]+arr2[i]-i, B[0]);
            B[1] = Math.min(arr1[i]+arr2[i]-i, B[1]);
            C[0] = Math.max(arr1[i]-arr2[i]+i, C[0]);
            C[1] = Math.min(arr1[i]-arr2[i]+i, C[1]);
            D[0] = Math.max(arr1[i]-arr2[i]-i, D[0]);
            D[1] = Math.min(arr1[i]-arr2[i]-i, D[1]);
        }
        return Math.max(Math.max(A[0]-A[1], B[0]-B[1]), Math.max(C[0]-C[1],D[0]-D[1]));
    }
    public static void main(String[] args) {
        Solution1131 s = new Solution1131();
        System.out.println(s.maxAbsValExpr2(new int[] {1,2,3,4}, new int[] {-1, 4,5,6})); //13
        System.out.println(s.maxAbsValExpr2(new int[] {1,-2,-5,0,10}, new int[] {0,-2,-1, -7, -4})); //20
        System.out.println(s.maxAbsValExpr2(new int[] {1,-2}, new int[] {8,8})); //4
    }
}
