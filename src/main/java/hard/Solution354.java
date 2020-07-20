package hard;

import java.util.Arrays;
import java.util.Comparator;

public class Solution354 {
    /*
    354. 俄罗斯套娃信封问题
    给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。

    请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。

    说明:
    不允许旋转信封。

    示例:

    输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
    输出: 3
    解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
     */

    public int maxEnvelopes(int[][] envelopes) {
        //排序，先按w正排，再按h倒排
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0]? o2[1]-o1[1]:o1[0]-o2[0];
            }
        });

        //按照h求最长子序列
        int[] nums = new int[envelopes.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = envelopes[i][1];
        }
        return lengthOfLIS2(nums);

    }

    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length==0) return 0;
        int[] top = new int[nums.length]; //初始化堆
        int piles = 0; //初始化堆的数量为0

        for (int i=0; i<nums.length; i++) {
            int poker = nums[i]; // 要处理的扑克牌
            //二分查找合适的堆
            int left = 0, right = piles;
            while (left < right) {
                int mid = left + (right-left)/2;
                if (poker > top[mid]) {
                    left = mid + 1;
                } else if (poker < top[mid]) {
                    right = mid;
                } else {
                    right = mid;
                }


            }

            //
            if (left == piles) piles++;
            top[left] = poker;


        }
        return piles;



    }


    public static void main(String[] args) {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};

        Solution354 s = new Solution354();
        System.out.println(s.maxEnvelopes(envelopes)); //3
    }


}
