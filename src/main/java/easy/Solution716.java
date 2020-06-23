package easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution716 {
    /**
     * 716. 最大栈
     * 设计一个最大栈，支持 push、pop、top、peekMax 和 popMax 操作。
     *
     *
     *
     * push(x) -- 将元素 x 压入栈中。
     * pop() -- 移除栈顶元素并返回这个值。
     * top() -- 返回栈顶元素。
     * peekMax() -- 返回栈中最大元素。
     * popMax() -- 返回栈中最大的元素，并将其删除。如果有多个最大元素，只要删除最靠近栈顶的那个
     */

    class MaxStack {
        Stack<Integer> stack;
        Stack<Integer> maxStack;
        /** initialize your data structure here. */
        public MaxStack() {
            stack = new Stack();
            maxStack = new Stack();
        }

        public void push(int x) {
            int max = maxStack.isEmpty() ? x : maxStack.peek();
            maxStack.push(max > x ? max : x); //每次都插入截止到目前为止的最大值
            stack.push(x);
        }

        public int pop() {
            maxStack.pop();
            return stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int peekMax() {
            return maxStack.peek();
        }

        public int popMax() {
            int max = peekMax();
            Stack<Integer> buffer = new Stack();
            while (top() != max) buffer.push(pop());
            pop();
            while (!buffer.isEmpty()) push(buffer.pop());
            return max;

        }
    }

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */



}
