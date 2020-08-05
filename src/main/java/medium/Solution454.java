package medium;

import java.util.HashMap;

public class Solution454 {
    /*
    454. 四数相加 II
    给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。

    为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。

    例如:

    输入:
    A = [ 1, 2]
    B = [-2,-1]
    C = [-1, 2]
    D = [ 0, 2]

    输出:
    2

    解释:
    两个元组如下:
    1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
    2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
     */

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if(map.containsKey(A[i]+B[j])) map.put(A[i]+B[j],map.get(A[i]+B[j])+1);
                else map.put(A[i]+B[j],1);

            }
        }

        int res = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (map.containsKey(-(C[i]+D[j]))) {
                    res += map.get(-(C[i]+D[j]));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
