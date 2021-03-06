package medium;

import java.util.LinkedList;
import java.util.List;

public class Solution969 {
    /*
    969. 煎饼排序
    给定数组 A，我们可以对其进行煎饼翻转：我们选择一些正整数 k <= A.length，然后反转 A 的前 k 个元素的顺序。我们要执行零次或多次煎饼翻转（按顺序一次接一次地进行）以完成对数组 A 的排序。

    返回能使 A 排序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * A.length 范围内的有效答案都将被判断为正确。



    示例 1：

    输入：[3,2,4,1]
    输出：[4,2,4,3]
    解释：
    我们执行 4 次煎饼翻转，k 值分别为 4，2，4，和 3。
    初始状态 A = [3, 2, 4, 1]
    第一次翻转后 (k=4): A = [1, 4, 2, 3]
    第二次翻转后 (k=2): A = [4, 1, 2, 3]
    第三次翻转后 (k=4): A = [3, 2, 1, 4]
    第四次翻转后 (k=3): A = [1, 2, 3, 4]，此时已完成排序。
    示例 2：

    输入：[1,2,3]
    输出：[]
    解释：
    输入已经排序，因此不需要翻转任何内容。
    请注意，其他可能的答案，如[3，3]，也将被接受。


    提示：

    1 <= A.length <= 100
    A[i] 是 [1, 2, ..., A.length] 的排列
     */

    LinkedList<Integer> res = new LinkedList<Integer>();
    public List<Integer> pancakeSort(int[] A) {
        sort(A, A.length);
        return res;
    }

    public void sort(int[] nums, int n) {
        if (n == 1) return;
        int maxIndex = 0;
        for (int i=1; i<n; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        //翻转
        reverse(nums, 0, maxIndex);
        res.add(maxIndex+1);
        reverse(nums, 0, n-1);
        res.add(n);

        sort(nums, n-1);


    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] A = {3,2,4,1};
        Solution969 s = new Solution969();
        System.out.println(s.pancakeSort(A));
    }
}
