package easy;

import java.util.HashMap;

public class Solution961 {
    /*
    961. 重复 N 次的元素
    在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。

    返回重复了 N 次的那个元素。
     提示：

    4 <= A.length <= 10000
    0 <= A[i] < 10000
    A.length 为偶数
     */
    public int repeatedNTimes(int[] A) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i],0)+1);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) == A.length/2) {
                return key;
            }
        }
        return -1;
    }

    public int repeatedNTimes2(int[] A) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<A.length; i++) {
            if (map.containsKey(A[i])) {
                return A[i];
            } else {
                map.put(A[i],1);
            }
        }
        return -1;
    }

    public int repeatedNTimes3(int[] A) {
        for (int i=0; i<A.length-2; i++) {
            if (A[i] == A[i+1] || A[i] == A[i+2]) {
                return A[i];
            }
        }
        return A[A.length-1];
    }
}
