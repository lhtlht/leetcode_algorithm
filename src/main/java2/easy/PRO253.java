package easy;

import java.util.Arrays;
import java.util.Comparator;

public class PRO253 {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        //没有会议
        if (n == 0) {
            return 0;
        }
        Integer[] startIntervals = new Integer[n];
        Integer[] endIntervals = new Integer[n];
        for (int i=0; i<n; i++) {
            startIntervals[i] = intervals[i][0];
            endIntervals[i] = intervals[i][1];
        }
        Arrays.sort(startIntervals, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        Arrays.sort(endIntervals, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        int startPoint = 0;
        int endPoint = 0;
        int res = 0;
        while (startPoint < n) {
            //如果开始时间大于结束时间,证明可以有空出的会议室
            if (startIntervals[startPoint] >= endIntervals[endPoint]){
                res -= 1;
                endPoint += 1;
            }
            res += 1;
            startPoint += 1;
        }

        return res;
    }

    public static void main(String[] args) {
        PRO253 p = new PRO253();
        System.out.println(p.minMeetingRooms(new int[][] {{0,30},{5,10},{15,20}})); //2
        System.out.println(p.minMeetingRooms(new int[][] {{7,10},{2,4}})); //1
        System.out.println(p.minMeetingRooms(new int[][] {{9,10}, {4,9}, {4,17}})); //2
        System.out.println(p.minMeetingRooms(new int[][] {{2,11}, {6,16}, {11,16}})); //2
    }

}
