package easy;

import java.util.HashMap;
import java.util.HashSet;

public class Solution1346 {
    /*
    1346. 检查整数及其两倍数是否存在
    给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。

    更正式地，检查是否存在两个下标 i 和 j 满足：

    i != j
    0 <= i, j < arr.length
    arr[i] == 2 * arr[j]
     */

    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : arr) {
            if (set.contains(2 * i) || (i % 2 == 0 && set.contains(i / 2)))
                return true;
            set.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution1346 s = new Solution1346();
        System.out.println(s.checkIfExist(new int[] {10,2,5,3}));
    }
}
