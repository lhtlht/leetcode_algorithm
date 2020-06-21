package easy;

import com.sun.xml.internal.ws.encoding.MtomCodec;

public class Solution1103 {
    /**
     * 1103. 分糖果 II
     * 排排坐，分糖果。
     *
     * 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
     *
     * 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
     *
     * 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
     *
     * 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。
     *
     * 返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
     */

    public static int[] distributeCandies(int candies, int num_people) {
        /**
         * 利用等差数列的思路，等差数列的和，以及等差数列第n表达
         */
        int res[] = new int[num_people];
        int p = (int)((Math.sqrt(2*candies + 0.25)) - 0.5);  //发的次数+1
        int resCandie = candies - (int)(Math.pow(p,2)+p)/2;
        int n = p/num_people;
        int m = p%num_people;
        for (int i=0; i<num_people; i++) {
            res[i] = (i+1)*n + (n*(n-1)*num_people)/2;
        }
        for (int j=0; j<m+1; j++) {
            if (j==m) {
                res[j] += resCandie;
            } else {
                res[j] += (j+1) + (n)*num_people;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int candies = 44;
        int num_people = 5;
        int[] res = Solution1103.distributeCandies(candies, num_people);
        for (int i:res) {
            System.out.print(i + " ");
        }
    }
}
