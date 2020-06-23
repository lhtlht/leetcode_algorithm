package easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution949 {
    public PriorityQueue<String> queue;
    public String largestTimeFromDigits(int[] A) {

        //PriorityQueue<String> queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue = new PriorityQueue<String>();
        Arrays.sort(A);
        dfs(A, new boolean[4], 0, 0, 0);
        if (queue.isEmpty()) {
            return "";
        }
        return queue.poll();



    }


    public void dfs(int[] nums, boolean[] book, int hour, int minute, int used) {
        if (used == 4) {
            StringBuilder sb = new StringBuilder();
            if (hour < 10) {
                sb.append("0");
            }
            sb.append(hour);
            sb.append(":");
            if (minute < 10) {
                sb.append("0");
            }
            sb.append(minute);
            queue.offer(sb.toString());
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (used >= 2) {
                if (!book[i] && minute * 10 + nums[i] < 60) {
                    book[i] = true;
                    dfs(nums, book, hour, minute * 10 + nums[i], used + 1);
                    book[i] = false;
                }
            } else {
                //used = 0 或 1
                if (!book[i] && hour * 10 + nums[i] < 24) {
                    book[i] = true;
                    dfs(nums, book, hour * 10 + nums[i], 0, used + 1);
                    book[i] = false;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        //System.out.println(Solution949.largestTimeFromDigits(nums)); // "23:41"


    }
}
