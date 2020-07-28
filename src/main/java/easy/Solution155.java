package easy;

import java.util.Stack;

public class Solution155 {
    /*
    155. 最小栈
    设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

    push(x) —— 将元素 x 推入栈中。
    pop() —— 删除栈顶的元素。
    top() —— 获取栈顶元素。
    getMin() —— 检索栈中的最小元素。
     */

    static class  MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<Integer>();
            minStack = new Stack<Integer>();
        }

        public void push(int x) {
            stack.push(x);
            if(minStack.isEmpty() || x <= minStack.peek())
                minStack.push(x);
        }

        public void pop() {
            if(stack.pop().equals(minStack.peek()))
                minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(0);
        s.push(1);
        s.push(0);
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
    }
}
