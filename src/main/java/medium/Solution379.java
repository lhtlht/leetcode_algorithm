package medium;

import java.util.LinkedList;
import java.util.Queue;

public class Solution379 {
    /*
    379. 电话目录管理系统
    设计一个电话目录管理系统，让它支持以下功能：

    get: 分配给用户一个未被使用的电话号码，获取失败请返回 -1
    check: 检查指定的电话号码是否被使用
    release: 释放掉一个电话号码，使其能够重新被分配
     */

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    private int maxNumber;
    private int[] phones;
    private LinkedList<Integer> getPhones = new LinkedList<Integer>();
    public Solution379(int maxNumbers) {
        this.maxNumber = maxNumbers;
        this.phones = new int[maxNumbers];
        for (int i=0; i<maxNumbers; i++) {
            this.getPhones.add(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (getPhones.size() > 0) {
            int num = getPhones.poll();
            phones[num] = 1;
            return num;
        } else {
            return -1;
        }
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return number < maxNumber && phones[number] == 0;
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (!check(number)) {
            phones[number] = 0;
            getPhones.add(number);
        }
    }
}
