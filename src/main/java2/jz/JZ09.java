package jz;

import java.util.Stack;

public class JZ09 {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public JZ09() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (s1.empty()) {
            return -1;
        }
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
        int res = s2.pop();
        while (!s2.empty()) {
            s1.push(s2.pop());
        }
        return res;
    }
}
