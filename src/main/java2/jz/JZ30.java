package jz;

import java.util.Stack;

public class JZ30 {
    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.min();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.min();   --> 返回 -2.
     *
     */
    /** initialize your data structure here. */
    Stack<Integer> s1;
    Stack<Integer> s2;
    public JZ30() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    public void push(int x) {
        s1.push(x);
        if (s2.empty() || x <= min()) {
            s2.add(x);
        }
    }

    public void pop() {
        if(s1.pop().equals(s2.peek())) {
            s2.pop();
        }

    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return s2.peek();
    }
}
