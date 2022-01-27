package medium;

import java.util.*;

public class Solution380 {
    /*
    380. 常数时间插入、删除和获取随机元素
    设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。

    insert(val)：当元素 val 不存在时，向集合中插入该项。
    remove(val)：元素 val 存在时，从集合中移除该项。
    getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
     */
    /** Initialize your data structure here. */
    Map<Integer, Integer> dict;
    List<Integer> list;
    Random rand = new Random();

    public Solution380() {
        dict = new HashMap<Integer,Integer>();
        list = new ArrayList<Integer>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!dict.containsKey(val)) {
            dict.put(val, list.size());
            list.add(list.size(),val);
            return true;
        } else {
            return false;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (dict.containsKey(val)) {
            int lastElement = list.get(list.size()-1);
            int idx = dict.get(val);
            list.set(idx, lastElement);
            dict.put(lastElement, idx);

            list.remove(list.size()-1);
            dict.remove(val);
            return true;
        } else {
            return false;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
