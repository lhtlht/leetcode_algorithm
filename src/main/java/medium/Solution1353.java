package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1353 {
    /*
    1353. 最多可以参加的会议数目
    给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，表示会议 i 开始于 startDayi ，结束于 endDayi 。

    你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。注意，一天只能参加一个会议。

    请你返回你可以参加的 最大 会议数目。
     */

    public int maxEvents(int[][] events) {
        int n = events.length;


        Arrays.sort(events, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        int res = 0;
        int day = 0;
        int id = 0;
        while (id < n || !queue.isEmpty()) {
            if (queue.isEmpty()) {
                queue.add(events[id][1]); //结束时间
                day = events[id++][0];
            }
            while(id < n && events[id][0] <= day){
                queue.add(events[id++][1]);
            }
            if(queue.peek() >= day){
                day++;
                res++;
            }
            queue.poll();
        }

        return res;
    }

    public static void main(String[] args) {
        Solution1353 s = new Solution1353();
        //System.out.println(s.maxEvents(new int[][] {{1,2}, {2,3}, {3,4}})); //3
        //System.out.println(s.maxEvents(new int[][] {{1,4}, {4,4}, {2,2}, {3,4}, {1,1}})); //4
        //System.out.println(s.maxEvents(new int[][] {{1,2}, {2,3}, {3,4}, {1,2}})); //4
        //System.out.println(s.maxEvents(new int[][] {{1,2}, {1,2}, {1,6}, {1,2}, {1,2}})); //3
        System.out.println(s.maxEvents(new int[][] {{27,27},{8,10},{9,11},{20,21},{25,29},{17,20},
                {12,12},{12,12},{10,14},{7,7},{6,10},{7,7},{4,8},{30,31},{23,25},{4,6},{17,17},{13,14},{6,9},{13,14}})); //18
    }
}
