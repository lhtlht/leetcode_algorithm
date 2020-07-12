package medium;

import java.util.Arrays;
import java.util.Comparator;

public class Solution435 {
    /*
    435. 无重叠区间
    给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。

    注意:
    可以认为区间的终点总是大于它的起点。
    区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
    示例 1:
    输入: [ [1,2], [2,3], [3,4], [1,3] ]
    输出: 1
    解释: 移除 [1,3] 后，剩下的区间没有重叠。

    示例 2:
    输入: [ [1,2], [1,2], [1,2] ]
    输出: 2
    解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。

    示例 3:
    输入: [ [1,2], [2,3] ]
    输出: 0
    解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
     */

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        //以end升序排序 //区间最多有多少个互不相交的区间
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        int count = 1;
        int x_end = intervals[0][1];
        for (int[] inter: intervals) {
            int start = inter[0];
            if (start >= x_end) {
                count ++;
                x_end = inter[1];
            }
        }
        return intervals.length - count;

    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1,2}, {2,3}, {3,4}, {1,3}};
        int[][] intervals2 = {{1,2}, {1,2}, {1,2}};
        int[][] intervals3 = {{1,2}, {2,3}};
        Solution435 s = new Solution435();
        System.out.println(s.eraseOverlapIntervals(intervals1));//1
        System.out.println(s.eraseOverlapIntervals(intervals2));//2
        System.out.println(s.eraseOverlapIntervals(intervals3));//0

    }
}
