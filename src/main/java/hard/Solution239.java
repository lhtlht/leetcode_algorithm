package hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.DelayQueue;

public class Solution239 {
    /*
    239. 滑动窗口最大值
    给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
    返回滑动窗口中的最大值。

    进阶：
    你能在线性时间复杂度内解决此题吗？
    示例:
    输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
    输出: [3,3,5,5,6,7]
    解释:
      滑动窗口的位置                最大值
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7

    提示：
    1 <= nums.length <= 10^5
    -10^4 <= nums[i] <= 10^4
    1 <= k <= nums.length
     */
    class MonotonicQueue {
        public Deque<Integer> data = new LinkedList<Integer>();
        public void push(int n) {
            //System.out.println(n);
            while (!data.isEmpty() && data.peekLast() < n)
                data.pollLast();
            data.addLast(n);
        }
        int max() { return data.peekFirst(); }

        void pop(int n) {
            if (!data.isEmpty() && data.peekFirst() == n)
                data.pollFirst();
        }
    };
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();

        int[] res = new int[nums.length - k + 1];
        int j = 0;
        for (int i=0; i<nums.length; i++) {
            if (i < k-1){
                window.push(nums[i]); //先填满初始窗口
            } else {
                window.push(nums[i]);
                res[j] = window.max();
                j ++;
                window.pop(nums[i - k +1]);
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        Solution239 s = new Solution239();
        int[] res = s.maxSlidingWindow(nums, k);  //[3,3,5,5,6,7]
        for (int i : res) {
            System.out.println(i + " ");
        }
    }
}
