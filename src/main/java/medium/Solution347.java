package medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution347 {
    /*
    347. 前 K 个高频元素
    给定一个非空的整数数组，返回其中出现频率前 k 高的元素。



    示例 1:

    输入: nums = [1,1,1,2,2,3], k = 2
    输出: [1,2]
    示例 2:

    输入: nums = [1], k = 1
    输出: [1]


    提示：

    你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
    你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
    题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
    你可以按任意顺序返回答案。
     */

    public int[] topKFrequent(int[] nums, int k) {
        final HashMap<Integer, Integer> nmap;
        nmap = new HashMap<Integer, Integer>();
        for (int num : nums) {
            nmap.put(num, nmap.getOrDefault(num,0)+1);
        }

        //最大堆
        //Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> (nmap.get(o2) - nmap.get(o1)));
        Queue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return nmap.get(o2)-nmap.get(o1);
            }
        });

        for (int key : nmap.keySet()) {
            pq.add(key);
        }

        int[] res = new int[k];
        for (int i=0; i<k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        Solution347 s = new Solution347();
        int[] res = s.topKFrequent(nums, 2);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
