package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution56 {
    /*
    56. 合并区间
    给出一个区间的集合，请合并所有重叠的区间。

    示例 1:

    输入: [[1,3],[2,6],[8,10],[15,18]]
    输出: [[1,6],[8,10],[15,18]]
    解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
    示例 2:

    输入: [[1,4],[4,5]]
    输出: [[1,5]]
    解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间
     */

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;
        //以end升序排序 //区间最多有多少个互不相交的区间
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });


        List<int[]> res = new ArrayList<int[]>();
        res.add(intervals[0]);

        for (int[] curr : intervals) {
            int[] last = res.get(res.size()-1);
            if (curr[0] <= last[1]) {
                last[1] = Math.max(last[1], curr[1]);
            } else {
                res.add(curr);
            }

        }

        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {

    }
}
