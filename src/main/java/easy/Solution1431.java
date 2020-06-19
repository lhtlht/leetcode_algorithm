package easy;

import java.util.ArrayList;
import java.util.List;

public class Solution1431 {
    /**
     给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。

     对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     输入：candies = [2,3,5,1,3], extraCandies = 3
     输出：[true,true,true,false,true]

     * @param candies
     * @param extraCandies
     * @return
     */
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> result = new ArrayList<Boolean>();
        int maxCandies = candies[0];
        for (int i=1; i<candies.length; i++) {
            if (candies[i]>maxCandies) {
                maxCandies = candies[i];
            }
        }
        for (int i=0; i<candies.length; i++) {
            if (candies[i]+extraCandies>=maxCandies) {
                result.add(true);
            } else {
                result.add(false);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] candies1 = {2,3,5,1,3};
        int extraCand = 3;
        List<Boolean> res = Solution1431.kidsWithCandies(candies1, extraCand);
        System.out.println(res);


    }
}
