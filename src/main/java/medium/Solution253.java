package medium;

import java.util.Arrays;
import java.util.Comparator;

public class Solution253 {
    /*
    253. 会议室 II
    给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，为避免会议冲突，同时要考虑充分利用会议室资源，
    请你计算至少需要多少间会议室，才能满足这些会议安排。

    示例 1:

    输入: [[0, 30],[5, 10],[15, 20]]
    输出: 2
    示例 2:

    输入: [[7,10],[2,4]]
    输出: 1
     */

    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        int count = 1;



        for (int i=0; i<intervals.length-1; i++) {
            if (intervals[i][1] > intervals[i+1][0]) {
                count++;
            }
        }

        return count;

    }

    public static void main(String[] args) {
        int[][] intervals = {{0, 30},{5, 10},{15, 20}};
        Solution253 s = new Solution253();
        System.out.println(s.minMeetingRooms(intervals));
    }
}
