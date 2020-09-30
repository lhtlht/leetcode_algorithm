package jianzhi_offer;

import java.util.ArrayList;
import java.util.List;

public class Solution57_II {
    /*
    剑指 Offer 57 - II. 和为s的连续正数序列
    输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

    序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。



    示例 1：

    输入：target = 9
    输出：[[2,3,4],[4,5]]
    示例 2：

    输入：target = 15
    输出：[[1,2,3,4,5],[4,5,6],[7,8]]
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<int[]>();
        int i = 1;
        int j = 1;
        int sum = 0;
        int end = target/2;

        while (i <= end) {
            if (sum < target) {
                sum += j;
                j++;
            } else if (sum > target) {
                sum -= i;
                i++;
            } else {
                int[] arr = new int[j-i];
                for (int k=0; k<j-i; k++) {
                    arr[k] = i+k;
                }
                res.add(arr);
                sum -= i;
                i++;
            }

        }
        return res.toArray(new int[res.size()][]);


    }

    public static void main(String[] args) {
        Solution57_II s = new Solution57_II();
        int[][] res = s.findContinuousSequence(15);
        for (int[] sub : res) {
            for (int num : sub) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}
