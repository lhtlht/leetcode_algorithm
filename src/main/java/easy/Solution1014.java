package easy;

public class Solution1014 {
    /**
     给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
     一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。

     返回一对观光景点能取得的最高分。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/best-sightseeing-pair
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param A
     * @return
     */
    public static int maxScoreSightseeingPair(int[] A) {
        //暴力解法 超出时间限制
        int maxScore = 0;
        for (int i=0; i<A.length-1; i++) {
            for (int j=i+1; j<A.length; j++) {
                int tmp = A[i]+A[j]+i-j;
                if (tmp>maxScore) {
                    maxScore = tmp;
                }
            }
        }
        return maxScore;
    }

    public static int maxScoreSightseeingPair2(int[] A) {
        //1.保存每次j前面 A[i]+i的最大值preMax
        //2.比较当前最大值 preMax+A[j]-j
        int maxScore = 0;
        int preMax = A[0];
        for (int j=1; j<A.length; j++) {
            if (preMax + A[j]-j > maxScore) {
                maxScore = preMax + A[j]-j;
            }
            if (A[j]+j > preMax) {
                preMax = A[j]+j;
            }

        }
        return maxScore;
    }

    public static void main(String[] args) {
        int[] test1 = {8,1,5,2,6};
        System.out.println(Solution1014.maxScoreSightseeingPair(test1));
        System.out.println(Solution1014.maxScoreSightseeingPair2(test1));
    }

}
