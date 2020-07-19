package easy;

import java.util.*;

public class Solution170 {
    /*
    170. 两数之和 III - 数据结构设计
    设计并实现一个 TwoSum 的类，使该类需要支持 add 和 find 的操作。

    add 操作 -  对内部数据结构增加一个数。
    find 操作 - 寻找内部数据结构中是否存在一对整数，使得两数之和与给定的数相等。

    示例 1:

    add(1); add(3); add(5);
    find(4) -> true
    find(7) -> false
    示例 2:

    add(3); add(1); add(2);
    find(3) -> true
    find(6) -> false
     */

    public static  class TwoSum {
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
        /** Initialize your data structure here. */
        public TwoSum() {

        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            freq.put(number, freq.getOrDefault(number,0)+1);
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            for (Integer key : freq.keySet()) {
                int other = value - key;
                if (other == key && freq.get(key)>1){
                    return true;
                }
                if (other != key && freq.containsKey(other)) {
                    return true;
                }
            }
            return false;
        }
    }


    public static  class TwoSum2 { //add 超出时间限制
        Set<Integer> sums = new HashSet<Integer>();
        List<Integer> nums = new ArrayList<Integer>();

        /** Initialize your data structure here. */
        public void TwoSum() {
            return ;
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            for (int n:nums) {
                sums.add(n + number);
            }
            nums.add(number);
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            return sums.contains(value);
        }
    }


    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
    }
}
