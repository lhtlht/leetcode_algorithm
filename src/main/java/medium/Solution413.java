package medium;

public class Solution413 {
    /*
    413. 等差数列划分
    如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。

    例如，以下数列为等差数列:

    1, 3, 5, 7, 9
    7, 7, 7, 7
    3, -1, -5, -9
    以下数列不是等差数列。

    1, 1, 2, 5, 7


    数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。

    如果满足以下条件，则称子数组(P, Q)为等差数组：

    元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。

    函数要返回数组 A 中所有为等差数组的子数组个数。



    示例:

    A = [1, 2, 3, 4]

    返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
     */
    public int numberOfArithmeticSlices(int[] A) {
        //查找规律，若数组连续3个数都是等差，则个数递增也是等差为1，例如【1,2,3,4,5,6】 = 1+2+3+4
        int n = A.length;
        if (n < 3) {
            return 0;
        }
        int[] dp =new int[n];
        int sum = 0;
        for (int i=2; i<n; i++) {
            if ((A[i]-A[i-1]) == (A[i-1]-A[i-2])) {
                dp[i] = dp[i-1]+1;
                sum += dp[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution413 s = new Solution413();
        System.out.println(s.numberOfArithmeticSlices(new int[] {1,2,3,4})); //3
    }
}
