package jianzhi_offer;

import java.util.LinkedList;
import java.util.Queue;

public class Solution59_I {
    /*
    剑指 Offer 59 - I. 滑动窗口的最大值
    给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k) {
            return new int[0];
        }
        int index = 0;
        int[] res = new int[nums.length-k+1];

        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i=0; i<nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (queue.peekFirst() == (i-k)) {
                queue.pollFirst();
            }
            if (i >= (k-1)) {
                res[index++] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}
